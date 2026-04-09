package com.prueba.acme.dto.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "EnvioPedidoAcme", namespace = "http://WSDLs/EnvioPedidos/EnvioPedidosAcme")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class EnvioPedidoAcmeRequest {

    @XmlElement(name = "EnvioPedidoRequest")
    private List<EnvioPedidoRequest> envioPedidoRequest;
}
