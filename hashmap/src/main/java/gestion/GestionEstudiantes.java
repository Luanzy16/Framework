/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import data.Estudiante;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;

public class GestionEstudiantes {
    private HashMap<String, Estudiante> estudiantes;

    public GestionEstudiantes() {
        this.estudiantes = new HashMap<>();
    }

    public void insertarEstudiante(String codigo, Estudiante estudiante) {
        estudiantes.put(codigo, estudiante);
    }

    public Estudiante consultarEstudiante(String codigo) {
        return estudiantes.get(codigo);
    }

    public void modificarEstudiante(String codigo, Estudiante estudiante) {
        estudiantes.put(codigo, estudiante);
    }

    public void borrarEstudiante(String codigo) {
        estudiantes.remove(codigo);
    }

    public DefaultTableModel getTableModel() {
        String[] columnas = {"Código", "Nombres", "Apellidos", "Dirección", "Teléfono", "Carrera"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (String codigo : estudiantes.keySet()) {
            Estudiante estudiante = estudiantes.get(codigo);
            Object[] fila = {codigo, estudiante.getNombres(), estudiante.getApellidos(),
                             estudiante.getDireccion(), estudiante.getTelefono(), estudiante.getCarrera()};
            modelo.addRow(fila);
        }

        return modelo;
    }




   
    //getters and setters
    
    public HashMap getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(HashMap estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
}
