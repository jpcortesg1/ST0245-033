public class Taller5 {  
  	//suma array
  public static int suma (int[]array){
    int suma = 0;

    for(int i = 0; i < array.length; i++){
      suma = suma + array[i];
    }
    return suma;
  }

  public static void mul (int num){
    for (int i = 0; i <= num; i++){
      for (int j = 0; j <= 10; j++){
        System.out.print( i + " * " + j + " = " + i*j + " || ");
      }
      System.out.println("");
    }
  }

  /**
    * @param array es un arreglo de números desordenados
    * El método insertionSort tiene la intención ordenar los números
    * del arreglo array por el método insertion:
    * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
    * mediante la anidación de funciones cíclicas (while/for/...)
    * 
    */
  public static int[] insertionSort(int[] array){
      
    int aux = 0;
    int cont1 = 0;
    int cont2 = 0;

    for(cont1 = 0; cont1 < array.length; cont1 ++){

      aux = array[cont1];

      for(cont2 = cont1-1; cont2 >= 0 && array[cont2] >= aux; cont2--){

        array[cont2+1] = array[cont2];
        array [cont2] = aux;

      }

    }
    
    for (int i = 0; i < array.length ; i++){

      System.out.print(" "+array[i]);

    }
    System.out.println("");
    return array;
  }  
}