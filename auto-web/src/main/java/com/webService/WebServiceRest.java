/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.webService;

import com.auto.modelo.Auto;
import com.auto.servicio.IAutoServicio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author User
 */
@Stateless
@Path("servicio")
public class WebServiceRest {

    @EJB
    IAutoServicio autoServicio;

    @GET
    @Path("auto")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces("application/json; charset=UTF-8")
    public List<Auto> obtenerAutos(@QueryParam("fechaCompra") String fechaCompra) {
        try {
            System.err.println("parametro:" + fechaCompra);
            List<Auto> listaAutos = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = dateFormat.parse(fechaCompra);

            if (fechaCompra != null) {
                listaAutos = autoServicio.busquedaPorFiltrosSW(new Auto(fecha));

            }
            return listaAutos;
        } catch (ParseException ex) {
            return new ArrayList<>();

        }
    }

}
