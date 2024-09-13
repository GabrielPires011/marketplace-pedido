package com.br.marketplacepedido.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AlterarAprovarPagamentoDto(@NotNull(message = "O id não pode ser nulo.") UUID id) {
}
