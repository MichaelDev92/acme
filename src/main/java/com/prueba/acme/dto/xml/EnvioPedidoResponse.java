package com.prueba.acme.dto.xml;


import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "EnvioPedidoRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvioPedidoResponse {

    @XmlElement(name = "Codigo")
    private String codigo;

    @XmlElement(name = "Mensaje")
    private String mensaje;
}
