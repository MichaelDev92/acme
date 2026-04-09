package com.prueba.acme.mapper;


import com.prueba.acme.config.CustomNamespacePrefixMapper;
import com.prueba.acme.dto.json.PedidoRequestDto;
import com.prueba.acme.dto.json.PedidoResponseDto;
import com.prueba.acme.dto.soap.SoapBodyRequest;
import com.prueba.acme.dto.soap.SoapEnvelopeRequest;
import com.prueba.acme.dto.soap.SoapEnvelopeResponse;
import com.prueba.acme.dto.xml.EnvioPedidoAcmeRequest;
import com.prueba.acme.dto.xml.EnvioPedidoRequest;
import com.prueba.acme.dto.xml.EnvioPedidoResponse;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import jakarta.xml.bind.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class PedidoMapper {

    public static String toXml(PedidoRequestDto dto) {
        EnvioPedidoRequest request = new EnvioPedidoRequest();
        request.setPedido(dto.getNumPedido());
        request.setCantidad(dto.getCantidadPedido());
        request.setEan(dto.getCodigoEAN());
        request.setProducto(dto.getNombreProducto());
        request.setCedula(dto.getNumDocumento());
        request.setDireccion(dto.getDireccion());

        EnvioPedidoAcmeRequest acme = new EnvioPedidoAcmeRequest();
        acme.setEnvioPedidoRequest(List.of(request));

        SoapBodyRequest body = new SoapBodyRequest();
        body.setEnvioPedidoAcme(acme);

        SoapEnvelopeRequest envelope = new SoapEnvelopeRequest();
        envelope.setBody(body);

        return convertToXml(envelope);
    }

    public static String convertToXml(Object obj) {

        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.setProperty("org.glassfish.jaxb.namespacePrefixMapper",
                    new CustomNamespacePrefixMapper());

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);

            return writer.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PedidoResponseDto fromXml(String xml) {

        try {
            JAXBContext context = JAXBContext.newInstance(SoapEnvelopeResponse.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            SoapEnvelopeResponse envelope =
                    (SoapEnvelopeResponse) unmarshaller.unmarshal(new StringReader(xml));

            EnvioPedidoResponse response =
                    envelope.getBody()
                            .getEnvioPedidoAcmeResponse()
                            .getEnvioPedidoResponse();

            PedidoResponseDto dto = new PedidoResponseDto();
            dto.setCodigoEnvio(response.getCodigo());
            dto.setEstado(response.getMensaje());

            return dto;

        } catch (Exception e) {
            throw new RuntimeException("Error parsing XML", e);
        }
    }
}
