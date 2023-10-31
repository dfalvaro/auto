/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utilitarios;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author user
 */
public final class UtilService {

    public static String formatoFecha(Date fecha, String formato) {
        if (fecha == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        return dateFormat.format(fecha);
    }

    public static String obtenerAnio(final Date fechaIngreso) {

        if (null == fechaIngreso) {
            return "0000";
        } else {
            String formato = "yyyy";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return dateFormat.format(fechaIngreso);

        }

    }

    public static String obtenerDia(final Date fechaIngreso) {

        if (null == fechaIngreso) {
            return "00";
        } else {
            String formato = "dd";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return dateFormat.format(fechaIngreso);

        }

    }

    public static String obtenerMes(final Date fechaIngreso) {
        if (null == fechaIngreso) {
            return "00";
        } else {
            String formato = "MM";
            SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
            return dateFormat.format(fechaIngreso);
        }

    }

    public static String obtenerNombreDiaSemana(final Date fechaEnvio) {
        LocalDate fecha = fechaEnvio.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        return diaSemana.toString();
    }

    public static Date obtenerFechaMantenimiento(final Date fechaCompra) {
        LocalDate fecha = fechaCompra.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        int diasASumar = 60;
        LocalDate fechaAumentada = fecha.plusDays(diasASumar);
        return Date.from(fechaAumentada.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());

    }

    public static Date nuevaFechaCompra(final Date fechaCompra) {
        LocalDate fecha = fechaCompra.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        int diasASumar = 0;

        if (diaSemana.toString().equals("SATURDAY")) {
            diasASumar = 2;
        }

        if (diaSemana.toString().equals("SUNDAY")) {
            diasASumar = 1;
        }

        LocalDate fechaAumentada = fecha.plusDays(diasASumar);
        return Date.from(fechaAumentada.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());

    }

}
