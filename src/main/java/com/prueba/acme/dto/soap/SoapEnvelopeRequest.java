package com.prueba.acme.dto.soap;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(
        name = "Envelope",
        namespace = "http://schemas.xmlsoap.org/soap/envelope/"
)
public class SoapEnvelopeRequest {

    @XmlElement(
            name = "Header",
            namespace = "http://schemas.xmlsoap.org/soap/envelope/"
    )
    private String header = "";

    @XmlElement(
            name = "Body",
            namespace = "http://schemas.xmlsoap.org/soap/envelope/"
    )
    private SoapBodyRequest body;
}
