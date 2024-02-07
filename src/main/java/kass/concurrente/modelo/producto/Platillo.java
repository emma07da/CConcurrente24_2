package kass.concurrente.modelo.producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela un platillo.
 * @author Kassandra Mirael
 * @author Emmanuel Delgado
 * @version 1.1
 */
public class Platillo {
    
    //nombre del platillo.
    protected String nombre;
    //Tiempo que tarda el chef en cocinarlo.
    protected Integer tiempoC;
    //Precio final calculado con los ingredientes.
    protected Double precio;
    //Lista de ingredientes que lo conforman.
    protected List<Producto> ingredientes;

    /**
     * Constructor por defecto.
     */
    public Platillo(){
        this.ingredientes = new ArrayList<>();
    }

    /**
     * Constructor que recibe nombre y tiempo de coccion del Platillo.
     * @param nombre el nombre del Platillo.
     * @param tiempo el tiempo del Platillo.
     */
    public Platillo(String nombre, Integer tiempo){
        this.nombre = nombre;
        this.tiempoC = tiempo;
        this.ingredientes = new ArrayList<>();
    }

    /**
     * Constructor que recibe el nombre, el tiempo de cocción y
     * la lista de ingredientes para crear un platillo y calcula el precio
     * de acuerdo al precio de los ingredientes.
     * @param nombre El nombre del nuevo platillo.
     * @param tiempoC El tiempo que tarda en cocinarse el platillo.
     * @param ingredientes Lista de productos que conforman el platillo.
     */
    public Platillo(List<Producto> ingredientes, Integer tiempoC, String nombre){
        this.nombre = nombre;
        this.tiempoC = tiempoC;
        this.ingredientes = ingredientes;
        this.precio = calculaPrecio();
    }

    /**
     * Constructor que recibe el nombre, el tiempo de cocción y
     * la lista de ingredientes para crear un platillo.
     * @param nombre El nombre del nuevo platillo.
     * @param tiempoC El tiempo que tarda en cocinarse el platillo.
     * @param precio El precio base del platillo.
     * @param ingredientes Lista de productos que conforman el platillo.
     */
    public Platillo(List<Producto> ingredientes, Double precio, Integer tiempoC, String nombre ){
        this.nombre = nombre;
        this.tiempoC = tiempoC;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    /**
     * Obtiene el nombre del platillo.
     * @return El nombre del platillo.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Asigna un nuevo nombre al platillo.
     * @param nombre El nuevo nombre del platillo.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Obtiene el tiempo de cocción del platillo.
     * @return El tiempo de cocción del platillo.
     */
    public Integer getTiempoCoccion(){
        return this.tiempoC;
    }

    /**
     * Asigna un nuevo tiempo de cocción al platillo.
     * @param tiempoC El nuevo tiempo de cocción del platillo.
     */
    public void setTiempoC(Integer tiempoC){
        this.tiempoC = tiempoC;
    }

    /**
     * Obtiene el precio del platillo.
     * @return El precio del platillo.
     */
    public Double getPrecio(){
        return this.precio;
    }

    /**
     * Asigna un nuevo precio al platillo.
     * @param precio El nuevo precio del platillo.  
     */
    public void setPrecio(Double precio){
        this.precio = precio;
    }

    /**
     * Obtiene los ingredientes del platillo.
     * @return Los ingredientes del platillo.
     */
    public List<Producto> getProductosRequeridos(){
        return this.ingredientes;
    }

    /**
     * Asigna una nueva lista de ingredientes al platillo.
     * @param ingredientes La nueva lista de ingredientes.
     */
    public void setProductosRequeridos(List<Producto> ingredientes){
        this.ingredientes = ingredientes;
    }

    /**
     * Este metodo calcula el precio sobre el precio de los items, se ignora
     * el precio base.
     * @return El precio de la suma de cada item utilizado
     */
    public Double calculaPrecio(){
        Double precioPlatillo = 0.0;
        if (this.ingredientes == null){
            return precio;
        }else{
            for (Producto producto : this.ingredientes ) {
                precioPlatillo += producto.getPrecio();
            }
            return precioPlatillo;
        }
        
    }
    
}
