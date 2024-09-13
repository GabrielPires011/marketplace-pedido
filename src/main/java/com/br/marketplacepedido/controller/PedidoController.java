package com.br.marketplacepedido.controller;

import com.br.marketplacepedido.dto.*;
import com.br.marketplacepedido.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

        @Autowired
        private PedidoService service;

        @GetMapping()
        public ResponseEntity<List<DadosDetalhadosPedidoDto>> listarTodos() {
            return ResponseEntity.ok(service.obterTodos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<DadosDetalhadosPedidoDto> buscarPorId(@PathVariable @NotNull UUID id) {
            return ResponseEntity.ok(service.buscarPorId(id));
        }

        @PostMapping()
        public ResponseEntity<Void> realizaPedido(@RequestBody @Valid CriarPedidoDto dto) {
            service.criarPedido(dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }

        @PutMapping()
        public ResponseEntity<Void> atualizaStatus(@RequestBody @Valid AlterarStatusPedido dto){
            service.atualizaStatus(dto);
            return ResponseEntity.ok().build();
        }


        @PutMapping("/pago")
        public ResponseEntity<Void> aprovaPagamento(@RequestBody @Valid AlterarAprovarPagamento dto) {
            service.aprovaPagamentoPedido(dto);
            return ResponseEntity.ok().build();
        }
}
