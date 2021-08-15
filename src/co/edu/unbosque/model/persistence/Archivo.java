package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.Mascota;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    //Constructor
    public Archivo(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void escribirArchivo(ArrayList<Mascota> veterinaria, File file) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(file));
            salida.writeObject(veterinaria);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Mascota> leerArchivo(File file) {
        ArrayList<Mascota> veterinaria = new ArrayList<Mascota>();
        if (file.length() != 0) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(file));
                veterinaria = (ArrayList<Mascota>) entrada.readObject();
                entrada.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        return veterinaria;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void setSalida(ObjectOutputStream salida) {
        this.salida = salida;
    }

}
