/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.excepciones.registos;

import javax.ejb.ApplicationException;

/**
 *
 * @author Ricardo
 */
@ApplicationException(rollback = true)
public class RegistroNoLocalizado extends Exception {

    /**
     * Creates a new instance of <code>RegistrosNoLocalizados</code> without
     * detail message.
     */
    public RegistroNoLocalizado() {
    }

    /**
     * Constructs an instance of <code>RegistrosNoLocalizados</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RegistroNoLocalizado(String msg) {
        super(msg);
    }
}
