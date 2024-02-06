package kass.concurrente.modelo.cuchillo;


/**
 * Clase que modela un decorator de los cuchillos.
 * @author Emmanuel Delgado
 * @version 1.1
 */
public abstract class CuchilloDecorator implements Cuchillo {

    //Cuchillo
    private final Cuchillo cuchillo;

    /**
     * Constructor que recibe un cuchillo.
     * @param cuchillo El cuchillo que se recibe.
     */
    protected CuchilloDecorator(Cuchillo cuchillo) {
        this.cuchillo = cuchillo;
    }

    /**
     * Devuelve el tiempo del cuchillo creado.
     * @return el tiempo del cuchillo creado.
     */
    @Override
    public int corta() {
        return this.cuchillo.corta();
    }
}