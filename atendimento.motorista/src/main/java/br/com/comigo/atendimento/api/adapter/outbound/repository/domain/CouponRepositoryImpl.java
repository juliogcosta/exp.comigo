package br.com.comigo.atendimento.api.adapter.outbound.repository.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.comigo.atendimento.api.adapter.outbound.entity.JpaCoupon;
import br.com.comigo.atendimento.api.adapter.outbound.repository.jpa.JpaCouponRepository;
import br.com.comigo.atendimento.api.domain.data.Coupon;
import br.com.comigo.atendimento.api.domain.data.Event;
import br.com.comigo.atendimento.api.domain.repository.CouponRepository;
import br.com.comigo.atendimento.api.mapper.CouponMapper;

@Repository
public class CouponRepositoryImpl implements CouponRepository {
    private final JpaCouponRepository jpaCouponRepository;
    private final CouponMapper couponMapper;

    public CouponRepositoryImpl(JpaCouponRepository jpaCouponRepository, CouponMapper couponMapper) {
        this.jpaCouponRepository = jpaCouponRepository;
        this.couponMapper = couponMapper;
    }

    @Override
    public Coupon save(Coupon coupon) {
        final JpaCoupon jpaCoupon = new JpaCoupon(coupon);
        this.jpaCouponRepository.save(jpaCoupon);
        return new Coupon(jpaCoupon.getId(),
            jpaCoupon.getCode(),
            jpaCoupon.getDiscount(),
            jpaCoupon.getValid());
    }

    @Override
    public Optional<Coupon> findById(Long id) {
        final Optional<JpaCoupon> optional = this.jpaCouponRepository.findById(id);
        return optional.map(couponMapper::toDomain);
    }

    @Override
    public List<Coupon> findByEvent(Event event) {
        final List<JpaCoupon> jpaCoupons = this.jpaCouponRepository.findByJpaEvent_Id(event.getId());
        return jpaCoupons.stream()
            .map(couponMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Coupon> findByEventAndValidAfter(Event event, Date since) {
        final List<JpaCoupon> jpaCoupons = this.jpaCouponRepository.findByJpaEvent_IdAndValidAfter(event.getId(), since);
        if (jpaCoupons.isEmpty()) {
            return List.of();
        }
        return jpaCoupons.stream()
            .map(couponMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Coupon> findByEventAndValid(Event event, Date date) {
        final List<JpaCoupon> jpaCoupons = this.jpaCouponRepository.findByJpaEvent_IdAndValid(event.getId(), date);
        if (jpaCoupons.isEmpty()) {
            return List.of();
        }
        return jpaCoupons.stream()
            .map(couponMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpaCouponRepository.deleteById(id);
    }
}