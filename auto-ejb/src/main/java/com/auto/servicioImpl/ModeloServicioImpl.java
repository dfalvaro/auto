/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.servicioImpl;

import com.auto.dao.IModeloDao;
import com.auto.modelo.Modelo;
import com.auto.servicio.IModeloServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless
public class ModeloServicioImpl implements IModeloServicio {

    @EJB
    IModeloDao modeloDao;

    @Override
    public Modelo obtenerPorId(Long id) throws RegistroNoLocalizado {
        return modeloDao.recuperar(id);
    }

    @Override
    public List<Modelo> buscar(Modelo auto) {
        return modeloDao.buscar(auto);
    }

    @Override
    public void actualizar(Modelo auto) throws RegistroNoGuardado {

        modeloDao.actualizar(auto);
    }

    @Override
    public void eliminar(Modelo auto) throws RegistroNoEliminado, RegistroNoLocalizado {

        Modelo autoEliminar = modeloDao.recuperar(auto.getId());
        modeloDao.eliminar(autoEliminar);
    }

    @Override
    public void guardar(Modelo auto) throws RegistroNoGuardado {
        if (auto.getId() == null) {
            modeloDao.crear(auto);
        } else {
            modeloDao.actualizar(auto);
        }
    }

    @Override
    public List<Modelo> busquedaPorFiltros(Modelo auto) {
        return modeloDao.busquedaPorFiltros(auto);
    }

   

}
