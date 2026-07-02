package com.elsilencio.software_hotel.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente extends Persona {
    private String codigoCliente;

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String apaterno, String amaterno, String tipoDocumento,
            String numDocumento, String genero, String direccion, String telefono, String email, String codigoCliente) {
        super(nombre, apaterno, amaterno, tipoDocumento, numDocumento, genero, direccion, telefono, email);
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}
