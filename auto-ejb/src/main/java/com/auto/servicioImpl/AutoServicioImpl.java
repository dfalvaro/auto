/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auto.servicioImpl;

import com.auto.dao.IAutoDao;
import com.auto.modelo.Auto;
import com.auto.servicio.IAutoServicio;
import com.excepciones.registos.RegistroNoEliminado;
import com.excepciones.registos.RegistroNoGuardado;
import com.excepciones.registos.RegistroNoLocalizado;
import com.utilitarios.UtilService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.json.JSONObject;
import org.jsoup.Jsoup;

/**
 *
 * @author user
 */
@Stateless
public class AutoServicioImpl implements IAutoServicio {

    @EJB
    IAutoDao autoDao;

    @Override
    public Auto obtenerPorId(Long id) throws RegistroNoLocalizado {
        return autoDao.recuperar(id);
    }

    @Override
    public List<Auto> buscar(Auto auto) {
        return autoDao.buscar(auto);
    }

    @Override
    public void actualizar(Auto auto) throws RegistroNoGuardado {

        autoDao.actualizar(auto);
    }

    @Override
    public void eliminar(Auto auto) throws RegistroNoEliminado, RegistroNoLocalizado {

        Auto autoEliminar = autoDao.recuperar(auto.getId());
        autoDao.eliminar(autoEliminar);
    }

    @Override
    public void guardar(Auto auto) throws RegistroNoGuardado, RegistroNoLocalizado {
        if (auto.getId() == null) {
            String placa = "xxxx";
            JSONObject jsonObjectCreacion = obtenerJsonUrl("https://auto.jedai.workers.dev?placa=" + placa);
            if (jsonObjectCreacion == null) {
                throw new RegistroNoLocalizado("Registro no Guardado");
            }
            BigDecimal precioJson = jsonObjectCreacion.getBigDecimal("precio");
            auto.setPrecio(precioJson);
            autoDao.crear(auto);
        } else {
            autoDao.actualizar(auto);
        }
    }

    @Override
    public List<Auto> busquedaPorFiltros(Auto auto) {
        return autoDao.busquedaPorFiltros(auto);
    }

    @Override
    public List<Auto> busquedaPorFiltrosSW(Auto auto) {
        List<Auto> listaAutosEncontrados = buscar(new Auto());
        List<Auto> listaAutos = new ArrayList<>();
        for (Auto listaAuto : listaAutosEncontrados) {
            listaAuto.setFechaCompraAux(UtilService.nuevaFechaCompra(listaAuto.getFechaCompra()));
            if (UtilService.obtenerNombreDiaSemana(listaAuto.getFechaCompraAux()).equals(UtilService.obtenerNombreDiaSemana(auto.getFechaCompra()))
                    && auto.getFechaCompra().compareTo(listaAuto.getFechaCompra()) == 1
                    && auto.getFechaCompra().compareTo(listaAuto.getFechaManteniminetoLimite()) <= 0) {
                listaAutos.add(listaAuto);
            }
        }
        return listaAutos;
    }

    @Override
    public void guardarAuto(Auto auto) throws RegistroNoGuardado, RegistroNoLocalizado {

        auto.setFechaManteniminetoLimite(UtilService.obtenerFechaMantenimiento(auto.getFechaCompra()));
        guardar(auto);
    }

    public static JSONObject obtenerJsonUrl(String stringUrl) {
        try {
            String json = Jsoup.connect(stringUrl).ignoreContentType(true).execute().body();
            return new JSONObject(json);
        } catch (IOException ex) {
            return null;
        }

    }

}
