package com.prueba.acme.dto.json;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoRequestDto {
    private String numPedido;
    private Integer cantidadPedido;
    private String codigoEAN;
    private String nombreProducto;
    private Integer numDocumento;
    private String direccion;
}
