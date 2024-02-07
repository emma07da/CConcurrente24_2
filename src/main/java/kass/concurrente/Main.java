package kass.concurrente;

import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kass.concurrente.modelo.cuchillo.Cuchillo;
import kass.concurrente.modelo.cuchillo.CuchilloNormal;
import kass.concurrente.modelo.cuchillo.CuchilloCeramica;
import kass.concurrente.modelo.cuchillo.CuchilloDiamante;
import kass.concurrente.modelo.cuchillo.CuchilloTitanio;
import kass.concurrente.modelo.cuchillo.CuchilloDecorator;
import kass.concurrente.modelo.producto.Platillo;
import kass.concurrente.modelo.producto.Producto;
import kass.concurrente.modelo.producto.ProductoInventario;
import kass.concurrente.modelo.persona.Chef;

/**
 * Clase Main
 * Aqui va toda tu simulacion
 * Genera un par de clientes para que los atienda el chef
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Main {    
    //Constante para generar los números aleatorios.
    private static final Random RANDOM = new Random();
    //Cantidad de clientes.
    private static Integer clientes;
    //Ganancias del día.
    private static Double ganancias = 0.0;
    //Lista de nombres de chefs.
    private static final String[] listaChefs = {"Arnaud Donckele", "Michel Troisgros", "Jonnie Boer", "Yannick Alleno", "Seiji Yamamoto"};
    //Lista de productos disponibles
    private static final String[] listaProductos = {"Huevo", "Jamon", "Queso", "Leche", "Sal",
                                                    "Harina", "Pollo", "Jitomate", "Lechuga", "Pimienta",
                                                    "Res", "Longaniza", "Chile", "Pescado", "Cebolla",
                                                    "Chicharo", "Zanahoria", "Pepino", "Aceite"};
    
    private static List<Platillo> platillos = new ArrayList<>();
    
    //Creación de una instancia del chef que atenderá los pedidos.
    private static Chef chef = new Chef(listaChefs[RANDOM.nextInt(listaChefs.length)], 45, new CuchilloNormal(), generaInventario());

    public static void main(String[] args) {
        System.out.println("Iniciando el servicio. El chef " + chef.getNombre() + " ha llegado.\n");
        clientes = RANDOM.nextInt(3)+2;
        creaPlatillos();
        System.out.println(clientes + " clientes en la fila.\n");
        System.out.println("Órdenes tomadas, se inicia la preparación de los platillos.\n");
        atiendePedidos();
    }

    
    private static HashMap<String, ProductoInventario> generaInventario(){
        HashMap<String, ProductoInventario> inventario = new HashMap<>();
        for(int i = 0; i < listaProductos.length; i++){
            inventario.put(listaProductos[i], new ProductoInventario(listaProductos[i], RANDOM.nextDouble(10)+1, RANDOM.nextInt(5)+1));
        }
        return inventario;
    }

    private static void atiendePedidos(){
        int contador = 1;
        List<Platillo> orden;
        while (clientes > 0) {
            System.out.println("-----------Atendiendo al cliente: " + contador + "------------");
            orden = generaPlatillos();
            for (Platillo p : orden){
                asignaCuchillo(RANDOM.nextInt(4)+1);
                preparaPlatillo(p);
                ganancias += p.getPrecio();
                System.out.println(p.getNombre() + " entregado.\n");
            }
            clientes --;
            contador ++;
        }
        System.out.println("Se atendieron a todos los clientes. El chef tomará un descanso \n");
        System.out.println("Ganancias acumuladas: " + ganancias);
    }

    private static void preparaPlatillo(Platillo platillo){
        System.out.println("Preparando " + platillo.getNombre());
        Integer tiempoTotal = platillo.getTiempoCoccion();
        for (Producto p : platillo.getProductosRequeridos()){
            if(verificaInventario(p.getNombre())){
                chef.setCantidadEspecifica(p.getNombre(), p.getPrecio(), -1);
            }else{
                System.out.println("El producto " + p.getNombre() + " está agotado, el chef fue a buscar más...\n");
                try{
                    Thread.sleep(5000);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
       }
        tiempoTotal -= chef.getCuchillo().corta();
        tiempoTotal = tiempoTotal * 1000;
        System.out.println("Cocinando ...\n");
        try{
            Thread.sleep(tiempoTotal);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private static List<Platillo> generaPlatillos(){
       List<Platillo> orden = new ArrayList<>();
       orden.add(platillos.get(RANDOM.nextInt(platillos.size())));
       orden.add(platillos.get(RANDOM.nextInt(platillos.size())));
       return orden;
    }

    private static void asignaCuchillo(Integer noCuchillo){
       switch (noCuchillo){
         case 1:
            System.out.println("El chef tiene el cuchillo normal. El tiempo no se reduce\n");
            chef.setCuchillo(new CuchilloNormal());
            break;
         case 2:
            System.out.println("El chef tiene el cuchillo de titanio. El tiempo se reduce 1 s.\n");
            chef.setCuchillo(new CuchilloTitanio(new CuchilloNormal()));
            break;
         case 3:
            System.out.println("El chef tiene el cuchillo de ceramica. El tiempo se reduce 2 s.\n");
            chef.setCuchillo(new CuchilloCeramica(new CuchilloNormal()));
            break;
         case 4:
            System.out.println("El chef tiene el cuchillo de diamante. El tiempo se reduce 3 s.\n");
            chef.setCuchillo(new CuchilloDiamante(new CuchilloNormal()));
            break;
         default:
            break;
       }
    }

    private static void creaPlatillos(){
       List<Producto> huevoCjamon = new ArrayList<>();
       huevoCjamon.add(new Producto("Huevo", 5.0));
       huevoCjamon.add(new Producto("Jamon", 10.0));
       huevoCjamon.add(new Producto("Aceite", 5.0));
       platillos.add(new Platillo(huevoCjamon, 50.0, 10, "Huevo con Jamón"));

       List<Producto> pescadoCVerdura = new ArrayList<>();
       pescadoCVerdura.add(new Producto("Pescado", 50.0));
       pescadoCVerdura.add(new Producto("Jitomate", 10.0));
       pescadoCVerdura.add(new Producto("Lechuga", 5.0));
       platillos.add(new Platillo(pescadoCVerdura, 100.0, 12, "Pescado con verdura"));

       List<Producto> resCVerduras = new ArrayList<>();
       resCVerduras.add(new Producto("Res", 40.0));
       resCVerduras.add(new Producto("Jitomate", 10.0));
       resCVerduras.add(new Producto("Lechuga", 5.0));
       resCVerduras.add(new Producto("Sal", 1.0));
       platillos.add(new Platillo(resCVerduras, 90.0, 10, "Res con verdura"));

       List<Producto> pastel = new ArrayList<>();
       pastel.add(new Producto("Huevo", 5.0));
       pastel.add(new Producto("Harina", 10.0));
       pastel.add(new Producto("Leche", 7.0));
       pastel.add(new Producto("Sal", 1.0));
       platillos.add(new Platillo(pastel, 70.0, 15, "Pastel"));

    }


    private static Boolean verificaInventario(String nombre){
        HashMap<String, ProductoInventario> inventario = chef.getInventario();
        return inventario.get(nombre).getCantidadDisponible() > 0;   
    }
}
