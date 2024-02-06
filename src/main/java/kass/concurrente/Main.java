package kass.concurrente;
import java.util.Random;

/**
 * Clase Main
 * Aqui va toda tu simulacion
 * Genera un par de clientes para que los atienda el chef
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Main {    

    public static void main(String[] args) {
        Random r = new Random();
        int clientes = r.nextInt(10)+1;
        System.out.println("Iniciando el servicio. El chef Ha llegado.\n");
        System.out.println(clientes + " clientes en la fila.\n");
    }

    
}
