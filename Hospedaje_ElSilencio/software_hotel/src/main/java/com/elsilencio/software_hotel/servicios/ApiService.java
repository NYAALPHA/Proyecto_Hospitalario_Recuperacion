package com.elsilencio.software_hotel.servicios;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiService {

    // URL de tu API Spring Boot (puerto 9090)
    private final String BASE_URL;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    private static final Set<String> endpoints = Set.of("cliente", "habitacion", "reserva", "pago", "producto",
            "trabajador", "consumo", "persona");

    // Constructor
    public ApiService() {
        this.BASE_URL = "http://localhost:9090/api";
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public String getBASE_URL() {
        return BASE_URL;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    // ========== MÉTODO GENÉRICO PARA PETICIONES PERSONALIZADAS ==========

    // DELETE - Eliminar por ID
    public boolean eliminar(String endpoint, int id) throws Exception {
        if (!endpoints.contains(endpoint)) {
            throw new IllegalArgumentException("Endpoint no válido: " + endpoint);
        }
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/" + endpoint + "/" + id)).DELETE()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode() == 200 || response.statusCode() == 204;
    }

    // POST - Crear un objeto
    public <T> T crear(String endpoint, T objeto, Class<T> clase) throws Exception {
        if (!endpoints.contains(endpoint)) {
            throw new IllegalArgumentException("Endpoint no válido: " + endpoint);
        }
        String json = objectMapper.writeValueAsString(objeto);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/" + endpoint))
                .header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), clase);
    }

    // PUT - Actualizar un objeto
    public <T> T actualizar(String endpoint, int id, T objeto, Class<T> clase) throws Exception {
        if (!endpoints.contains(endpoint)) {
            throw new IllegalArgumentException("Endpoint no válido: " + endpoint);
        }
        String json = objectMapper.writeValueAsString(objeto);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/" + endpoint + "/" + id))
                .header("Content-Type", "application/json").PUT(HttpRequest.BodyPublishers.ofString(json)).build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), clase);
    }

    // GET - Listar todos los objetos de un endpoint
    public <T> List<T> listar(String endpoint, Class<T[]> claseArray) throws Exception {
        if (!endpoints.contains(endpoint)) {
            throw new IllegalArgumentException("Endpoint no válido: " + endpoint);
        }
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/" + endpoint)).GET().build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Convertir el JSON en un array de objetos
        T[] array = objectMapper.readValue(response.body(), claseArray);

        // Convertir el array en una lista
        return Arrays.asList(array);
    }
}