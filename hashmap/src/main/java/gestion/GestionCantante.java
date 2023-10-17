/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

/**
 *
 * @author Usuario
 */
import data.CantanteFamoso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionCantante {
    private List<CantanteFamoso> listaCantantesFamosos;

    public GestionCantante() {
        listaCantantesFamosos = new ArrayList<>();
    }

    
    /**
     * Funcion que añade un cantante a la lista "listaCantantesFamosos"
     * @param cantante 
     */
    public void agregarCantante(CantanteFamoso cantante) {
        if(containsSpecialCharacter(cantante.getNombre()) || containsSpecialCharacter(cantante.getDiscoConMasVentas())){
            JOptionPane.showMessageDialog(null, "No se pueden poner caracteres especiles");
            return;
        }
        listaCantantesFamosos.add(cantante);
    }

    

    /**
     * Funcion que elimina un cantante de la lista con recorriendola con "Iterador"
     * @param nombre 
     */
    public void eliminarCantante(String nombre) {
        Iterator<CantanteFamoso> iterator = listaCantantesFamosos.iterator();
        while (iterator.hasNext()) {
            CantanteFamoso cantante = iterator.next();
            if (cantante.getNombre().equals(nombre)) {
                iterator.remove();
            }
        }

    }

    /**
     * funcion que modifica el nombre de un cantante que ya estaba en al lista
     * @param nombreActual
     * @param nuevoNombre 
     */
    public void modificar(String nombreActual, String nuevoNombre) {
        for (CantanteFamoso cantante : listaCantantesFamosos) {
            if (cantante.getNombre().equals(nombreActual)) {
                cantante.setNombre(nuevoNombre);
                
            }
        }
    }
    
    /**
     * Funcionq eu genera un modelo de tabla con todos los cantantes de la lista
     * @return Modelo de tabla
     */
    public DefaultTableModel getTableModel() {
        String[] columnas = {"Nombre", "Disco","ventas"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (CantanteFamoso x : listaCantantesFamosos) {
            Object[] fila = {x.getNombre(),x.getDiscoConMasVentas(),x.getVentas()};
            modelo.addRow(fila);
        }

        return modelo;
    }
    
    /**
     * Funcion que ordena la lsita por medio del atributo de ventas de la lista
     */
    public void ordenarPorVentas() {
        Collections.sort(listaCantantesFamosos, new Comparator<CantanteFamoso>() {
            @Override
            public int compare(CantanteFamoso cantante1, CantanteFamoso cantante2) {
                return Integer.compare(cantante1.getVentas(), cantante2.getVentas());
            }
        });
    }

    // Método para verificar si una cadena contiene caracteres especiales
    private boolean containsSpecialCharacter(String str) {
        return !str.matches("[a-zA-Z0-9 ]*");
    }
    
    //getters y setters
    public List<CantanteFamoso> getListaCantantesFamosos() {
        return listaCantantesFamosos;
    }

    public void setListaCantantesFamosos(List<CantanteFamoso> listaCantantesFamosos) {
        this.listaCantantesFamosos = listaCantantesFamosos;
    }
}

