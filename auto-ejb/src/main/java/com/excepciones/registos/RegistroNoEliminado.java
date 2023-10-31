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
public class RegistroNoEliminado extends Exception {

    /**
     * Creates a new instance of <code>RegistrosNoEliminados</code> without
     * detail message.
     */
    public RegistroNoEliminado() {
    }

    /**
     * Constructs an instance of <code>RegistrosNoEliminados</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RegistroNoEliminado(String msg) {
        super(msg);
    }
}
