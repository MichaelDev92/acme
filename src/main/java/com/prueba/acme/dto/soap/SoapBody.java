package com.prueba.acme.dto.soap;

import com.prueba.acme.dto.xml.EnvioPedidoAcmeResponse;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class SoapBody {

    @XmlElement(
            name = "EnvioPedidoAcmeResponse",
            namespace = "http://WSDLs/EnvioPedidos/EnvioPedidosAcme"
    )
    private EnvioPedidoAcmeResponse envioPedidoAcmeResponse;
}
