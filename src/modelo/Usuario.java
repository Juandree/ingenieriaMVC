package modelo;

public class Usuario {
     int id_usuario;
     String nombre_completo;
     String email;
     String estado_cuenta;
     long telefono;
     String direccion;
     String tipo_cliente;
     String fecha_registro;
     String contrasena;

    public Usuario(int id_usuario, String nombre_completo, String email, String estado_cuenta, long telefono, String direccion, String tipo_cliente, String fecha_registro, String contrasena) {
        this.id_usuario = id_usuario;
        this.nombre_completo = nombre_completo;
        this.email = email;
        this.estado_cuenta = estado_cuenta;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo_cliente = tipo_cliente;
        this.fecha_registro = fecha_registro;
        this.contrasena = contrasena;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
