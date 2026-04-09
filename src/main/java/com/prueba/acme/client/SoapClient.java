package com.prueba.acme.client;

import org.springframework.stereotype.Component;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Component
public class SoapClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public String callSoapService(String xmlRequest) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        //Broken endpoint error 404, use this one when is it up
        //String endpoint = "https://run.mocky.io/v3/19217075-6d4e-4818-98bc-416d1feb7b84";

        String url = "http://localhost:8080/soap/pedido";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> request = new HttpEntity<>(xmlRequest, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        //Remove/Add comment to display xmlResponse Structure received from mock
        //System.out.println("response received from mock: " + response.getBody());

        return response.getBody();
    }
}
