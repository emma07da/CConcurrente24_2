package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto de un inventario
 * @author Kassandra Mirael
 * @author Emmanuel Delgado
 * @version 1.1
 */
public class ProductoInventario extends Producto{
    
    //Cantidad en stock del producto.
    protected Integer cantidadDisponible;
    
    /**
     * Constructor por defecto.
     */
    public ProductoInventario(){
    }

    /**
     * Constructor que recibe el nombre,precio y la cantidad disponible
     * del producto.
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @param cantidadDisponible La cantidad disponible del producto.
     */
    public ProductoInventario(String nombre, Double precio, Integer cantidadDisponible){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }

     /**
     * Obtiene la cantidad disponible del producto.
     * @return La cantidad disponible del producto.
     */
    public Integer getCantidadDisponible(){
        return this.cantidadDisponible;
    }

    /**
     * Asigna una nueva cantidad disponible del producto.
     * @param cantidadDisponible La nueva cantidad.
     */
    public void setCantidadDisponible(Integer cantidadDisponible){
        this.cantidadDisponible = cantidadDisponible;
    }
}
