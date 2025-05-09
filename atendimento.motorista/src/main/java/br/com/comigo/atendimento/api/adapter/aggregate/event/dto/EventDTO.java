package br.com.comigo.atendimento.api.adapter.aggregate.event.dto;

import java.util.Date;
import java.util.List;

public record EventDTO(
    Long id,
    String title,
    String description,
    Long date,
    String city,
    String state,
    String eventUrl,
    List<CouponDTO> coupons) {

    public record CouponDTO(
        String code,
        Integer discount,
        Date valid) {
    }
}

