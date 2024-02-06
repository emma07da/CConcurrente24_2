package kass.concurrente.modelo.cuchillo;

/**
 * Clase que modela un cuchillo de titanio.
 * @author Emmanuel Delgado
 * @version 1.1
 */

public class CuchilloTitanio extends CuchilloDecorator{

     /**
     * Constructor que recibe un cuchillo para crear
     * un cuchillo base.
     * @param cuchillo El cuchillo que se recibe.
     */
    public CuchilloTitanio(Cuchillo cuchillo){
        super(cuchillo);
    }

    /**
     * Devuelve el tiempo que se reduce al usar este cuchillo
     * @return el tiempo que se reduce la cocción.
     */
    @Override
    public int corta(){
        System.out.print("El chef está usando el cuchillo de Titanio,  el tiempo se reduce 1 s.");
        return 1;
    }

    
}