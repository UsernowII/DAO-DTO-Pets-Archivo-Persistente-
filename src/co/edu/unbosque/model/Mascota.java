package co.edu.unbosque.model;

import java.io.Serializable;

public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;

    public Mascota(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre + ", edad= " + edad;
    }

}
