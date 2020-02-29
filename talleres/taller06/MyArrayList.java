package Taller6;
import java.util.Arrays;

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public MiArrayLis() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }     

    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size(){
        return size;
    }   

    private void agrandarlo(){
      int[] nuevo = elements.length*2;
      for (int i = 0; i < elements.length; i++)
        nuevo[i] = elements[i];
      elements = nuevo;
    }

    private void remover(int e){
      int[]nuevo = new int[size-1];
      for(int i = e; i < size; e++ ){
        int aux = elements[e];
        int aux1 = elements[e+1];
        elements[e] = aux1;
        elements[e+1] = aux;
      }

      for (int i = 0; i < size-1; i++)
        nuevo[i] = elements[i];
      elements = nuevo;
      size --;
    }
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(int e) {
        if(size == elements.length)
          agarndarlo();
      elements[size] = e;
      size ++;
    }    
    
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public int get(int i) throws Exception {
       if (i >= size || i < 0) // C1 es O(1)
         throw new Exception("Index out of bounds exception index = "+i); // C2 es O(1)
       else
        return elements[i]; // C3 es O(1)
       // T(n) = O(1) + O(1) = O(1)
    }
    
    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add (int index, int e) throws Exception {
      if(index >= size)
        throw new Exception("Index out of bounds exception index = "+i);
      else
        elemnts[index] = e;
    } 

    /**
    * @param index es la posicion en la cual se va eliminar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index){
        if(index == size){
          elements[index] = null;
        }else{
          remover(index);
        }
    size --;
    }   
}
