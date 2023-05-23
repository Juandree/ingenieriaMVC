/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EnumPago;

public class PagosDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Pagos> listar() {
        List<Pagos> datos = new ArrayList<>();
        String sql = "SELECT * FROM pago";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pagos registro = new Pagos(
                        rs.getInt("id_pago"),
                        EnumPago.valueOf(rs.getString("metodo_pago")),
                        rs.getDouble("ingresos_totales"),
                        rs.getTimestamp("fecha_hora_generacion").toLocalDateTime(),
                        rs.getTimestamp("fecha_hora_pago").toLocalDateTime(),
                        rs.getDouble("ganancias_totales"),
                        rs.getDouble("egresos_totales"),
                        rs.getDouble("monto_de_pago")
                );
                datos.add(registro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return datos;
    }

public int agregar(Pagos registro) {
    int r = 0;
    String sql = "INSERT INTO pago (id_pago, metodo_pago, ingresos_totales, fecha_hora_generacion, fecha_hora_pago, ganancias_totales, egresos_totales, monto_de_pago) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        con = conectar.getConnection(); // Obtener la conexión
        ps = con.prepareStatement(sql);
        ps.setInt(1, registro.getId_pago());
        ps.setString(2, registro.getMetodo_pago().name());
        ps.setDouble(3, registro.getIngresos_totales());
        ps.setTimestamp(4, Timestamp.valueOf(registro.getFecha_hora_generacion()));
        ps.setTimestamp(5, Timestamp.valueOf(registro.getFecha_hora_pago()));
        ps.setDouble(6, registro.getGanacias_totales());
        ps.setDouble(7, registro.getEgresos_totales());
        ps.setDouble(8, registro.getMonto_de_pago());

        r = ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(PagosDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return r;
}

   







    public int actualizar(Pagos registro) {
    int r = 0;
    String SQL = "UPDATE pago SET id_pago=?, metodo_pago=?, ingresos_totales=?, fecha_hora_generacion=?, fecha_hora_pago=?,"
                + "ganancias_totales=?, egresos_totales=?, monto_de_pago=? WHERE id_pago=?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(SQL);
        ps.setInt(1, registro.getId_pago());
        ps.setString(2, registro.getMetodo_pago().name());
        ps.setDouble(3, registro.getIngresos_totales());
        ps.setTimestamp(4, Timestamp.valueOf(registro.getFecha_hora_generacion()));
        ps.setTimestamp(5, Timestamp.valueOf(registro.getFecha_hora_pago()));
        ps.setDouble(6, registro.getGanacias_totales());
        ps.setDouble(7, registro.getEgresos_totales());
        ps.setDouble(8, registro.getMonto_de_pago());
        ps.setInt(9, registro.getId_pago()); // Agrega esta línea para establecer el parámetro faltante
        r = ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return r;
}

    public void delete(long id_pago) {
        String SQL = "DELETE FROM pago WHERE id_pago=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setLong(1, id_pago);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
