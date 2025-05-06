package br.com.comigo.atendimento.api.application.usecase;

import java.util.Date;
import java.util.List;

import br.com.comigo.atendimento.api.adapter.inbound.dto.EventDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.EventRequestDTO;
import br.com.comigo.atendimento.api.adapter.inbound.dto.EventResponseDTO;

public interface EventUseCases {
    EventResponseDTO create(EventRequestDTO dto);

    List<EventResponseDTO> getUpcommingEvents(int page, int size);

    EventDTO getEventDetails(Long id);

    List<EventResponseDTO> searchEvents(String title);

    public List<EventResponseDTO> getFilteredEvents(int page, int size, String city, String state, Date startDate, Date endDate);

    void deleteEvent(Long id, String adminKey);
}
