/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Usuario
 */
import data.CantanteFamoso;
import gestion.GestionCantante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaCantante extends JFrame implements ActionListener {
    private GestionCantante listaCantantes;
    private JTable table;
    private JTextField JTnombre, JTdisco;

    public VistaCantante() {
        listaCantantes = new GestionCantante();

        // Configurar la ventana
        setTitle("Lista de Cantantes Famosos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes
        JPanel panel = new JPanel(new GridLayout(6, 2));
        JPanel panelBotones = new JPanel(new FlowLayout());
        table = new JTable();
       
        //paneles de texto
        JTnombre = new JTextField();
        JTdisco = new JTextField();

        //botones
        JButton insertar = new JButton("INSERTAR");
        JButton modificar = new JButton("MODIFICAR");
        JButton eliminar = new JButton("ELIMININAR");

        // Agregar componentes al panel
        panel.add(new JLabel("Nombre del Cantante:"));
        panel.add(JTnombre);
        panel.add(new JLabel("Disco más Vendido:"));
        panel.add(JTdisco);
        
        //Agregar componentes al panelBotones
        panelBotones.add(insertar);
        panelBotones.add(modificar);
        panelBotones.add(eliminar);
        
        //Configurar acciones de botones
        insertar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JTnombre.getText();
                String disco = JTdisco.getText();
                
                CantanteFamoso cantante = new CantanteFamoso(nombre, disco);
                listaCantantes.agregarCantante(cantante);
                actualizarTabla();
                limpiarCampos();
            }
        });
        
        modificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JTnombre.getText();
                String nuevoNombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre");
                
                listaCantantes.modificar(nombre, nuevoNombre);
                actualizarTabla();
                limpiarCampos();
                
            }
            
        });
        
        eliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JTnombre.getText();
                listaCantantes.eliminarCantante(nombre);
                actualizarTabla();
                limpiarCampos();
            }
            
        });
        
        

        // Agregar el panel y la tabla a la ventana
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        
        
        
        
    }

    /**
     * funcion que actualiza la tabla 
     */
    private void actualizarTabla() {
        table.setModel(listaCantantes.getTableModel());
    }
    
    /**
     * funcion que limpia los paneles de texto
     */
    private void limpiarCampos(){
        JTnombre.setText("");
        JTdisco.setText("");
    }
    public static void main(String[] args) {
        VistaCantante frame = new VistaCantante();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
