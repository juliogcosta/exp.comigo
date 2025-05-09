package br.com.comigo.atendimento.api.domain.aggregate.event.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.comigo.atendimento.api.domain.aggregate.event.Coupon;
import br.com.comigo.atendimento.api.domain.aggregate.event.Event;

public interface CouponRepository {
    Coupon save(Coupon coupon);

    Optional<Coupon> findById(Long id);

    List<Coupon> findByEvent(Event event);

    List<Coupon> findByEventAndValidAfter(Event event, Date date);

    List<Coupon> findByEventAndValid(Event event, Date date);

    void deleteById(Long id);
}