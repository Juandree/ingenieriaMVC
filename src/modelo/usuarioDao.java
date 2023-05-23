package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class usuarioDao {

    Conexion conectar = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Usuario> listar() {
        List<Usuario> datos = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_completo"), rs.getString("email"), rs.getString("estado_cuenta"), rs.getLong("telefono"), rs.getString("direccion"), rs.getString("tipo_cliente"), rs.getString("fecha_registro"), rs.getString("contraseña"));
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNombre_completo(rs.getString("nombre_completo"));
                u.setEmail(rs.getString("email"));
                u.setEstado_cuenta(rs.getString("estado_cuenta"));
                u.setTelefono(rs.getLong("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setTipo_cliente(rs.getString("tipo_cliente"));
                u.setFecha_registro(rs.getString("fecha_registro"));
                u.setContrasena(rs.getString("contraseña"));
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

    public int agregar(Usuario u) {
        String sql = "INSERT INTO usuarios (id_usuario, nombre_completo, email, estado_cuenta, telefono, direccion, tipo_cliente, fecha_registro, contraseña) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId_usuario());
            ps.setString(2, u.getNombre_completo());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getEstado_cuenta());
            ps.setLong(5, u.getTelefono());
            ps.setString(6, u.getDireccion());
            ps.setString(7, u.getTipo_cliente());
            ps.setString(8, u.getFecha_registro());
            ps.setString(9, u.getContrasena());
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
        return 1;
    }

    public int actualizar(Usuario h) {
        int r=0;
        String SQL = "update usuarios set nombre_completo=?, email=?, estado_cuenta=?, telefono=?, direccion=?, tipo_cliente=?, fecha_registro=?, contraseña=? where id_usuario=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(SQL);
            ps.setString(1, h.getNombre_completo());
            ps.setString(2, h.getEmail());
            ps.setString(3, h.getEstado_cuenta());
            ps.setLong(4, h.getTelefono());
            ps.setString(5, h.getDireccion());
            ps.setString(6, h.getTipo_cliente());
            ps.setString(7, h.getFecha_registro());
            ps.setString(8, h.getContrasena());
            ps.setInt(9, h.getId_usuario());
            
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
    
    public void delete(int id_usuario) {
    String SQL = "DELETE FROM usuarios WHERE id_usuario=?";
    try {
        con = conectar.getConnection();
        ps = con.prepareStatement(SQL);
        ps.setInt(1, id_usuario);
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
