/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.controller;

import com.auto.servicio.IAutoServicio;
import com.auto.variables.AutoDM;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public abstract class BaseControlador implements Serializable {

    @EJB
    IAutoServicio autoServicio;

    protected HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

    /**
     * @param parameterName
     * @return
     */
    protected Object getRequestParameter(final String parameterName) {
        return getFacesContext().getExternalContext().getRequestParameterMap().get(parameterName);
    }

    protected HttpServletResponse getServletResponse() {
        return (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
    }

    protected HttpServletRequest getServletRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }

    /**
     * @return
     */
    protected static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * @param resumen
     */
    protected void addErrorMessage(final String resumen) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Advertencia", resumen);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addErrorMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     */
    protected void addInfoMessage(final String resumen) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", resumen);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addInfoMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     */
    protected void addWarnMessage(final String resumen) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", resumen);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @param resumen
     * @param detalle
     */
    protected void addWarnMessage(final String resumen, final String detalle) {
        FacesMessage message = new FacesMessage(resumen, detalle);
        message.setSeverity(FacesMessage.SEVERITY_WARN);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
