package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto.
 * @author Kassandra Mirael
 * @author Emmanuel Delgado
 * @version 1.1
 */
public class Producto {

    //Nombre del producto.
    protected String nombre;
    //Precio del producto.
    protected Double precio;


    /**
     * Constructor por defecto.
     */
    public Producto(){
    }

    /**
     * Constructor que recibe el nombre y el precio para
     * crear un nuevo producto.
     * @param nombre El nombre del nuevo producto.
     * @param precio El nuevo precio del producto.
     */
    public Producto(String nombre, Double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Asigna un nuevo nombre al producto.
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Asigna un nuevo precio al producto.
     * @param precio El nuevo precio del producto
     */
    public void setPrecio(Double precio){
        this.precio = precio;
    }

    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public Double getPrecio(){
        return this.precio;
    }
}
