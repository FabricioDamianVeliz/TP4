/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Esteban
 */
public class MedioPago {
    private Integer idUsuario;
    private String nombreTitular;
    private String nroTarjeta;
    private String mesVenc; 
    private String anioVenc;
    private String codSeguridad;
    private Integer idMedioPago;

    public MedioPago() {
    }

    public MedioPago(Integer idUsuario, String nombreTitular, String nroTarjeta, String mesVenc, String anioVenc, String codSeguridad, Integer idMedioPago) {
        this.idUsuario = idUsuario;
        this.nombreTitular = nombreTitular;
        this.nroTarjeta = nroTarjeta;
        this.mesVenc = mesVenc;
        this.anioVenc = anioVenc;
        this.codSeguridad = codSeguridad;
        this.idMedioPago = idMedioPago;
    }

    public MedioPago(Integer idUsuario, String nombreTitular, String nroTarjeta, String mesVenc, String anioVenc, String codSeguridad) {
        this.idUsuario = idUsuario;
        this.nombreTitular = nombreTitular;
        this.nroTarjeta = nroTarjeta;
        this.mesVenc = mesVenc;
        this.anioVenc = anioVenc;
        this.codSeguridad = codSeguridad;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getMesVenc() {
        return mesVenc;
    }

    public void setMesVenc(String mesVenc) {
        this.mesVenc = mesVenc;
    }

    public String getAnioVenc() {
        return anioVenc;
    }

    public void setAnioVenc(String anioVenc) {
        this.anioVenc = anioVenc;
    }

    public String getCodSeguridad() {
        return codSeguridad;
    }

    public void setCodSeguridad(String codSeguridad) {
        this.codSeguridad = codSeguridad;
    }

    public Integer getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(Integer idMedioPago) {
        this.idMedioPago = idMedioPago;
    }
    
    

    

}