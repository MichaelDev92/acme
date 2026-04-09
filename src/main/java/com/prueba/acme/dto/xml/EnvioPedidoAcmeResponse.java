package com.prueba.acme.dto.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "EnvioPedidoAcmeResponse",
        namespace = "http://WSDLs/EnvioPedidos/EnvioPedidosAcme"
)
public class EnvioPedidoAcmeResponse {

    @XmlElement(name = "EnvioPedidoResponse")
    private EnvioPedidoResponse envioPedidoResponse;
}
