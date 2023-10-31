/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.servicio;

import com.auto.modelo.Modelo;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface IModeloServicio {

    public Modelo obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<Modelo> buscar(Modelo auto);

    public void actualizar(Modelo auto)
            throws RegistroNoGuardado;

    public void eliminar(Modelo auto)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(Modelo auto) throws RegistroNoGuardado;

    public List<Modelo> busquedaPorFiltros(Modelo auto);



}
