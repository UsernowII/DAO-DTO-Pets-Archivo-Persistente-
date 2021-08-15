package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Connect;
import co.edu.unbosque.model.persistence.MascotaDAO;

import java.io.File;
import java.util.ArrayList;

//CONTIENE EL OBJETO CONNECT
//CONTIENE EL OBJETO DAO
public class MascotaDTO {

    private MascotaDAO mascota_dao;
    private Connect connect;

    /**
     * Método constructor para usar los metodos de connect mediante el Dao
     */
    public MascotaDTO() {
        connect = new Connect();
        mascota_dao = new MascotaDAO(connect);
    }


    //GETTER AND SETTER

    public MascotaDAO getMascota_dao() {
        return mascota_dao;
    }

    public void setMascota_dao(MascotaDAO mascota_dao) {
        this.mascota_dao = mascota_dao;
    }
    public Connect getConnect(){
        return connect;
    }

    public void setConnect(Connect connect){
        this.connect = connect;
    }



}
