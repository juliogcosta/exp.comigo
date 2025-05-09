package br.com.comigo.atendimento.api.application.service.event;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.event.AddressRequestDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.event.EventDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.event.EventRequestDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.aggregate.event.EventResponseDTO;
import br.com.comigo.atendimento.api.application.usecase.EventUseCases;
import br.com.comigo.atendimento.api.domain.aggregate.event.Address;
import br.com.comigo.atendimento.api.domain.aggregate.event.Coupon;
import br.com.comigo.atendimento.api.domain.aggregate.event.Event;
import br.com.comigo.atendimento.api.domain.aggregate.event.repository.EventRepository;
import br.com.comigo.atendimento.api.domain.projection.EventAddressProjection;
import br.com.comigo.atendimento.api.domain.util.Pagination;
import br.com.comigo.atendimento.api.mapper.aggregate.event.EventMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EventServiceImpl implements EventUseCases {

    @Value("${admin.key}")
    private String adminKey;

    private final EventRepository eventRepository;
    private final AddressServiceImpl addressService;
    private final CouponServiceImpl couponService;
    private final EventMapper mapper;

    public EventServiceImpl(EventRepository eventRepository, AddressServiceImpl addressService, CouponServiceImpl couponService, EventMapper mapper) {
        this.eventRepository = eventRepository;
        this.addressService = addressService;
        this.couponService = couponService;
        this.mapper = mapper;
    }

    @Transactional
    public EventResponseDTO create(EventRequestDTO eventRequestDTO) {
        log.info(" > eventRequestDTO: {}", eventRequestDTO);
        Event event = mapper.toDomain(eventRequestDTO);
        log.info(" > event: {}", event);
        event = this.eventRepository.save(event);
        log.info(" > event created: {}", event);
        
        if (eventRequestDTO.remote()) {
            return this.mapper.toResponseDto(event, Optional.of(new Address()));   
        } else {
            AddressRequestDTO addressRequestDTO = new AddressRequestDTO(eventRequestDTO.city(), eventRequestDTO.state());
            Address address = this.addressService.addAddressToEvent(event.getId(), addressRequestDTO);
            return this.mapper.toResponseDto(event, Optional.of(address));
        }
    }

    @Override
    public List<EventResponseDTO> getUpcommingEvents(int page, int size) {
        Pagination<EventAddressProjection> eventsPagination = 
            this.eventRepository.findUpcommingEvents(new Date(), page, size);
        
        return eventsPagination.getContent().stream()
            .map(event -> new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getDate().getTime(),
                event.getCity() != null ? event.getCity() : "",
                event.getState() != null ? event.getState() : "",
                event.getRemote(),
                event.getEventUrl()))
            .toList();
    }

    public EventDTO getEventDetails(Long eventId) {
        Event event = this.eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Optional<Address> address = addressService.findByEvent(event);

        List<Coupon> coupons = couponService.consultCoupons(event, new Date());

        return this.mapper.toDto(event, address, coupons);
    }

    public List<EventResponseDTO> searchEvents(String title) {
        title = (title != null) ? title : "";

        List<EventAddressProjection> eventsList = this.eventRepository.findEventsByTitle(title);
        return eventsList.stream().map(event -> new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getDate().getTime(),
                event.getCity() != null ? event.getCity() : "",
                event.getState() != null ? event.getState() : "",
                event.getRemote(),
                event.getEventUrl()))
            .toList();
    }

    public List<EventResponseDTO> getFilteredEvents(int page, int size, String city, String state, Date startDate, Date endDate) {
        city = (city != null) ? city : "";
        state = (state != null) ? state : "";
        startDate = (startDate != null) ? startDate : new Date(0);
        endDate = (endDate != null) ? endDate : new Date();

        Pagination<EventAddressProjection> eventsPagination = this.eventRepository.findFilteredEvents(city, state, startDate, endDate, page, size);
        return eventsPagination.getContent().stream().map(event -> new EventResponseDTO(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getDate().getTime(),
                event.getCity() != null ? event.getCity() : "",
                event.getState() != null ? event.getState() : "",
                event.getRemote(),
                event.getEventUrl()))
            .toList();
    }

    public void deleteEvent(Long eventId, String adminKey) {
        if (adminKey == null || !adminKey.equals(this.adminKey)) {
            throw new IllegalArgumentException("Invalid admin key");
        }

        this.eventRepository.deleteById(eventId);
    }
}
