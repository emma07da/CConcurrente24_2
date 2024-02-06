package kass.concurrente.modelo.persona;

/**
 * Clase que modela una persona
 * @author Kassandra Mirael
 * @author Emmanuel Delgado
 * @version 1.1
 */
public class Persona {

     // Nombre.
    protected String nombre;
    // Edad.
    protected Integer edad; 

     /**
     * Constructor por defecto.
     */
    public Persona(){ }
    
    /**
     * Constructor que recibe el nombre y la edad
     * de la nueva persona.
     * @param nombre El nombre de la nueva persona.
     * @param edad La edad de la nueva persona.
     */
    public Persona(String nombre, Integer edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Obtiene el nombre de la Persona.
     * @return El nombre de la Persona.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Asigna un nuevo nombre a la Persona.
     * @param nombre El nuevo nombre de la Persona.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad de la Persona.
     * @return La edad de la Persona.
     */
    public Integer getEdad(){
        return this.edad;
    }

    /**
     * Asigna la nueva edad de la Persona.
     * @param edad La nueva edad de la Persona.
     */
    public void setEdad(Integer edad){
        this.edad = edad;
    }
}
