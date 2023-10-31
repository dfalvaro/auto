/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilitarios;

import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import java.sql.Types;
import org.hibernate.dialect.PostgreSQL95Dialect;

/**
 *
 * @author user
 */
public class PostgreSQL95JsonDialect extends PostgreSQL95Dialect {

    public PostgreSQL95JsonDialect() {
        super();
        this.registerHibernateType(Types.OTHER, JsonNodeBinaryType.class.getName());
    }
}
