package com.elsilencio.software_hotel.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pago {
    private Integer idpago;
    private Integer idreserva; // Referencia simple
    private String tipoComprobante;
    private String numComprobante;
    private BigDecimal igv;
    private BigDecimal totalPago;
    private LocalDate fechaEmision;
    private LocalDate fechaPago;

    public Pago() {
    }

    public Pago(Integer idpago, Integer idreserva, String tipoComprobante, String numComprobante, BigDecimal igv, BigDecimal totalPago, LocalDate fechaEmision, LocalDate fechaPago) {
        this.idpago = idpago;
        this.idreserva = idreserva;
        this.tipoComprobante = tipoComprobante;
        this.numComprobante = numComprobante;
        this.igv = igv;
        this.totalPago = totalPago;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
    }

    public Integer getIdpago() {
        return idpago;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }
}
