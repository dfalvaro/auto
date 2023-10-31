/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.daoImpl;

import com.auto.dao.IAutoDao;
import com.auto.modelo.Auto;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author user
 */
@Stateless
public class AutoDaoImp extends GenericDaoImp<Auto, Long>
        implements IAutoDao {

    public AutoDaoImp() {
        super(Auto.class);
    }

    @Override
    public List<Auto> buscar(Auto auto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from Auto t where 1=1 ");
        if (auto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", auto.getId());
        }

        sql.append(" order by t.fechaCompra asc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

    @Override
    public List<Auto> busquedaPorFiltros(Auto auto) {
        StringBuilder sql = new StringBuilder();
        HashMap<Object, Object> parametros = new HashMap();
        sql.append("Select t from Auto t where 1=1");

        if (auto.getId() != null) {
            sql.append(" and t.id=:id");
            parametros.put("id", auto.getId());
        }

        if (auto.getFechaCompra() != null) {
            sql.append(" and CAST(t.fechaCompra as date) BETWEEN :fechaCompra and :fechaCompra");
            parametros.put("fechaCompra", auto.getFechaCompra());
        }

        sql.append(" order by t.id  desc ");
        Query q = this.em.createQuery(sql.toString());
        parametros.keySet().forEach((key) -> {
            q.setParameter((String) key, parametros.get(key));
        });
        return q.getResultList();
    }

}
