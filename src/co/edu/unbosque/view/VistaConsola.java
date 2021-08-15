package co.edu.unbosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase encargada de la entrada y salida de información por la consola
 *
 * @author Pepito Pérez
 * @author Raul Díaz
 * @version 2.0
 */

public class VistaConsola {

    /**
     * Atributo que permite la lectura por consola
     */
    private Scanner leer;

    /**
     * Método constructor que inicializa el atributo de lectura por consola
     */
    public VistaConsola() {
        leer = new Scanner(System.in);
    }

    /**
     * Método para leer un dato String
     *
     * @param mensaje Mensaje para mostrar por consola
     * @return Dato String leido
     */
    public String leerDatoString(String mensaje) {
        System.out.println(mensaje);
        String dato = leer.nextLine();
        return dato;
    }

    /**
     * Leer dato de tipo long
     *
     * @param mensaje Mensaje para mostrar por consola
     * @return Datos long leido
     */
    public long leerDatoLong(String mensaje) {
        System.out.println(mensaje);
        long dato = leer.nextLong();
        leer.nextLine();
        return dato;
    }

    /**
     * Leer dato de tipo double
     *
     * @param mensaje Mensaje para mostrar por consola
     * @return Dato double leido
     */
    public double leerDatoDouble(String mensaje) {
        System.out.println(mensaje);
        double dato = leer.nextDouble();
        leer.nextLine();
        return dato;
    }

    /**
     * Método para leer un dato entero
     *
     * @param mensaje Mensaje para mostrar por consola
     * @return Dato entero leido
     */
    public int leerDatoEntero(String mensaje) {
        int dato = 0;
        boolean salida = false;
        do {
            System.out.println(mensaje);
            try {
                dato = leer.nextInt();
                salida = true;
            } catch (InputMismatchException ex) {
                System.out.println("Específica: Ingresó un dato no válido... :(");
                dato = 0;
            } finally {
                leer.nextLine();
            }
        } while (!salida);
        return dato;
    }

    /**
     * Método para mostar un mensaje por consola
     *
     * @param mensaje El texto a mostrar
     */
    public void mostrarInformacion(String mensaje) {
        System.out.println(mensaje);
    }

}
