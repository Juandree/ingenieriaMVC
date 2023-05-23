package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class espaciodeestacionamientoDAO {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<espaciodeestacionamiento> listar() {
        List<espaciodeestacionamiento> datos = new ArrayList<>();
        String sql = "SELECT * FROM espacio_de_estacionamiento";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                espaciodeestacionamiento u = new espaciodeestacionamiento(rs.getInt("id_espacio_estacionamiento"), rs.getString("disponibilidad"), rs.getInt("numero_espacio"));
                u.setId_espacio_estacionamiento(rs.getInt("id_espacio_estacionamiento"));
                u.setDisponibilidad(rs.getString("disponibilidad"));
                u.setNumero_espacio(rs.getInt("numero_espacio"));
                
                datos.add(u);
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

   

    public int actualizar(espaciodeestacionamiento h) {
        int r=0;
        String SQL = "update espacio_de_estacionamiento set disponibilidad=?, numero_espacio=? where id_espacio_estacionamiento=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setString(1, h.getDisponibilidad());
            ps.setInt(2, h.getNumero_espacio());
            ps.setInt(3, h.getId_espacio_estacionamiento());
            
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {

        }
        return r;
    }
    
    
   // public void delete(int id_usuario) {
    //try {
        // Eliminar los registros relacionados en la tabla vehiculo_de_usuario
     //   String sqlDeleteVehiculoDeUsuario = "DELETE FROM vehiculo_de_usuario WHERE id_usuario=?";
       // con = conectar.getConnection();
        //ps = con.prepareStatement(sqlDeleteVehiculoDeUsuario);
        //ps.setInt(1, id_usuario);
        //ps.executeUpdate();

        // Eliminar el registro en la tabla usuarios
        //String sqlDeleteUsuario = "DELETE FROM usuarios WHERE id_usuario=?";
        //ps = con.prepareStatement(sqlDeleteUsuario);
        //ps.setInt(1, id_usuario);
        //ps.executeUpdate();
    //} catch (Exception e) {
      //  e.printStackTrace();
    //} finally {
      //  try {
        //    con.close();
        //} catch (Exception e) {
          //  e.printStackTrace();
        //}
    //}
//}

}
