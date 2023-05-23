package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class registroestacionamientoDao {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<registroestacionamiento> listar() {
        List<registroestacionamiento> datos = new ArrayList<>();
        String sql = "SELECT * FROM registro_de_estacionamiento";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registroestacionamiento registro = new registroestacionamiento(
                    rs.getLong("id_registro_estacionamiento"),
                    rs.getString("fecha_hora_entrada"),
                    rs.getString("fecha_hora_salida"),
                    rs.getDouble("cobro_total"),
                    rs.getLong("id_vehiculo"),
                    rs.getLong("id_espacio_estacionamiento"),
                    rs.getLong("id_pago")
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

   public int agregar(registroestacionamiento registro) {
    int r = 0;
    String sql = "INSERT INTO pago (id_pago, metodo_pago, ingresos_totales, fecha_hora_generacion, fecha_hora_pago, ganancias_totales, egresos_totales, monto_de_pago) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        ps.setLong(1, registro.getId_registro_estacionamiento());
        ps.setString(2, registro.getFecha_hora_entrada());
        ps.setString(3, registro.getFecha_hora_salida());
        ps.setDouble(4, registro.getCobro_total());
        ps.setLong(5, registro.getId_vehiculo());
        ps.setLong(6, registro.getId_espacio_estacionamiento());
        ps.setLong(7, registro.getId_pago());
        r = ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return r;
}


   public int actualizar(registroestacionamiento registro) {
    int r = 0;
    String SQL = "update registro_de_estacionamiento set fecha_hora_entrada=?, fecha_hora_salida=?, cobro_total=?, id_vehiculo=?, id_espacio_estacionamiento=?, id_pago=? where id_registro_estacionamiento=?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(SQL);
        ps.setString(1, registro.getFecha_hora_entrada());
        ps.setString(2, registro.getFecha_hora_salida());
        ps.setDouble(3, registro.getCobro_total());
        ps.setLong(4, registro.getId_vehiculo());
        ps.setLong(5, registro.getId_espacio_estacionamiento());
        ps.setLong(6, registro.getId_pago());
        ps.setLong(7, registro.getId_registro_estacionamiento());
        r = ps.executeUpdate();
        
    } catch (Exception e) {

        }
        return r;
}

    public void delete(long id_registro_estacionamiento) {
    String SQL = "DELETE FROM registro_de_estacionamiento WHERE id_registro_estacionamiento=?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(SQL);
        ps.setLong(1, id_registro_estacionamiento);
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
