
package modelo;

import java.time.LocalDateTime;
import java.util.Date;
public class Pagos {
     int id_pago;
     EnumPago metodo_pago;
     double ingresos_totales;
     LocalDateTime fecha_hora_generacion;
     LocalDateTime fecha_hora_pago;
     double ganacias_totales;
     double egresos_totales;
     double monto_de_pago;

     public Pagos(int id_pago, EnumPago enumpago, int ingresos_totales, int ganacias_totales, int egresos_totales, int monto_de_pago, int par5, int par6) {

        this.id_pago = id_pago;
        this.metodo_pago = enumpago;
        this.ingresos_totales = ingresos_totales;
        this.ganacias_totales = ganacias_totales;
        this.egresos_totales = egresos_totales;
        this.monto_de_pago = monto_de_pago;
    }

    public Pagos(int id_pago, EnumPago enumpago, double ingresos_totales, LocalDateTime toLocalDateTime, LocalDateTime toLocalDateTime0, double ganacias_totales, double egresos_totales, double monto_de_pago) {

        this.id_pago = id_pago;
        this.metodo_pago = enumpago;
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

    public EnumPago getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(EnumPago metodo_pago) {
        this.metodo_pago = metodo_pago;
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


    

}
