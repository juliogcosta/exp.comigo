package br.com.comigo.atendimento.api.mapper.aggregate.event;

import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import br.com.comigo.atendimento.api.adapter.aggregate.event.dto.CouponRequestDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.event.dto.CouponResponseDTO;
import br.com.comigo.atendimento.api.adapter.aggregate.event.outbound.JpaCoupon;
import br.com.comigo.atendimento.api.domain.aggregate.event.Coupon;

@Mapper(componentModel = "spring")
public interface CouponMapper {

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(source = "couponRequestDTO.code", target = "code"),
        @Mapping(source = "couponRequestDTO.discount", target = "discount"),
        @Mapping(source = "couponRequestDTO.valid", target = "valid", qualifiedByName = "epochToDate"),
        @Mapping(target = "event", ignore = true)
    })
    @SuppressWarnings("UnmappedTargetProperties")
    Coupon toDomain(CouponRequestDTO couponRequestDTO);

    @Mappings({
        @Mapping(source = "coupon.code", target = "code"),
        @Mapping(source = "coupon.discount", target = "discount"),
        @Mapping(source = "coupon.valid", target = "valid", qualifiedByName = "dateToEpoch")
    })
    CouponRequestDTO toDto(Coupon coupon);

    @Mappings({
        @Mapping(source = "coupon.code", target = "code"),
        @Mapping(source = "coupon.discount", target = "discount"),
        @Mapping(source = "coupon.valid", target = "valid")
    })
    CouponResponseDTO toResponseDto(Coupon coupon);

    @Mappings({
        @Mapping(source = "jpaCoupon.code", target = "code"),
        @Mapping(source = "jpaCoupon.discount", target = "discount"),
        @Mapping(source = "jpaCoupon.valid", target = "valid"),
        @Mapping(source = "jpaCoupon.id", target = "id"),
        @Mapping(target = "event", ignore = true)
    })
    Coupon toDomain(JpaCoupon jpaCoupon);

    @Named("epochToDate")
    default Date epochToDate(Long timestamp) {
        return timestamp != null ? new Date(timestamp) : null;
    }

    @Named("dateToEpoch")
    default Long dateToEpoch(Date date) {
        return date != null ? date.getTime() : null;
    }
}