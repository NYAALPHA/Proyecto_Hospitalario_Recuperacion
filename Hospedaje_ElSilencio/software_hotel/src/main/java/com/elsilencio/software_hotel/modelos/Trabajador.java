package com.elsilencio.software_hotel.modelos;

import java.math.BigDecimal;

public class Trabajador extends Persona {
    private BigDecimal sueldo;
    private String acceso;
    private String login;
    private String password;
    private String estado;

    public Trabajador() {
        super();
    }

    public Trabajador(String nombre, String apaterno, String amaterno, String tipoDocumento,
            String numDocumento, String genero, String direccion, String telefono, String email, BigDecimal sueldo,
            String acceso, String login, String password, String estado) {
        super(nombre, apaterno, amaterno, tipoDocumento, numDocumento, genero, direccion, telefono, email);
        this.sueldo = sueldo;
        this.acceso = acceso;
        this.login = login;
        this.password = password;
        this.estado = estado;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
