package com.prueba.acme.controller;

import com.prueba.acme.dto.soap.SoapBody;
import com.prueba.acme.dto.soap.SoapEnvelopeResponse;
import com.prueba.acme.dto.xml.EnvioPedidoAcmeResponse;
import com.prueba.acme.dto.xml.EnvioPedidoResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.StringWriter;

@RestController
@RequestMapping("/soap")
public class SoapMockController {

    @PostMapping(value = "/pedido", produces = MediaType.TEXT_XML_VALUE)
    public String mockSoap(@RequestBody String requestXml) {

        //Remove/Add comment to display xmlRequest Structure received from service transformed by mapper
        //System.out.println("📥 XML recibido: \n" + requestXml);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        try {
            EnvioPedidoResponse envio = new EnvioPedidoResponse();
            envio.setCodigo("80375472");
            envio.setMensaje("Entregado exitosamente al cliente");

            EnvioPedidoAcmeResponse acmeResponse = new EnvioPedidoAcmeResponse();
            acmeResponse.setEnvioPedidoResponse(envio);

            SoapBody body = new SoapBody();
            body.setEnvioPedidoAcmeResponse(acmeResponse);

            SoapEnvelopeResponse envelope = new SoapEnvelopeResponse();
            envelope.setBody(body);

            JAXBContext context = JAXBContext.newInstance(SoapEnvelopeResponse.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(envelope, writer);

            return writer.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
