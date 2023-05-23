package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.registroestacionamiento;
import modelo.registroestacionamientoDao;
import vista.VistaRegistroEstacionamiento;

public class ControladorRe implements ActionListener {

    registroestacionamientoDao dao = new registroestacionamientoDao();
    registroestacionamiento p = new registroestacionamiento(null, null, null, 0.0, null, null, null);
    VistaRegistroEstacionamiento VistaRe = new VistaRegistroEstacionamiento();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorRe(VistaRegistroEstacionamiento v) {
        this.VistaRe = v;
        this.VistaRe.btnmostrar.addActionListener(this);
        this.VistaRe.btnguardar.addActionListener(this);
        this.VistaRe.btneditar.addActionListener(this);
        this.VistaRe.btnOk.addActionListener(this);
        this.VistaRe.btneliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VistaRe.btnmostrar) {
            listarRE(VistaRe.tabla);
            limpiarTablaRE();
            listarRE(VistaRe.tabla);
        }
        if (e.getSource() == VistaRe.btnguardar) {
            agregarRE();
            limpiarTablaRE();
            listarRE(VistaRe.tabla);
        }
        if (e.getSource() == VistaRe.btneditar) {
            int fila = VistaRe.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(VistaRe, "Debe seleccionar una fila");
            } else {
                Long id_registro_estacionamiento = (Long) VistaRe.tabla.getValueAt(fila, 0);
                String fecha_hora_entrada = (String) VistaRe.tabla.getValueAt(fila, 1);
                String fecha_hora_salida = (String) VistaRe.tabla.getValueAt(fila, 2);
                double cobro_total = Double.parseDouble(VistaRe.tabla.getValueAt(fila, 3).toString());
                Long id_vehiculo = (Long) VistaRe.tabla.getValueAt(fila, 4);
                Long id_espacio_estacionamiento = (Long) VistaRe.tabla.getValueAt(fila, 5);
                Long id_pago = (Long) VistaRe.tabla.getValueAt(fila, 6); // Corrección en este índice
                VistaRe.txtidregistroestacionamiento.setText("" + id_registro_estacionamiento);
                VistaRe.txtFecha_hora_entrada.setText(fecha_hora_entrada);
                VistaRe.txthorasalida.setText(fecha_hora_salida);
                VistaRe.txtcobrototal.setText(String.valueOf(cobro_total));
                VistaRe.txtidvehiculo.setText(String.valueOf(id_vehiculo));
                VistaRe.txtidespacioestacionamiento.setText(String.valueOf(id_espacio_estacionamiento));
                VistaRe.txtidpago.setText(String.valueOf(id_pago));
            }
        }
        if (e.getSource() == VistaRe.btnOk) {
            actualizarRE();
            limpiarTablaRE();
            listarRE(VistaRe.tabla);
        }
        if (e.getSource() == VistaRe.btneliminar) {
            eliminarRE();
            limpiarTablaRE();
            listarRE(VistaRe.tabla);
        }

    }

    void limpiarTablaRE() {
        for (int i = 0; i < VistaRe.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void eliminarRE() {
        int fila = VistaRe.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(VistaRe, "Debe seleccionar un usuario a eliminar");
        } else {
            int id_usuario = Integer.parseInt((String) VistaRe.tabla.getValueAt(fila, 0).toString());
            dao.delete(id_usuario);
            JOptionPane.showMessageDialog(VistaRe, "Usuario eliminado");
        }
    }
     public void actualizarRE() {
     Long id_registro_estacionamiento = Long.parseLong(VistaRe.txtidregistroestacionamiento.getText());
        String fecha_hora_entrada = VistaRe.txtFecha_hora_entrada.getText();
        String fecha_hora_salida = VistaRe.txthorasalida.getText();
        double cobro_total = Double.parseDouble(VistaRe.txtcobrototal.getText());
        Long id_vehiculo = Long.parseLong(VistaRe.txtidvehiculo.getText());
        Long id_espacio_estacionamiento = Long.parseLong(VistaRe.txtidespacioestacionamiento.getText());
        Long id_pago = Long.parseLong(VistaRe.txtidpago.getText());

       
        p.setId_registro_estacionamiento(id_registro_estacionamiento);
        p.setFecha_hora_entrada(fecha_hora_entrada);
        p.setFecha_hora_salida(fecha_hora_salida);
        p.setCobro_total(cobro_total);
        p.setId_vehiculo(id_vehiculo);
        p.setId_espacio_estacionamiento(id_espacio_estacionamiento);
        p.setId_pago(id_pago);

        int r = dao.actualizar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(VistaRe, "Registro de estacionamiento actualizado con éxito");
        } else {
            JOptionPane.showMessageDialog(VistaRe, "Error al actualizar el registro de estacionamiento");
        }
}

    public void agregarRE() {
        Long id_registro_estacionamiento = Long.parseLong(VistaRe.txtidregistroestacionamiento.getText());
        String fecha_hora_entrada = VistaRe.txtFecha_hora_entrada.getText();
        String fecha_hora_salida = VistaRe.txthorasalida.getText();
        double cobro_total = Double.parseDouble(VistaRe.txtcobrototal.getText());
        Long id_vehiculo = Long.parseLong(VistaRe.txtidvehiculo.getText());
        Long id_espacio_estacionamiento = Long.parseLong(VistaRe.txtidespacioestacionamiento.getText());
        Long id_pago = Long.parseLong(VistaRe.txtidpago.getText());

        p.setId_registro_estacionamiento(id_registro_estacionamiento);
        p.setFecha_hora_entrada(fecha_hora_entrada);
        p.setFecha_hora_salida(fecha_hora_salida);
        p.setCobro_total(cobro_total);
        p.setId_vehiculo(id_vehiculo);
        p.setId_espacio_estacionamiento(id_espacio_estacionamiento);
        p.setId_pago(id_pago);

        int r = dao.agregar(p);
        if (r == 1) {
            JOptionPane.showMessageDialog(VistaRe, "Registro guardado con éxito");
        } else {
            JOptionPane.showMessageDialog(VistaRe, "Error");
        }
    }

    public void listarRE(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<registroestacionamiento> Lista = dao.listar();
        Object[] object = new Object[7];
        for (int i = 0; i < Lista.size(); i++) {
            object[0] = Lista.get(i).getId_registro_estacionamiento();
            object[1] = Lista.get(i).getFecha_hora_entrada();
            object[2] = Lista.get(i).getFecha_hora_salida();
            object[3] = Lista.get(i).getCobro_total();
            object[4] = Lista.get(i).getId_vehiculo();
            object[5] = Lista.get(i).getId_espacio_estacionamiento();
            object[6] = Lista.get(i).getId_pago();
            modelo.addRow(object);
        }
        VistaRe.tabla.setModel(modelo);

    }

   


}
