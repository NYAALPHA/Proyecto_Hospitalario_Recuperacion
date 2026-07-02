package com.elsilencio.software_hotel.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reserva {
    private Integer idreserva;
    private Integer idhabitacion;
    private Integer idcliente;
    private Integer idtrabajador;
    private String tipoReserva;
    private LocalDate fechaReserva;
    private LocalDate fechaIngresa;
    private LocalDate fechaSalida;
    private BigDecimal costoAlojamiento;
    private String estado;

    public Reserva() {
    }

    public Reserva(Integer idreserva, Integer idhabitacion, Integer idcliente, Integer idtrabajador, String tipoReserva, LocalDate fechaReserva, LocalDate fechaIngresa, LocalDate fechaSalida, BigDecimal costoAlojamiento, String estado) {
        this.idreserva = idreserva;
        this.idhabitacion = idhabitacion;
        this.idcliente = idcliente;
        this.idtrabajador = idtrabajador;
        this.tipoReserva = tipoReserva;
        this.fechaReserva = fechaReserva;
        this.fechaIngresa = fechaIngresa;
        this.fechaSalida = fechaSalida;
        this.costoAlojamiento = costoAlojamiento;
        this.estado = estado;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Integer getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(Integer idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(Integer idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalDate getFechaIngresa() {
        return fechaIngresa;
    }

    public void setFechaIngresa(LocalDate fechaIngresa) {
        this.fechaIngresa = fechaIngresa;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public BigDecimal getCostoAlojamiento() {
        return costoAlojamiento;
    }

    public void setCostoAlojamiento(BigDecimal costoAlojamiento) {
        this.costoAlojamiento = costoAlojamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
