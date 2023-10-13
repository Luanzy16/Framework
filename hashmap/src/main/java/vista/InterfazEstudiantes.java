/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import data.Estudiante;
import gestion.GestionEstudiantes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEstudiantes extends JFrame {
    private JTextField txtCodigo, txtNombres, txtApellidos, txtDireccion, txtTelefono, txtCarrera;
    private GestionEstudiantes gestionEstudiantes;
    private JTable table;

    public InterfazEstudiantes() {
        gestionEstudiantes = new GestionEstudiantes();

        // Configuración de la ventana
        setTitle("Gestión de Estudiantes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear paneles y componentes
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2));
        JPanel panelBotones = new JPanel(new FlowLayout());
        table = new JTable();

        txtCodigo = new JTextField();
        txtNombres = new JTextField();
        txtApellidos = new JTextField();
        txtDireccion = new JTextField();
        txtTelefono = new JTextField();
        txtCarrera = new JTextField();

        JButton btnAgregar = new JButton("Agregar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnConsultar = new JButton("Consultar");

        panelFormulario.add(new JLabel("Código:"));
        panelFormulario.add(txtCodigo);
        panelFormulario.add(new JLabel("Nombres:"));
        panelFormulario.add(txtNombres);
        panelFormulario.add(new JLabel("Apellidos:"));
        panelFormulario.add(txtApellidos);
        panelFormulario.add(new JLabel("Dirección:"));
        panelFormulario.add(txtDireccion);
        panelFormulario.add(new JLabel("Teléfono:"));
        panelFormulario.add(txtTelefono);
        panelFormulario.add(new JLabel("Carrera:"));
        panelFormulario.add(txtCarrera);

        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnConsultar);

        // Configurar acciones de los botones
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String nombres = txtNombres.getText();
                String apellidos = txtApellidos.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();
                String carrera = txtCarrera.getText();

                Estudiante estudiante = new Estudiante(nombres, apellidos, direccion, telefono, carrera);
                gestionEstudiantes.insertarEstudiante(codigo, estudiante);
                actualizarTabla();
                limpiarCampos();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String nombres = txtNombres.getText();
                String apellidos = txtApellidos.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();
                String carrera = txtCarrera.getText();

                Estudiante estudiante = new Estudiante(nombres, apellidos, direccion, telefono, carrera);
                gestionEstudiantes.modificarEstudiante(codigo, estudiante);
                actualizarTabla();
                limpiarCampos();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                gestionEstudiantes.borrarEstudiante(codigo);
                actualizarTabla();
                limpiarCampos();
            }
        });
        
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                Estudiante estudiante = gestionEstudiantes.consultarEstudiante(codigo);
                actualizarTabla();
                txtNombres.setText(estudiante.getNombres());
                txtApellidos.setText(estudiante.getApellidos());
                txtDireccion.setText(estudiante.getDireccion());
                txtTelefono.setText(estudiante.getTelefono());
                txtCarrera.setText(estudiante.getCarrera());
            }
        });

        // Añadir componentes a la ventana
        setLayout(new BorderLayout());
        add(panelFormulario, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void actualizarTabla() {
        table.setModel(gestionEstudiantes.getTableModel());
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCarrera.setText("");
    }

    public static void main(String[] args) {
        new InterfazEstudiantes();
    }
}

