/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.servicio;

import com.auto.modelo.Auto;
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
public interface IAutoServicio {

    public Auto obtenerPorId(Long id)
            throws RegistroNoLocalizado;

    public List<Auto> buscar(Auto auto);

    public void actualizar(Auto auto)
            throws RegistroNoGuardado;

    public void eliminar(Auto auto)
            throws RegistroNoEliminado, RegistroNoLocalizado;

    public void guardar(Auto auto) throws RegistroNoGuardado, RegistroNoLocalizado;

    public List<Auto> busquedaPorFiltros(Auto auto);

    public List<Auto> busquedaPorFiltrosSW(Auto auto);

    public void guardarAuto(Auto auto) throws RegistroNoGuardado, RegistroNoLocalizado;

}
