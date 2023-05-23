package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.espaciodeestacionamiento;

import modelo.espaciodeestacionamientoDAO;
import modelo.registroestacionamiento;

import vista.Vista;
import vista.VistaEspacioEstac;
import vista.VistaTodos;

public class ControladorEspacio implements ActionListener {

    espaciodeestacionamientoDAO dao = new espaciodeestacionamientoDAO();
    espaciodeestacionamiento u = new espaciodeestacionamiento(0, "", 0);
    VistaEspacioEstac vista = new VistaEspacioEstac();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorEspacio(VistaEspacioEstac v) {
         this.vista = v;
        this.vista.btnmostrar.addActionListener(this);
      
        this.vista.btneditar.addActionListener(this);
        this.vista.btnOk.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnmostrar) {
            limpiarTabla();
            listar(vista.tabla);

        }
        
        if (e.getSource() == vista.btneditar) {
            int fila = vista.tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            } else {
                int id_espacio_estacionamiento = Integer.parseInt((String) vista.tabla.getValueAt(fila, 0).toString());
                String disponibilidad = (String) vista.tabla.getValueAt(fila, 1);
               int numero_espacio = (int) vista.tabla.getValueAt(fila, 2);

                
                vista.txtidusuario.setText("" + id_espacio_estacionamiento);
                vista.txtnombre_completo.setText(disponibilidad);
                vista.txtemail.setText(""+numero_espacio);
                
            }
        }
        if (e.getSource() == vista.btnOk) {
            actualizar();
            limpiarTabla();
            listar(vista.tabla);
        }
        
    }
    

    void limpiarTabla() {
        for (int i = 0; i < vista.tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void actualizar() {
        int id_espacio_estacionamiento = Integer.parseInt(vista.txtidusuario.getText());
        String disponibilidad = vista.txtnombre_completo.getText();
        int numero_espacio = Integer.parseInt (vista.txtemail.getText());
        
        
        u.setId_espacio_estacionamiento(id_espacio_estacionamiento);
        u.setDisponibilidad(disponibilidad);
        u.setNumero_espacio(numero_espacio);
        

        int r = dao.actualizar(u);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Usuario acctualizado con exito");
        } else {
            JOptionPane.showMessageDialog(vista, "Error");
        }
    }


    public void listar(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<espaciodeestacionamiento> lista = dao.listar();
        Object[] object = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_espacio_estacionamiento();
            object[1] = lista.get(i).getDisponibilidad();
            object[2] = lista.get(i).getNumero_espacio();
            
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //////////////////////////////////
    
    
}