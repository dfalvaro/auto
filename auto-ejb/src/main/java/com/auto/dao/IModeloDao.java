/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.dao;

import com.auto.modelo.Modelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface IModeloDao extends IGenericoDao<Modelo, Long> {

    public List<Modelo> buscar(Modelo auto);

    public List<Modelo> busquedaPorFiltros(Modelo auto);

}
