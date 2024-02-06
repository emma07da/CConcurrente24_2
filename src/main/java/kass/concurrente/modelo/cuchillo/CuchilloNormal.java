package kass.concurrente.modelo.cuchillo;

/**
 * Clase que modela un cuchillo básico que no disminuye el tiempo
 * de cocción.
 * @author Emmanuel Delgado
 * @version 1.1
 */
public class CuchilloNormal implements Cuchillo{

     /**
     * Devuelve el tiempo que se reduce al usar este cuchillo
     * @return el tiempo que se reduce la cocción.
     */
    @Override
    public int corta(){
        return 0;
    }
}
