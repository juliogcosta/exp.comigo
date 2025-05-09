package br.com.comigo.atendimento.api.adapter.aggregate.event.dto;

import java.util.Date;

public record CouponDTO(
    Long id,
    String code,
    Integer discount,
    Date valid) {
}