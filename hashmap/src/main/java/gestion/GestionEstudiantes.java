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
    /**
     * funcion que añade un estudiante al diccionario
     * @param codigo
     * @param estudiante 
     */
    public void insertarEstudiante(String codigo, Estudiante estudiante) {
        estudiantes.put(codigo, estudiante);
    }

    /**
     * Funcion que retorna un Objeto estudiante a partir del codigo(KEY)
     * @param codigo
     * @return Objeto Estudiante
     */
    public Estudiante consultarEstudiante(String codigo) {
        return estudiantes.get(codigo);
    }
    
    /**
     * Funcion que modifica un Estudiante que ya estaba en el diccionario
     * @param codigo
     * @param estudiante 
     */
    public void modificarEstudiante(String codigo, Estudiante estudiante) {
        estudiantes.put(codigo, estudiante);
    }
    
    /**
     * Funcion que elimina a un estudiante del diccionario
     * @param codigo 
     */
    public void borrarEstudiante(String codigo) {
        estudiantes.remove(codigo);
    }

    /**
     * Funcion que crea un modelo de tabla con todos los estudiante en el diccionario
     * @return Modelo de tabla
     */
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
