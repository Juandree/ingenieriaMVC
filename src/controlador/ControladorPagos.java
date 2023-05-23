package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Pagos;
import vista.Vista;
import vista.VistaTodos;
import modelo.EnumPago;
import modelo.PagosDAO;
import vista.VistaPago;

public class ControladorPagos implements ActionListener {

    PagosDAO dao = new PagosDAO();
    Pagos u = new Pagos(0, EnumPago.efectivo, 0, 0, 0, 0, 0, 0);

    VistaPago VistaPago = new VistaPago();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorPagos(VistaPago v) {
        this.VistaPago = v;
        this.VistaPago.btnmostrar.addActionListener(this);
        this.VistaPago.btnguardar.addActionListener(this);
        this.VistaPago.btneditar.addActionListener(this);
        this.VistaPago.btnOk.addActionListener(this);
        this.VistaPago.btneliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == VistaPago.btnmostrar) {
            limpiarTabla();
            listar(VistaPago.tabla);

        }
        if (e.getSource() == VistaPago.btnguardar) {
            agregar();
            limpiarTabla();
            listar(VistaPago.tabla);
        }
        if (e.getSource() == VistaPago.btneditar) {
            int fila = VistaPago.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(VistaPago, "Debe seleccionar una fila");
            } else {
                int id_pago = Integer.parseInt(VistaPago.tabla.getValueAt(fila, 0).toString());
                EnumPago enumpago = (EnumPago) VistaPago.tabla.getValueAt(fila, 1);

                double ingresos_totales = Double.parseDouble(VistaPago.tabla.getValueAt(fila, 2).toString());
                String fecha_hora_generacionString = VistaPago.tabla.getValueAt(fila, 3).toString();
                String fecha_hora_pagoString = VistaPago.tabla.getValueAt(fila, 4).toString();
                double ganancias_totales = Double.parseDouble(VistaPago.tabla.getValueAt(fila, 5).toString());
                double egresos_totales = Double.parseDouble(VistaPago.tabla.getValueAt(fila, 6).toString());
                double monto_de_pago = Double.parseDouble(VistaPago.tabla.getValueAt(fila, 7).toString());

                System.out.println("Fecha y hora de generación: " + fecha_hora_generacionString);
                System.out.println("Fecha y hora de pago: " + fecha_hora_pagoString);

                LocalDateTime fecha_hora_generacion = LocalDateTime.parse(fecha_hora_generacionString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
                LocalDateTime fecha_hora_pago = LocalDateTime.parse(fecha_hora_pagoString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

                VistaPago.txtidusuario.setText(String.valueOf(id_pago));
                VistaPago.txtnombre_completo.setText(enumpago.toString());
                VistaPago.txtemail.setText(String.valueOf(ingresos_totales));
                VistaPago.txtestado_cuenta.setText(fecha_hora_generacion.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                VistaPago.txttelefono.setText(fecha_hora_pago.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                VistaPago.txtdireccion.setText(String.valueOf(ganancias_totales));
                VistaPago.txttipocliente.setText(String.valueOf(egresos_totales));
                VistaPago.txtfecharegistro.setText(String.valueOf(monto_de_pago));
            }
        }
       if (e.getSource() == VistaPago.btnOk) {
    try {
        int id_pago = Integer.parseInt(VistaPago.txtidusuario.getText());
        String metodo_pagoString = VistaPago.txtnombre_completo.getText();
        EnumPago metodo_pago = EnumPago.valueOf(metodo_pagoString);
        double ingresos_totales = Double.parseDouble(VistaPago.txtemail.getText());
        String fecha_hora_generacionString = VistaPago.txtestado_cuenta.getText();
        String fecha_hora_pagoString = VistaPago.txttelefono.getText();
        double ganancias_totales = Double.parseDouble(VistaPago.txtdireccion.getText());
        double egresos_totales = Double.parseDouble(VistaPago.txttipocliente.getText());
        double monto_de_pago = Double.parseDouble(VistaPago.txtfecharegistro.getText());

        LocalDateTime fecha_hora_generacion = LocalDateTime.parse(fecha_hora_generacionString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime fecha_hora_pago = LocalDateTime.parse(fecha_hora_pagoString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        u.setId_pago(id_pago);
        u.setMetodo_pago(metodo_pago);
        u.setIngresos_totales(ingresos_totales);
        u.setFecha_hora_generacion(fecha_hora_generacion);
        u.setFecha_hora_pago(fecha_hora_pago);
        u.setGanacias_totales(ganancias_totales);
        u.setEgresos_totales(egresos_totales);
        u.setMonto_de_pago(monto_de_pago);

        int r = dao.actualizar(u);
        if (r == 1) {
            JOptionPane.showMessageDialog(VistaPago, "Usuario actualizado con éxito");
            limpiarTabla();
            listar(VistaPago.tabla);
        } else {
            JOptionPane.showMessageDialog(VistaPago, "Error al actualizar usuario");
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(VistaPago, "Error: Formato de número inválido");
    } catch (DateTimeParseException ex) {
        JOptionPane.showMessageDialog(VistaPago, "Error: Formato de fecha y hora inválido");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(VistaPago, "Error: " + ex.getMessage());
    }
    
}
    }

    public void eliminar() {
        int fila = VistaPago.tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(VistaPago, "Debe seleccionar un usuario a eliminar");
        } else {
            int id_usuario = Integer.parseInt((String) VistaPago.tabla.getValueAt(fila, 0).toString());
            dao.delete(id_usuario);
            JOptionPane.showMessageDialog(VistaPago, "Usuario eliminado");
        }
    }

    void limpiarTabla() {
        for (int i = 0; i < VistaPago.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void actualizar() {
        int id_pago = Integer.parseInt(VistaPago.txtidusuario.getText());
        EnumPago metodo_pago = EnumPago.valueOf(VistaPago.txtnombre_completo.getText());
        double ingresos_totales = Double.parseDouble(VistaPago.txtemail.getText());
        LocalDateTime fecha_hora_generacion = LocalDateTime.parse(VistaPago.txtestado_cuenta.getText());
        LocalDateTime fecha_hora_pago = LocalDateTime.parse(VistaPago.txttelefono.getText());
        double ganacias_totales = Double.parseDouble(VistaPago.txtdireccion.getText());
        double egresos_totales = Double.parseDouble(VistaPago.txttipocliente.getText());
        double monto_de_pago = Double.parseDouble(VistaPago.txtfecharegistro.getText());

        int id_pagoActualizado = Integer.parseInt(VistaPago.txtidusuario.getText());

        Pagos u = new Pagos(id_pagoActualizado, metodo_pago, ingresos_totales, fecha_hora_generacion, fecha_hora_pago, ganacias_totales, egresos_totales, monto_de_pago);

        int r = dao.actualizar(u);
        if (r == 1) {
            JOptionPane.showMessageDialog(VistaPago, "Usuario actualizado con éxito");
        } else {
            JOptionPane.showMessageDialog(VistaPago, "Error");
        }
    }

    public void agregar() {
    int id_pago = Integer.parseInt(VistaPago.txtidusuario.getText());
    String metodo_pagoString = VistaPago.txtnombre_completo.getText();
    EnumPago metodo_pago = EnumPago.valueOf(metodo_pagoString);
    double ingresos_totales = Double.parseDouble(VistaPago.txtemail.getText());
    String fecha_hora_generacionString = VistaPago.txtestado_cuenta.getText();
    String fecha_hora_pagoString = VistaPago.txttelefono.getText();
    double ganancias_totales = Double.parseDouble(VistaPago.txtdireccion.getText());
    double egresos_totales = Double.parseDouble(VistaPago.txttipocliente.getText());
    double monto_de_pago = Double.parseDouble(VistaPago.txtfecharegistro.getText());

    
        LocalDateTime fecha_hora_generacion = LocalDateTime.parse(fecha_hora_generacionString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime fecha_hora_pago = LocalDateTime.parse(fecha_hora_pagoString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Pagos s = new Pagos(id_pago, metodo_pago, ingresos_totales, fecha_hora_generacion, fecha_hora_pago, ganancias_totales, egresos_totales, monto_de_pago);

        int r = dao.agregar(s);
        if (r == 1) {
            JOptionPane.showMessageDialog(VistaPago, "Registro guardado con éxito");
        } else {
            JOptionPane.showMessageDialog(VistaPago, "Error al guardar registro");
        
}
    }


    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Pagos> lista = dao.listar();
        Object[] object = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_pago();
            object[1] = lista.get(i).getMetodo_pago();
            object[2] = lista.get(i).getIngresos_totales();
            object[3] = lista.get(i).getFecha_hora_generacion();
            object[4] = lista.get(i).getFecha_hora_pago();
            object[5] = lista.get(i).getGanacias_totales();
            object[6] = lista.get(i).getEgresos_totales();
            object[7] = lista.get(i).getMonto_de_pago();
            modelo.addRow(object);
        }
        VistaPago.tabla.setModel(modelo);
    }

    //////////////////////////////////
}
