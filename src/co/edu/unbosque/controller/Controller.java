package co.edu.unbosque.controller;

import co.edu.unbosque.model.Mascota;
import co.edu.unbosque.model.MascotaDTO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {

    private VistaConsola vista;
    private MascotaDTO dto;

    public Controller() {
        vista = new VistaConsola();
        dto = new MascotaDTO();
        funcionar();
    }

    public void funcionar() {
        String nom = "";
        int e = 0;
        int opcion = 0;

        String menu = "operaciones" + "\n"
                + "1. adicionar" + "\n"
                + "2. ver todos" + "\n"
                + "3. buscar" + "\n"
                + "4. elminar" + "\n"
                + "5. modificar" + "\n"
                + "6. consulta mayores" + "\n"
                + "7. salir" + "\n"
                + "Opcion: ";
        do {
            opcion = vista.leerDatoEntero(menu);

            switch (opcion) {
                case 1:
                    insertarMascota();
                    break;
                case 2:
                    verListado();
                    break;
                case 3:
                    buscarMascota();
                    break;
                case 4:
                    elminiarMascosta();
                    break;
                case 5:
                    modificarMascota();
                    break;
                case 6:
                    consultaMyoresEdad();
                    break;
                case 7:
                    vista.mostrarInformacion("Hasta pronto");
                default:
                    vista.mostrarInformacion("Error: escogio una opción inválida");
            }
        } while (opcion != 7);

    }

    public void modificarMascota() {

        String n = vista.leerDatoString("Digite nombre de la mascota a actualizar: ");
        if (dto.getMascota_dao().buscarMascota(n)!= null) {
            int e = vista.leerDatoEntero("Edad mascota");
            if (dto.getMascota_dao().modificarMascota(n,e)){
                vista.mostrarInformacion("Se modifico el registro");
            }else {
                vista.mostrarInformacion("No se actualizo registro");
            }
        } else {
            vista.mostrarInformacion("no se actualizo registro");
        }
    }

    public void insertarMascota(){
        String n = vista.leerDatoString("Nombre mascota");
        int e = vista.leerDatoEntero("Edad mascota: ");
        if (dto.getMascota_dao().agregarMascota(n,e)){
            vista.mostrarInformacion("Se agrego");
        }else{
            vista.mostrarInformacion("No se agrego");
        }
    }

    public void verListado(){
        String rta = dto.getMascota_dao().mostrarListado();
        vista.mostrarInformacion(rta);
    }


    public void buscarMascota(){
        String n = vista.leerDatoString("Digite el nombre de la mascota a bucar");
        Mascota rta = dto.getMascota_dao().buscarMascota(n);
        if (rta != null){
            vista.mostrarInformacion(rta.toString());
        }else {
            vista.mostrarInformacion("No se encontro la BD");
        }
    }

    public void elminiarMascosta(){
        String n = vista.leerDatoString("Nombre mascosta a eliminar");
        if (dto.getMascota_dao().eliminarMascota(n)){
            vista.mostrarInformacion("Se elimino registro");
        }else{
            vista.mostrarInformacion("no Se elimino registro");
        }

    }
    public void consultaMyoresEdad(){
        int edad = vista.leerDatoEntero("Digite l");
    }
}
