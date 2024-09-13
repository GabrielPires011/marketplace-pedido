package com.br.marketplacepedido.model;

import com.br.marketplacepedido.dto.CriarPedidoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="pedido", fetch = FetchType.LAZY)
    private List<ItemDoPedido> itens = new ArrayList<>();

    public Pedido(CriarPedidoDto dto) {
        this.dataHora = LocalDateTime.now();
        this.status = Status.REALIZADO;
        this.itens = new ArrayList<>();
        dto.itens().forEach(item -> itens.add(new ItemDoPedido(item)));
    }

    public Pedido() {
    }

    public void atualizaStatus(Status status) {
        this.status = status;
    }

    public void pago() {
        this.status = Status.PAGO;
    }
}
