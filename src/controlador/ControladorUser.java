package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.usuarioDao;
import vista.Vista;
import vista.VistaTodos;

public class ControladorUser implements ActionListener {

    usuarioDao dao = new usuarioDao();
    Usuario u = new Usuario(0, "", "", "", 0, "", "", "", "");
    Vista vista = new Vista();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorUser(Vista v) {
        this.vista = v;
        this.vista.btnmostrar.addActionListener(this);
        this.vista.btnguardar.addActionListener(this);
        this.vista.btneditar.addActionListener(this);
        this.vista.btnOk.addActionListener(this);
        this.vista.btneliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnmostrar) {
            limpiarTabla();
            listar(vista.tabla);

        }
        if (e.getSource() == vista.btnguardar) {
            agregar();
            limpiarTabla();
            listar(vista.tabla);
        }
        if (e.getSource() == vista.btneditar) {
            int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            } else {
                int id_usuario = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String nombre_completo = (String) vista.tabla.getValueAt(fila, 1);
                String email = (String) vista.tabla.getValueAt(fila, 2);
                String estado_cuenta = (String) vista.tabla.getValueAt(fila, 3);
                long telefono = (long) vista.tabla.getValueAt(fila, 4);
                String direccion = (String) vista.tabla.getValueAt(fila, 5);
                String tipo_cliente = (String) vista.tabla.getValueAt(fila, 6);
                String fecha_registro = (String) vista.tabla.getValueAt(fila, 7);
                String contrasena = (String) vista.tabla.getValueAt(fila, 8);
                vista.txtidusuario.setText("" + id_usuario);
                vista.txtnombre_completo.setText(nombre_completo);
                vista.txtemail.setText(email);
                vista.txtestado_cuenta.setText(estado_cuenta);
                vista.txttelefono.setText("" + telefono);
                vista.txtdireccion.setText(direccion);
                vista.txttipocliente.setText(tipo_cliente);
                vista.txtfecharegistro.setText(fecha_registro);
                vista.txtContraseña.setText(contrasena);
            }
        }
        if (e.getSource() == vista.btnOk) {
            actualizar();
            limpiarTabla();
            listar(vista.tabla);
        }
        if (e.getSource() == vista.btneliminar) {
            eliminar();
            limpiarTabla();
            listar(vista.tabla);
        }
    }
    public void eliminar(){
        int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar un usuario a eliminar");
            } else {
                int id_usuario = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                dao.delete(id_usuario);
                JOptionPane.showMessageDialog(vista, "Usuario eliminado");
            }
    }

    void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void actualizar() {
        int id_usuario = Integer.parseInt(vista.txtidusuario.getText());
        String nombre_completo = vista.txtnombre_completo.getText();
        String email = vista.txtemail.getText();
        String estado_cuenta = vista.txtestado_cuenta.getText();
        long telefono = Long.parseLong(vista.txttelefono.getText());
        String direccion = vista.txtdireccion.getText();
        String tipo_cliente = vista.txttipocliente.getText();
        String fecha_registro = vista.txtfecharegistro.getText();
        String contrasena = vista.txtContraseña.getText();
        u.setId_usuario(id_usuario);
        u.setNombre_completo(nombre_completo);
        u.setEmail(email);
        u.setEstado_cuenta(estado_cuenta);
        u.setTelefono(telefono);
        u.setDireccion(direccion);
        u.setTipo_cliente(tipo_cliente);
        u.setFecha_registro(fecha_registro);
        u.setContrasena(contrasena);

        int r = dao.actualizar(u);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Usuario acctualizado con exito");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
    }

    public void agregar() {
        int id_usuario = Integer.parseInt(vista.txtidusuario.getText());
        String nombre_completo = vista.txtnombre_completo.getText();
        String email = vista.txtemail.getText();
        String estado_cuenta = vista.txtestado_cuenta.getText();
        long telefono = Long.parseLong(vista.txttelefono.getText());
        String direccion = vista.txtdireccion.getText();
        String tipo_cliente = vista.txttipocliente.getText();
        String fecha_registro = vista.txtfecharegistro.getText();
        String contrasena = vista.txtContraseña.getText();

        u = new Usuario(id_usuario, nombre_completo, email, estado_cuenta, telefono, direccion, tipo_cliente, fecha_registro, contrasena);

        int r = dao.agregar(u);

        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Registro guardado con éxito");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al guardar registro");
        }
    }

    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Usuario> lista = dao.listar();
        Object[] object = new Object[9];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_usuario();
            object[1] = lista.get(i).getNombre_completo();
            object[2] = lista.get(i).getEmail();
            object[3] = lista.get(i).getEstado_cuenta();
            object[4] = lista.get(i).getTelefono();
            object[5] = lista.get(i).getDireccion();
            object[6] = lista.get(i).getTipo_cliente();
            object[7] = lista.get(i).getFecha_registro();
            object[8] = lista.get(i).getContrasena();
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //////////////////////////////////
    
    
}