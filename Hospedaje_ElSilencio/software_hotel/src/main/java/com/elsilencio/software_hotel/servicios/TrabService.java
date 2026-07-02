package com.elsilencio.software_hotel.servicios;

import com.elsilencio.software_hotel.modelos.Trabajador;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class TrabService {
    ApiService api = new ApiService();

    // Autenticación de trabajador
    public boolean autenticarTrabajador(String login, String password) throws Exception {

        // 1. Crear el JSON con login y password
        Map<String, String> credenciales = new HashMap<>();
        credenciales.put("login", login);
        credenciales.put("password", password);

        String json = api.getObjectMapper().writeValueAsString(credenciales);

        System.out.println("Enviando JSON: " + json); // Depuración

        // 2. Crear petición POST con JSON en el cuerpo
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api.getBASE_URL() + "/auth/login"))
                .header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();

        // 3. Enviar petición
        HttpResponse<String> response = api.getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Código respuesta: " + response.statusCode());
        System.out.println("Respuesta body: " + response.body());

        // 4. Si el código es 200, el login fue exitoso
        return response.statusCode() == 200;
    }

    // CONFIGURAR COLUMNAS DE LA TABLA
    public static void configurarTablaTrabajadores(TableColumn<Trabajador, Integer> colId,
            TableColumn<Trabajador, String> colPersonal, TableColumn<Trabajador, BigDecimal> colSueldo,
            TableColumn<Trabajador, String> colUsuario, TableColumn<Trabajador, String> colEstado) {

        colId.setCellValueFactory(new PropertyValueFactory<>("idpersona"));

        colPersonal.setCellValueFactory(cellData -> {
            Trabajador t = cellData.getValue();
            String nombreCompleto = t.getNombre() + " " + t.getApaterno() + " " + t.getAmaterno();
            return new SimpleStringProperty(nombreCompleto);
        });

        colSueldo.setCellValueFactory(new PropertyValueFactory<>("sueldo"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("login"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
    }

    
}
