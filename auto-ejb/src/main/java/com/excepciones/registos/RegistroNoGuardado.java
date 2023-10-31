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
public class RegistroNoGuardado extends Exception {

    /**
     * Creates a new instance of <code>RegistrosNoGuardados</code> without
     * detail message.
     */
    public RegistroNoGuardado() {
    }

    /**
     * Constructs an instance of <code>RegistrosNoGuardados</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RegistroNoGuardado(String msg) {
        super(msg);
    }
}
