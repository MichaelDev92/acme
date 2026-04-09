package com.prueba.acme.config;

import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;

public class CustomNamespacePrefixMapper extends org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper {

    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {

        if ("http://schemas.xmlsoap.org/soap/envelope/".equals(namespaceUri)) {
            return "soapenv";
        }

        if ("http://WSDLs/EnvioPedidos/EnvioPedidosAcme".equals(namespaceUri)) {
            return "env";
        }

        return suggestion;
    }
}
