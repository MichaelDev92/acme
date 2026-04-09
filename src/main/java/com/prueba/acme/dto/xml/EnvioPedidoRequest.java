package com.prueba.acme.dto.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "EnvioPedidoRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvioPedidoRequest {
    @XmlElement(name = "pedido")
    private String pedido;

    @XmlElement(name = "Cantidad")
    private Integer cantidad;

    @XmlElement(name = "EAN")
    private String ean;

    @XmlElement(name = "producto")
    private String producto;

    @XmlElement(name = "Cedula")
    private Integer cedula;

    @XmlElement(name = "Direccion")
    private String direccion;
}
