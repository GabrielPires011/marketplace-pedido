package com.br.marketplacepedido.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CriarItemDoPedidoDto(@NotNull(message = "A quantidade não pode ser nulo.") @Positive(message = "A quantidade deve ser um número positivo.") Integer quantidade,
                                   String descricao) {
}
