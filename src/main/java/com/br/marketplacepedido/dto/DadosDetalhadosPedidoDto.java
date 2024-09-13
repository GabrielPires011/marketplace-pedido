package com.br.marketplacepedido.dto;

import com.br.marketplacepedido.model.Status;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record DadosDetalhadosPedidoDto(UUID id, LocalDateTime dataHora, Status status,
                                       List<DadosDetalhadosItemDoPedidoDto> itens) {
}
