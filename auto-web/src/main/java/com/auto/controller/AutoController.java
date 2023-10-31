/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.controller;

import com.auto.modelo.Auto;
import com.auto.modelo.Modelo;
import com.auto.servicio.IAutoServicio;
import com.auto.servicio.IModeloServicio;
import com.auto.variables.AutoDM;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Named(value = "autoController")
@ViewScoped
public class AutoController extends BaseControlador implements Serializable {
    
    @Inject
    AutoDM autoDM;
    
    @EJB
    IAutoServicio autoServicio;
    @EJB
    IModeloServicio modeloServicio;
    
    public void inicio() {
        autoDM.setListaModelos(modeloServicio.buscar(new Modelo()));
        nuevo();
        buscarAuto();
    }
    
    public void nuevo() {
        autoDM.setAuto(new Auto());
        autoDM.getAuto().setPrecio(BigDecimal.ZERO);
        
    }
    
    public void buscarAuto() {
        autoDM.setListaAutos(autoServicio.buscar(new Auto()));
        
    }
    
    public void guardar() {
        try {
            autoServicio.guardarAuto(autoDM.getAuto());
            inicio();
            addInfoMessage("Registro Guardado Exitosamente");
            
        } catch (RegistroNoGuardado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.toString());
        }
    }
    
    public void editar(Auto auto) {
        
        try {
            autoDM.setAuto(autoServicio.obtenerPorId(auto.getId()));
            
        } catch (RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }
    
    public void eliminar(Auto auto) {
        
        try {
            autoServicio.eliminar(auto);
            buscarAuto();
            addInfoMessage("Registro eliminado");
            
        } catch (RegistroNoEliminado | RegistroNoLocalizado ex) {
            addErrorMessage(ex.getMessage());
        }
    }
    
    public AutoDM getAutoDM() {
        return autoDM;
    }
    
    public void setAutoDM(AutoDM autoDM) {
        this.autoDM = autoDM;
    }
    
}
