package com.br.marketplacepedido.repository;

import com.br.marketplacepedido.dto.DadosDetalhadosPedidoDto;
import com.br.marketplacepedido.model.Pedido;
import com.br.marketplacepedido.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    @Modifying(clearAutomatically = true)
    @Query("update Pedido p set p.status = :status where p = :pedido")
    void atualizaStatus(Status status, Pedido pedido);

    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id")
    Pedido porIdComItens(Long id);

    List<DadosDetalhadosPedidoDto> buscarTodosDadosDetalhadosItemDoPedidoDto();
}
