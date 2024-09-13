package com.br.marketplacepedido.dto;

import com.br.marketplacepedido.model.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record CriarPedidoDto(@Valid List<CriarItemDoPedidoDto> itens,
                             @NotNull(message = "A data e hora não pode ser nulo.") LocalDateTime dataHora) {
}
