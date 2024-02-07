package kass.concurrente.modelo.persona;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kass.concurrente.modelo.cuchillo.Cuchillo;
import kass.concurrente.modelo.producto.Platillo;
import kass.concurrente.modelo.producto.Producto;
import kass.concurrente.modelo.producto.ProductoInventario;

/**
 * Clase que modela un chef
 * @author Kassandra Mirael
 * @author Emmanuel Delgado
 * @version 2.0
 */

public class Chef extends Persona{
    // Cuchillo que tiene disponible el chef.
    private Cuchillo cuchillo;
    // Inventario de productos disponibles en el inventario.
    private HashMap<String, ProductoInventario> inventario;
    //Constante para generar los números aleatorios.
    private static final Random RANDOM = new Random();


    /*
     * Constructor por defecto.
     */
    public Chef(){ }

    /*
     * Constructor que recibe nombre, edad y el cuchillo asignado
     * @param nombre El nombre del Chef.
     * @param edad La edad del Chef.
     * @param cuchillo El cuchillo del Chef.
     */
    public Chef(String nombre, Integer edad, Cuchillo cuchillo){
        super(nombre, edad);
        this.cuchillo = cuchillo;
        this.inventario = new HashMap<>();
    }

    /*
     * Constructor que recibe nombre, edad, el cuchillo asignado
     * y los productos disponibles en el inventario.
     * @param nombre El nombre del Chef.
     * @param edad La edad del Chef.
     * @param cuchillo El cuchillo del Chef.
     * @param productos El inventario disponible.
     */
    public Chef(String nombre, Integer edad, Cuchillo cuchillo, HashMap<String, ProductoInventario> inventario){
        super(nombre, edad);
        this.cuchillo = cuchillo;
        this.inventario = inventario;
    }

    /**
     * Obtiene el cuchillo en uso del Chef.
     * @return el cuchillo en uso del Chef.
     */
    public Cuchillo getCuchillo(){
        return this.cuchillo;
    }

    /**
     * Asigna un nuevo cuchillo al Chef.
     * @param cuchillo el nuevo cuchillo asignado al Chef.
     */
    public void setCuchillo(Cuchillo cuchillo){
        this.cuchillo = cuchillo;
    }

    /**
     * Obtiene el inventario del chef.
     * @return el inventario del chef.
     */
    public HashMap<String, ProductoInventario> getInventario(){
        return this.inventario;
    }

    /**
     * Asigna un nuevo inventario al chef
     * @param productos el nuevo inventario del chef.
     */
    public void setInventario(List<Producto> inventario){
        if (inventario == null){
            this.inventario = new HashMap<>();
        } else{
             for (Producto p : inventario) {
                 this.inventario.put(p.getNombre(), new ProductoInventario(p.getNombre(), p.getPrecio(), RANDOM.nextInt(5)+1));
             }
        }
    }

    /**
     * Asigna una nueva cantidad disponible a un producto en especifico.
     * @param nombre el nombre del producto.
     * @param cantidadDisponible la nueva cantidad.
     */
    public void setCantidadEspecifica(String nombre, Double precio, Integer cantidadDisponible){
        ProductoInventario p = this.inventario.get(nombre);
        this.inventario.put(nombre, new ProductoInventario(nombre, precio, p.getCantidadDisponible() + cantidadDisponible));
    }


}
