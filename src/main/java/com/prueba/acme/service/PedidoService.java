package com.prueba.acme.service;

import com.prueba.acme.client.SoapClient;
import com.prueba.acme.dto.json.PedidoRequestDto;
import com.prueba.acme.dto.json.PedidoResponseDto;
import com.prueba.acme.mapper.PedidoMapper;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final SoapClient soapClient;

    public PedidoService(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    public PedidoResponseDto procesarPedido(PedidoRequestDto requestDto) {

        String xmlRequest = PedidoMapper.toXml(requestDto);

        String xmlResponse = soapClient.callSoapService(xmlRequest);

        return PedidoMapper.fromXml(xmlResponse);
    }
}
