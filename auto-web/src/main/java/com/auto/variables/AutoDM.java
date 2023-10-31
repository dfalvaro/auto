/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.variables;

import com.auto.modelo.Auto;
import com.auto.modelo.Modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author user
 */
@Named(value = "autoDM")
@ViewScoped
public class AutoDM implements Serializable {

    List<Auto> listaAutos = new ArrayList<>();
    Auto auto = new Auto();
    List<Modelo> listaModelos = new ArrayList<>();

    /**
     * Creates a new instance of autoAD
     */
    public AutoDM() {
    }

    public List<Auto> getListaAutos() {
        return listaAutos;
    }

    public void setListaAutos(List<Auto> listaAutos) {
        this.listaAutos = listaAutos;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public List<Modelo> getListaModelos() {
        return listaModelos;
    }

    public void setListaModelos(List<Modelo> listaModelos) {
        this.listaModelos = listaModelos;
    }
    
    

}
