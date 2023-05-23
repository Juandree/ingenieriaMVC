
package modelo;

public class registroestacionamiento {
     Long id_registro_estacionamiento;
     String fecha_hora_entrada;
     String fecha_hora_salida;
     double cobro_total;
     Long id_vehiculo;
     Long id_espacio_estacionamiento;
     Long id_pago;

    public registroestacionamiento(Long id_registro_estacionamiento, String fecha_hora_entrada, String fecha_hora_salida, double cobro_total, Long id_vehiculo, Long id_espacio_estacionamiento, Long id_pago) {
        this.id_registro_estacionamiento = id_registro_estacionamiento;
        this.fecha_hora_entrada = fecha_hora_entrada;
        this.fecha_hora_salida = fecha_hora_salida;
        this.cobro_total = cobro_total;
        this.id_vehiculo = id_vehiculo;
        this.id_espacio_estacionamiento = id_espacio_estacionamiento;
        this.id_pago = id_pago;
    }

    public Long getId_registro_estacionamiento() {
        return id_registro_estacionamiento;
    }

    public void setId_registro_estacionamiento(Long id_registro_estacionamiento) {
        this.id_registro_estacionamiento = id_registro_estacionamiento;
    }

    public String getFecha_hora_entrada() {
        return fecha_hora_entrada;
    }

    public void setFecha_hora_entrada(String fecha_hora_entrada) {
        this.fecha_hora_entrada = fecha_hora_entrada;
    }

    public String getFecha_hora_salida() {
        return fecha_hora_salida;
    }

    public void setFecha_hora_salida(String fecha_hora_salida) {
        this.fecha_hora_salida = fecha_hora_salida;
    }

    public double getCobro_total() {
        return cobro_total;
    }

    public void setCobro_total(double cobro_total) {
        this.cobro_total = cobro_total;
    }

    public Long getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public Long getId_espacio_estacionamiento() {
        return id_espacio_estacionamiento;
    }

    public void setId_espacio_estacionamiento(Long id_espacio_estacionamiento) {
        this.id_espacio_estacionamiento = id_espacio_estacionamiento;
    }

    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    
    
    
}
