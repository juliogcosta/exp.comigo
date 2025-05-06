package br.com.comigo.atendimento.api.adapter.inbound.dto;

import java.util.Date;

public record CouponDTO(
    Long id,
    String code,
    Integer discount,
    Date valid) {
}