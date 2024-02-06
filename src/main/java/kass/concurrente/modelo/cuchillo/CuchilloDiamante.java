package kass.concurrente.modelo.cuchillo;


/**
 * Clase que modela un cuchillo de Diamante.
 * @author Emmanuel Delgado
 * @version 1.1
 */

public class CuchilloDiamante extends CuchilloDecorator{

     /**
     * Constructor que recibe un cuchillo para crear
     * un cuchillo base.
     * @param cuchillo El cuchillo que se recibe.
     */
    public CuchilloDiamante(Cuchillo cuchillo){
        super(cuchillo);
    }

    /**
     * Devuelve el tiempo que se reduce al usar este cuchillo
     * @return el tiempo que se reduce la cocción.
     */
    @Override
    public int corta(){
        System.out.print("El chef está usando el cuchillo de Diamante, el tiempo se reduce 3 s.");
        return 3;
    }

    
}