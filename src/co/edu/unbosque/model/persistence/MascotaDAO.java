package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Mascota;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//ACCESO AL CRUD
public class MascotaDAO {

    private Archivo archivo;

    public MascotaDAO(Archivo archivo) {
        this.archivo = archivo;
    }

    public boolean agregarMascota(String nombre, int edad, ArrayList<Mascota> veterinaria, File file) {
        Mascota nueva = new Mascota(nombre, edad);
        if (buscarMascota(nombre, veterinaria) == null) {
            veterinaria.add(nueva);
            archivo.escribirArchivo(veterinaria, file);
            return true;
        } else {
            return false;
        }
    }

    public Mascota buscarMascota(String nombre, ArrayList<Mascota> veterinaria) {
        Mascota encontrada = null;

        if (!veterinaria.isEmpty()) {
            //for elemento in lista:
            for (Mascota mascota : veterinaria) {
                if (nombre.equals(mascota.getNombre())) {
                    encontrada = mascota;
                }
            }
        }

        return encontrada;
    }

    public boolean eliminarMascota(String nombre, ArrayList<Mascota> veterinaria, File file) {
        try {
            Mascota m = buscarMascota(nombre, veterinaria);
            if (m == null) {
                return false;
            } else {
                veterinaria.remove(m);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivo(veterinaria, file);
                return true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean modificarMascota(String nombre, String nombre2, int edad, ArrayList<Mascota> veterinaria, File file) {
        Mascota encontrada = buscarMascota(nombre, veterinaria);
        try {
            if (encontrada != null) {
                eliminarMascota(nombre, veterinaria, file);
                encontrada.setNombre(nombre2);
                encontrada.setEdad(edad);
                veterinaria.add(encontrada);
                file.delete();
                file.createNewFile();
                archivo.escribirArchivo(veterinaria, file);
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String mostrarListado(File file) {
        ArrayList<Mascota> veterinaria = archivo.leerArchivo(file);
        String listado = "";
        for (Mascota mascota : veterinaria) {
            listado = listado.concat(mascota.toString() + "\n");
        }
        return listado;
    }

}
