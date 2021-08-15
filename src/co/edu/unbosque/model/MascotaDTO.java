package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.MascotaDAO;

import java.io.File;
import java.util.ArrayList;

//CONTIENE EL ARREGLO DE OBJETOS
//CONTIENE EL OBJETO DAO
public class MascotaDTO {

    private ArrayList<Mascota> veterinaria;
    private MascotaDAO mascota_dao;
    private File file = new File("data/informacion.dat");
    private Archivo archivo;

    public MascotaDTO() {
        veterinaria = new ArrayList<Mascota>();
        archivo = new Archivo(file);
        mascota_dao = new MascotaDAO(archivo);
        veterinaria = archivo.leerArchivo(file);
    }

    public ArrayList<Mascota> getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(ArrayList<Mascota> veterinaria) {
        this.veterinaria = veterinaria;
    }

    public MascotaDAO getMascota_dao() {
        return mascota_dao;
    }

    public void setMascota_dao(MascotaDAO mascota_dao) {
        this.mascota_dao = mascota_dao;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }


}
