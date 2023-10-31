/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "auto")
public class Auto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auto")
    private Long id;

    @Column(name = "placa")
    private String placa;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "anio")
    private String anio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "observacion")
    private String observacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_mantenimiento_limmite")
    private Date fechaManteniminetoLimite;

    @Transient
    private Date fechaCompraAux;

    public Auto() {
    }

    public Auto(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaCompraAux() {
        return fechaCompraAux;
    }

    public void setFechaCompraAux(Date fechaCompraAux) {
        this.fechaCompraAux = fechaCompraAux;
    }

    public Date getFechaManteniminetoLimite() {
        return fechaManteniminetoLimite;
    }

    public void setFechaManteniminetoLimite(Date fechaManteniminetoLimite) {
        this.fechaManteniminetoLimite = fechaManteniminetoLimite;
    }

    @Override
    public String toString() {
        return "Auto{" + "id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", anio=" + anio + ", fechaCompra=" + fechaCompra + ", precio=" + precio + ", observacion=" + observacion + '}';
    }

}
