/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Esteban
 */
public class Venta {
    private List<Producto> productos;
    private BigDecimal montoTotal;
    private java.sql.Date fecha;
    private java.sql.Time  hora;
    private Integer idUsuario;
    private MedioPago m;
    private Integer idVenta;

    public Venta() {
    }

    public Venta(List<Producto> productos, BigDecimal montoTotal, Date fecha, Time hora, Integer idUsuario, MedioPago m) {
        this.productos = productos;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.m = m;
    }

    public Venta(List<Producto> productos, BigDecimal montoTotal, Date fecha, Time hora, Integer idUsuario) {
        this.productos = productos;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
    }

    public Venta(List<Producto> productos, BigDecimal montoTotal, Date fecha, Time hora, Integer idUsuario, MedioPago m, Integer idVenta) {
        this.productos = productos;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.m = m;
        this.idVenta = idVenta;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MedioPago getM() {
        return m;
    }

    public void setM(MedioPago m) {
        this.m = m;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    
}
