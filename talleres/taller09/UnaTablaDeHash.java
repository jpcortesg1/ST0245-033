import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * La clase UnaTablaDeHash, es un plantilla para crear nuestra propia estructura
 * hash Dentro de sus características esta que tiene un string como llave (key)
 * y un entero como valor (value)
 *
 * @author Mauricio Toro, Andres Paez, Daniel Mesa
 * @version 2
 */
// Nota: Hacen falta algunas partes de las lineas de codigo, estas estan
// indicadas con una linea, ¡debes completarlas! ademas esta estructura no
// maneja
// colisiones, puedes guiarte de ella para diseñar la tuya ¡Pero sin problemas!
public class UnaTablaDeHash {
    /*
     * Utilizamos array por simplicidad sin embargo el uso de este no permite
     * manejar coliciones de manera eficiente, por lo cual esta primera versión de
     * hash no implementa colisiones, esta característica se implementará
     * posteriormente.
     */
    // Ojo, esta tabla definida así no permite manejar las colisiones
    private ArrayList<ArrayList<Pareja>> tabla;

   /**
   * Este método define el array utilizado con 10 posiciones de manera que tenemos un límite de 10 elementos
   *
   */
   public UnaTablaDeHash(){
    tabla = new ArrayList<>(11);
    for (int i = 0; i < 10; i++) {
        tabla.add(null);
    }
   }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar Este
     *          método se utiliza para darle una posicion dentro de la tabla, donde
     *          el %10 asegura que solo se utilicen digitos de 0 a 10.
     */
    private int funcionHash(String k) {
        return ((int) k.charAt(0)) % 10;
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar Este
     *          método se utiliza para obtener el elmento con la clave k, se enlaza
     *          con funcionHash
     */
    public int get(String k) {
        return tabla.get(k.funcionHash()).stream().filter(p -> p.name.equals(k)).collect(Collectors.toList())
                .get(0).dato;

    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     *          posteriormente
     * @param v es el valor asociado a la llave k Este método se utiliza para
     *          agregar un nuevo elemento
     */
    public void put(String k, int v) {
        Pareja nueva = new Pareja(k, v);
        tabla.get(k).add(nueva);

    }
}

class Pareja {

    String name;
    int dato;

    public Pareja(String name, int dato) {
        this.name = name;
        this.dato = dato;
    }
}
