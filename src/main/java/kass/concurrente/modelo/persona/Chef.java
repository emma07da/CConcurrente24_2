package kass.concurrente.modelo.persona;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

public class Chef extends Persona{
     // Cuchillo que tiene disponible el chef.
    private Cuchillo cuchillo;
    // Inventario de productos disponibles en el inventario.
    private HashMap<String, ProductoInventario> inventario;

    /*
     * Constructor por defecto.
     */
    private Chef(){ }

    /*
     * Constructor que recibe nombre, edad y el cuchillo asignado
     * @param nombre El nombre del Chef.
     * @param edad La edad del Chef.
     * @param cuchillo El cuchillo del Chef.
     */
    private Chef(String nombre, Integer edad, Cuchillo cuchillo){
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
    private Chef(String nombre, Integer edad, Cuchillo cuchillo, HashMap<String, ProductoInventario> inventario){
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
    public Map<String, ProductoInventario> getInventario(){
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
             Random r = new Random();
             for (Producto p : inventario) {
                 this.inventario.put(p.getNombre(), new ProductoInventario(p, r.nextInt(5)+1));
             }
        }
    }

}
