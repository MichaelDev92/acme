package com.prueba.acme.controller;

import com.prueba.acme.dto.json.EnviarPedidoRequestWrapperDto;
import com.prueba.acme.dto.json.PedidoRequestDto;
import com.prueba.acme.dto.json.PedidoResponseDto;
import com.prueba.acme.mapper.PedidoMapper;
import com.prueba.acme.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public PedidoResponseDto crearPedido(@RequestBody EnviarPedidoRequestWrapperDto wrapper) {
        return pedidoService.procesarPedido(wrapper.getEnviarPedido());
    }
}