package Taller1;

/**
 * La clase Contador tiene la intenci�n de representar un contador.
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class Contador {
    
	private int cuenta;
	private final String id;


	/**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     */
    public Contador(String id) {
    	this.id = id;
    	cuenta = 0;
    }

    /**
     * El m�todo incrementar incrementa el contador en una unidad.
     *
     *(opcional: se podria pasar un parametro "cantidad" para incrementar esa cantidad de unidades).
     */
    public void incrementar() {
    	cuenta++;
    }

    /*
    Se podr�a implementar un metodo decrementar para hacer la operacion inversa de incrementar.
    */

    /**
     * El m�todo incrementos nos muestra en que valor se encuentra la cuenta actualmente.
     * @return el numero actual de la cuenta
     */
    public int incrementos() {
    	return cuenta;
    }

    
     /**
    * toString se encargar� de convertir el contador en un tipo cadena
    * para su posterior visualizaci�n
    * se debe de mostrar el estado del contador y su id
    *
    * @return una cadena que contiene el id del contador y su cuenta
    */
    public String toString() {
    	return id;
    }
}
