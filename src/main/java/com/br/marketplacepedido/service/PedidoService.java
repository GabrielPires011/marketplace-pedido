package com.br.marketplacepedido.service;

import com.br.marketplacepedido.dto.*;
import com.br.marketplacepedido.exception.ValidacaoException;
import com.br.marketplacepedido.model.Pedido;
import com.br.marketplacepedido.repository.PedidoRepository;
import com.br.marketplacepedido.util.TransformatorUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;
    @Autowired
    private TransformatorUtil transformatorUtil;

    public List<DadosDetalhadosPedidoDto> obterTodos() {
        var pedidos  =  repository.findAll();
        return transformatorUtil.transformarModelEmRecordDto(pedidos, "DadosDetalhados");
    }

    public DadosDetalhadosPedidoDto buscarPorId(UUID id) {
        var pedido  =  repository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Pedido não encontrado."));

        return transformatorUtil.transformarModelEmRecordDto(pedido, "DadosDetalhados");
    }

    @Transactional
    public void criarPedido(CriarPedidoDto dto) {
        var pedido = new Pedido(dto);
        repository.save(pedido);
    }

    @Transactional
    public void atualizaStatus(AlterarStatusPedido dto) {
        var pedido = repository.findById(dto.id())
                .orElseThrow(() -> new ValidacaoException("Pedido não encontrado."));

        pedido.atualizaStatus(dto.status());

        repository.save(pedido);
    }

    public void aprovaPagamentoPedido(AlterarAprovarPagamento dto) {
        var pedido = repository.findById(dto.id())
                .orElseThrow(() -> new ValidacaoException("Pedido não encontrado."));

        pedido.pago();

        repository.save(pedido);
    }
}
