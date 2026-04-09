package com.prueba.acme.dto.soap;

import com.prueba.acme.dto.xml.EnvioPedidoAcmeRequest;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class SoapBodyRequest {

    @XmlElement(
            name = "EnvioPedidoAcme",
            namespace = "http://WSDLs/EnvioPedidos/EnvioPedidosAcme"
    )
    private EnvioPedidoAcmeRequest envioPedidoAcme;
}
