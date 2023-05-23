/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 *
 * @author 57318
 */
public class Pago {

     int id_pago;
     EnumPago enumpago;
     double ingresos_totales;
     LocalDateTime fecha_hora_generacion = LocalDateTime.now();
     LocalDateTime fecha_hora_pago = LocalDateTime.now();
     double ganacias_totales;
     double egresos_totales;
     double monto_de_pago;

    public Pago(int id_pago, EnumPago enumpago, double ingresos_totales, double ganacias_totales, double egresos_totales, double monto_de_pago) {

        this.id_pago = id_pago;
        this.enumpago = enumpago;
        this.ingresos_totales = ingresos_totales;
        this.ganacias_totales = ganacias_totales;
        this.egresos_totales = egresos_totales;
        this.monto_de_pago = monto_de_pago;
    }

    public Pago(int id_pago, EnumPago enumpago, double ingresos_totales, LocalDateTime toLocalDateTime, LocalDateTime toLocalDateTime0, double ganacias_totales, double egresos_totales, double monto_de_pago) {

        this.id_pago = id_pago;
        this.enumpago = enumpago;
        this.ingresos_totales = ingresos_totales;
        this.fecha_hora_generacion = toLocalDateTime;
        this.fecha_hora_pago = toLocalDateTime0;
        this.ganacias_totales = ganacias_totales;
        this.egresos_totales = egresos_totales;
        this.monto_de_pago = monto_de_pago;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public EnumPago getEnumpago() {
        return enumpago;
    }

    public void setEnumpago(EnumPago enumpago) {
        this.enumpago = enumpago;
    }

    public double getIngresos_totales() {
        return ingresos_totales;
    }

    public void setIngresos_totales(double ingresos_totales) {
        this.ingresos_totales = ingresos_totales;
    }

    public LocalDateTime getFecha_hora_generacion() {
        return fecha_hora_generacion;
    }

    public void setFecha_hora_generacion(LocalDateTime fecha_hora_generacion) {
        this.fecha_hora_generacion = fecha_hora_generacion;
    }

    public LocalDateTime getFecha_hora_pago() {
        return fecha_hora_pago;
    }

    public void setFecha_hora_pago(LocalDateTime fecha_hora_pago) {
        this.fecha_hora_pago = fecha_hora_pago;
    }

    public double getGanacias_totales() {
        return ganacias_totales;
    }

    public void setGanacias_totales(double ganacias_totales) {
        this.ganacias_totales = ganacias_totales;
    }

    public double getEgresos_totales() {
        return egresos_totales;
    }

    public void setEgresos_totales(double egresos_totales) {
        this.egresos_totales = egresos_totales;
    }

    public double getMonto_de_pago() {
        return monto_de_pago;
    }

    public void setMonto_de_pago(double monto_de_pago) {
        this.monto_de_pago = monto_de_pago;
    }
    public enum EnumPago {

    tarjeta_de_credito, transferencia_bancaria, nequi, efectivo;

}

}
