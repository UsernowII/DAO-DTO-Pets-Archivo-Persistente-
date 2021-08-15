package co.edu.unbosque.controller;

import co.edu.unbosque.model.MascotaDTO;
import co.edu.unbosque.view.VistaConsola;

public class Controller {

    private VistaConsola vista;
    private MascotaDTO mas;

    public Controller() {
        vista = new VistaConsola();
        mas = new MascotaDTO();
        funcionar();
    }

    public void funcionar() {
        String nom = "";
        int e = 0;
        int opcion = 0;

        String menu = "jnckjsnksdj" + "\n"
                + "1. Mod" + "\n"
                + "2. Salir" + "\n"
                + "Opcion: ";
        do {
            opcion = vista.leerDatoEntero(menu);

            switch (opcion) {
                case 1:
                    opcionModificar();
                    break;
                case 2:
                    vista.mostrarInformacion("Chao... Gracias");
                    break;
                default:
                    vista.mostrarInformacion("Error: escogio una opción inválida");
            }
        } while (opcion != 2);

        vista.mostrarInformacion("" + mas.getMascota_dao().mostrarListado(mas.getFile()));
        /*
        vista.mostrarInformacion(""+mas.getMascota_dao().agregarMascota("Luis", 12, mas.getVeterinaria(), mas.getFile()));
        vista.mostrarInformacion(""+mas.getMascota_dao().agregarMascota("Max", 2, mas.getVeterinaria(), mas.getFile()));
        //vista.mostrarInformacion(""+mas.getMascota_dao().agregarMascota("Luis", 34, mas.getVeterinaria()));
        vista.mostrarInformacion(""+mas.getMascota_dao().agregarMascota("Veneno", 5, mas.getVeterinaria(), mas.getFile()));
        
        nom = vista.leerDatoString("Digite nombre: ");
        e = vista.leerDatoEntero("Digite edad: ");
        
        vista.mostrarInformacion(""+mas.getMascota_dao().agregarMascota(nom, e, mas.getVeterinaria(), mas.getFile()));
        
        nom = vista.leerDatoString("Digite nombre: ");
        e = vista.leerDatoEntero("Digite edad: ");
        
        vista.mostrarInformacion(""+mas.getMascota_dao().agregarMascota(nom, e, mas.getVeterinaria(), mas.getFile()));
         */

    }

    public void opcionModificar() {

        String nom = vista.leerDatoString("Digite nombre de la mascota a actualizar: ");
        if (mas.getMascota_dao().buscarMascota(nom, mas.getVeterinaria()) != null) {
            String nom2 = vista.leerDatoString("Digite nuevo nombre de la mascota a actualizar: ");
            int e = vista.leerDatoEntero("Digite nueva edad: ");

            vista.mostrarInformacion("" + mas.getMascota_dao().modificarMascota(nom, nom2, e, mas.getVeterinaria(), mas.getFile()));
            vista.mostrarInformacion("La mascota fue actualizada");
        } else {
            vista.mostrarInformacion("La mascota no está registrada");
        }
        vista.mostrarInformacion("");
        vista.mostrarInformacion("" + mas.getMascota_dao().mostrarListado(mas.getFile()));

    }
}
