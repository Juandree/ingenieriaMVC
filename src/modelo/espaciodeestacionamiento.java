/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 57318
 */
public class espaciodeestacionamiento {

     int id_espacio_estacionamiento;
     String disponibilidad;
     int numero_espacio;

    public espaciodeestacionamiento(int id_espacio_estacionamiento, String disponibilidad, int numero_espacio) {
        this.id_espacio_estacionamiento = id_espacio_estacionamiento;
        this.disponibilidad = disponibilidad;
        this.numero_espacio = numero_espacio;
    }

    public int getId_espacio_estacionamiento() {
        return id_espacio_estacionamiento;
    }

    public void setId_espacio_estacionamiento(int id_espacio_estacionamiento) {
        this.id_espacio_estacionamiento = id_espacio_estacionamiento;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getNumero_espacio() {
        return numero_espacio;
    }

    public void setNumero_espacio(int numero_espacio) {
        this.numero_espacio = numero_espacio;
    }

   
}
