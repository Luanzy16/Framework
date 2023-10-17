/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Usuario
 */
public class CantanteFamoso {
    //atributos
    private String nombre;
    private String discoConMasVentas;
    private int ventas;

    //constructor
    public CantanteFamoso(String nombre, String discoConMasVentas,int ventas) {
        this.nombre = nombre;
        this.discoConMasVentas = discoConMasVentas;
        this.ventas = ventas;
    }
    
    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiscoConMasVentas() {
        return discoConMasVentas;
    }

    public void setDiscoConMasVentas(String discoConMasVentas) {
        this.discoConMasVentas = discoConMasVentas;
    }
    
    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}

