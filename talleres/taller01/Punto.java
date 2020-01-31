package Taller1;

/**
 * La clase Punto tiene la intenci�n de representar coordenadas en el espacio y calcular su distancia.
 * 
* @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class Punto {

    private double x, y;

    /**
     * Se inicializan los atributos de clase
     */
    public Punto(double x, double y) {
    	this.x = x;
    	this.y = y;
    }

    /**
     * M�todo para obtener la variable global x.
     *
     * @return eje coordenado x
     */
    public double x() {
    	return this.x;
    }

    /**
     * M�todo para obtener la variable global y.
     *
     * @return eje coordenado y
     */
    public double y() {
    	return this.y;
    }

    /**
     * M�todo para obtener el radio polar, en este caso se puede obtener por medio del teorema de pit�goras.
     * 
     *
     * @return radio polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver m�s <a/>
     */
    
    public double radioPolar() {
    	return Math.sqrt((x * x) + (y * y));
    }


    /**
     * M�todo para obtener el �ngulo polar, en este caso se puede obtener por medio de la tangente inversa.
     * 
     *
     * @return angulo polar
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> Ver m�s <a/>
     */
    public double anguloPolar() {
    	return Math.tan(y / x);
    }
    
    /**
     * M�todo para obtener la distacia euclidiana. La distacia
     * euclidiana o eucl�dea es la distancia "ordinaria" (que se medir�a con una regla) entre 
     * dos puntos de un espacio eucl�deo, la cual se deduce a partir del teorema de Pit�goras.
     * En otras palabras es halla el radio polar a la diferencia entre los dos puntos.
     *
     *
     *
     * @return distancia euclidiana (radio polar a la diferencia de dos puntos)
     *
     * @param otro Este par�metro hace referencia a otro Punto en el espacio con es cual se desea
     * comparar el Punto desde el cual fue llamado.
     * @see <a href="http://mathworld.wolfram.com/Distance.html"> Ver m�s <a/>
     */
  
    public double distanciaEuclidiana(Punto otro) {
    	double dx = this.x - otro.x();
        double dy = this.y - otro.y();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
