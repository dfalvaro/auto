/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.dao;

import com.auto.modelo.Auto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface IAutoDao extends IGenericoDao<Auto, Long> {

    public List<Auto> buscar(Auto auto);

    public List<Auto> busquedaPorFiltros(Auto auto);

}
