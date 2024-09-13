package com.br.marketplacepedido.dto;

import com.br.marketplacepedido.model.Status;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record AlterarStatusPedido(@NotNull(message = "O id não pode ser nulo.") UUID id,
                                  @NotNull(message = "O status não pode ser nulo.") Status status) {
}
