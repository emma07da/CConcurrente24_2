package kass.concurrente.modelo.cuchillo;


/**
 * Clase que modela un cuchillo de cerámica.
 * @author Emmanuel Delgado
 * @version 1.1
 */

public class CuchilloCeramica extends CuchilloDecorator{

    /**
     * Constructor que recibe un cuchillo para crear
     * un cuchillo base.
     * @param cuchillo El cuchillo que se recibe.
     */
    public CuchilloCeramica(Cuchillo cuchillo){
        super(cuchillo);
    }

    /**
     * Devuelve el tiempo que se reduce al usar este cuchillo
     * @return el tiempo que se reduce la cocción.
     */
    @Override
    public int corta(){
        return 2;
    }

    
}
