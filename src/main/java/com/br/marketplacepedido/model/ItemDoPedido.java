package com.br.marketplacepedido.model;

import com.br.marketplacepedido.dto.CriarItemDoPedidoDto;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ItemDoPedido {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private Integer quantidade;
    private String descricao;
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido pedido;

    public ItemDoPedido(CriarItemDoPedidoDto item) {
        this.descricao = item.descricao();
        this.quantidade = item.quantidade();
    }

    public ItemDoPedido() {
    }
}
