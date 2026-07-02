package com.elsilencio.software_hotel.modelos;

import java.math.BigDecimal;

public class Consumo {
    private Integer idconsumo;
    private Integer idreserva;
    private Integer idproducto;
    private BigDecimal cantidad;
    private BigDecimal precioVenta;
    private String estado;

    public Consumo() {
    }

    public Consumo(Integer idconsumo, Integer idreserva, Integer idproducto, BigDecimal cantidad, BigDecimal precioVenta, String estado) {
        this.idconsumo = idconsumo;
        this.idreserva = idreserva;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.estado = estado;
    }

    public Integer getIdconsumo() {
        return idconsumo;
    }

    public void setIdconsumo(Integer idconsumo) {
        this.idconsumo = idconsumo;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
