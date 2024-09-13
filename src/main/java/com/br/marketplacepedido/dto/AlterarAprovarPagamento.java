package com.br.marketplacepedido.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AlterarAprovarPagamento(@NotNull(message = "O id não pode ser nulo.") UUID id) {
}
