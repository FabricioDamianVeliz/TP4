/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author cgallardo
 */
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String talle;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio.setScale(2, BigDecimal.ROUND_DOWN);
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public boolean equals(Object object)
    {
        boolean mismoProducto = false;

        if (object != null && object instanceof Producto)
        {
            mismoProducto = this.id == ((Producto) object).id;
        }

        return mismoProducto;
    }
}
