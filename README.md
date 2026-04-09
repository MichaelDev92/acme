# API REST → SOAP (Transformación JSON ↔ XML)

## Descripción del ejercicio

Se desarrolló una API REST en Spring Boot que recibe una petición en formato JSON, la transforma a XML (formato SOAP), la envía a un servicio externo (mock simulado), y luego procesa la respuesta XML para devolverla nuevamente en formato JSON.

Inicialmente se intentó consumir un endpoint externo en Mocky, pero este retornaba **404**, por lo que se implementó un **mock local SOAP** que simula el comportamiento del servicio real, incluyendo un **delay artificial** para representar tiempos de respuesta reales.

---

## Flujo de la solución

1. Cliente envía petición REST (JSON)
2. Controller recibe la solicitud
3. Service procesa la lógica
4. Mapper convierte JSON → XML (estructura SOAP)
5. SoapClient envía la petición usando HTTP
6. Mock SOAP local recibe el XML
7. Mock responde con XML (simulando servicio real)
8. Mapper convierte XML → JSON
9. Controller devuelve respuesta al cliente

---

## Arquitectura del proyecto

El proyecto sigue una separación clara de responsabilidades:

* **Controller** → expone endpoints REST
* **Service** → contiene la lógica de negocio
* **SoapClient** → realiza la comunicación HTTP hacia el servicio SOAP
* **DTOs** → representan las estructuras de entrada y salida
* **Mappers** → transforman entre JSON y XML
* **Modelos XML** → clases anotadas para representar el SOAP

---

## Implementaciones para manejo de XMLs

Se implementaron prácticas con dependencias como `RestTemplate` para envío de solicitudes con XML, configurar headers  para tipo de contenido `application/xml`, `JAXB` para serializar objetos Java a XML y deserializar XML a Java y manejo de estructuras SOAP, un `CustomNamespacePrefixMapper` para controlar los prefijos de namespaces en el XML, transformaciones con `Mappers` para pasar de JSON a XML y viceversa, `SoapEnvelope` para estructura raíz de mensaje SOAP y `SoapBody` que expone información del negocio y son obligatorios en SOAP para manejar el estándar de los mensajes y permitir interoperabilidad.

---

## Mock SOAP local

Debido a que el endpoint externo fallaba (404), se implementó un mock local que:

* Expone un endpoint tipo SOAP
* Recibe XML
* Aplica un `delay` (simulación de latencia)
* Retorna un XML con respuesta controlada

### Ejemplo de respuesta XML:

```xml
<EnvioPedidoResponse>
    <Codigo>80375472</Codigo>
    <Mensaje>Entregado exitosamente al cliente</Mensaje>
</EnvioPedidoResponse>
```

---

## Ejemplo de request JSON

```json
{
  "enviarPedido": {
    "numPedido": "75630275",
    "cantidadPedido": "1",
    "codigoEAN": "00110000765191002104587",
    "nombreProducto": "Armario INVAL",
    "numDocumento": "1113987400",
    "direccion": "CR 72B 45 12 APT 301"
  }
}
```

---

## Dockerización

Se creó el respectivo Dockerfile para construir la imagen y se pueda ejecutar la misma en cualquier máquina con Docker.

## Comandos Docker a Ejecutar

Clonar proyecto y en la carpeta raíz del mismo ejecutar los siguientes comandos. 

### Crear la imagen

```bash
docker build -t acme-app .
```

### Ejecutar el contenedor

```bash
docker run --name acme-pedido-service -p 8080:8080 acme-app
```

---

## Pruebas

Probar el endpoint REST con:

* Postman
* Bruno


