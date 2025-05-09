package br.com.comigo.atendimento.api.application.aggregate.service.event;

import org.springframework.stereotype.Service;

import br.com.comigo.atendimento.api.adapter.aggregate.event.dto.CouponRequestDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.event.outbound.JpaEvent;
import br.com.comigo.atendimento.api.adapter.aggregate.event.outbound.repository.JpaEventRepository;
import br.com.comigo.atendimento.api.domain.aggregate.event.Coupon;
import br.com.comigo.atendimento.api.domain.aggregate.event.Event;
import br.com.comigo.atendimento.api.domain.aggregate.event.repository.CouponRepository;
import br.com.comigo.atendimento.api.mapper.aggregate.event.EventMapper;

import java.util.Date;
import java.util.List;

@Service
public class CouponServiceImpl {

    private final CouponRepository couponRepository;
    private final JpaEventRepository eventRepository;
    private final EventMapper eventMapper;

    public CouponServiceImpl(CouponRepository couponRepository, JpaEventRepository eventRepository, EventMapper eventMapper) {
        this.couponRepository = couponRepository;
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public Coupon addCouponToEvent(Long eventId, CouponRequestDTO couponData) {
        JpaEvent jpaEvent = eventRepository.findById(eventId)
            .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Coupon coupon = new Coupon();
        coupon.setCode(couponData.code());
        coupon.setDiscount(couponData.discount());
        coupon.setValid(new Date(couponData.valid()));
        coupon.setEvent(this.eventMapper.toDomain(jpaEvent));
        return couponRepository.save(coupon);
    }

    public List<Coupon> consultCoupons(Event event, Date currentDate) {
        return couponRepository.findByEventAndValidAfter(event, currentDate);
    }
}
