/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.daoImpl;

import com.auto.dao.IAutoDao;
import com.auto.dao.IModeloDao;
import com.auto.modelo.Modelo;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class ModeloDaoImp extends GenericDaoImp<Modelo, Long>
        implements IModeloDao {

    public ModeloDaoImp() {
        super(Modelo.class);
    }

    @Override
    public List<Modelo> buscar(Modelo auto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from Modelo t where 1=1 ");
        if (auto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", auto.getId());
        }

        sql.append(" order by t.id asc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<Modelo> busquedaPorFiltros(Modelo auto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from Modelo t where 1=1");

        if (auto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", auto.getId());
        }

        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

}
