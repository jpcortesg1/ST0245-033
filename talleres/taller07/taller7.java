import java.lang.IndexOutOfBoundsException;

public class LinkedListMauricio{

  public class Node{
    public char val; 
    public Node elProximoNodoEsLoQueSe;
    public Node(char v) { val = v;}
  }
  
  private Node first;
  private int size;
  public LinkedListMauricio(){
    size = 0;
    first = null;	
  

    /**
    * Returns the node at the specified position in this list.
    * @param index - index of the node to return
    * @return the node at the specified position in this list
    * @throws IndexOutOfBoundsException
    */
    private Node getNode(int index) throws IndexOutOfBoundsException {
      if (index >= 0 && index < size) {
        Node temp = first;
        for (int i = 0; i < index; i++) {
          temp = temp.elProximoNodoEsLoQueSe;
        }
        return temp;
      } else {
        throw new IndexOutOfBoundsException();
      }
    }

    /**
    * Returns the element at the specified position in this list.
    * @param index - index of the element to return
    * @return the element at the specified position in this list
          * @throws IndexOutOfBoundsException
    */
    public int get(int index) throws IndexOutOfBoundsException {
      Node temp = getNode(index);
      return temp.val;
    }

  // Retorna el tamaño actual de la lista
  public int size()
  {
    return size;
  }

  // Insertar al inicio
  public void inserI(int data){
    Node nodo = new Node(data);
    if(first == null) first = nodo;
    else{
      nodo.elProximoNodoEsLoQueSe = first;
      first = nodo;
      size ++;
    }
  }

  // Insertar un dato en alguna posicion

  public void insert(int data, int pos){
    Node nodo = new Node(data);

    if(first == null) first = nodo;
    else{
      Node elNodo = first;
      int contador = 0;

      while(contador < pos && elNodo != null){
        elNodo = elNodo.elProximoNodoEsLoQueSe;
        contador ++;
      }

      nodo.elProximoNodoEsLoQueSe = elNodo.elProximoNodoEsLoQueSe;
      elNodo.elProximoNodoEsLoQueSe = nodo;
      size ++;
    }
  }

  // Inserta un dato al final
  public void insertF(int data)
  {
    Node nodo = new Node(data);
    if(first == null) first = nodo;
    else{
      Node elNodo = first;

      while(elNodo != null){
        elNodo = elNodo.elProximoNodoEsLoQueSe;
      }
      elNodo.elProximoNodoEsLoQueSe = nodo;
    }
    size ++;
  }

  // Borrar primer posicion 
  public void removeI(){
    if(first != null){
      Node elNodo = cabeza;
      cabeza = cabeza.elProximoNodoEsLoQueSe;
      elNodo.elProximoNodoEsLoQueSe = null;
      longitud --;
    }
  }

  // Borra el dato en la posición index
  public void remove(int index)
  {
    if(first != null){
      if(index == 0){
        Node elNodo = cabeza;
        cabeza = cabeza.elProximoNodoEsLoQueSe;
        elNodo.elProximoNodoEsLoQueSe = null;
        longitud --;
      }else if(n < size){
        Node elNodo = first;
        int contador = 0;

        while(contador < (index-1)){
          elNodo = elNodo.elProximoNodoEsLoQueSe;
          contador ++;
        }
        Node temp = elNodo.elProximoNodoEsLoQueSe;
        elNodo.elProximoNodoEsLoQueSe = temp.elProximoNodoEsLoQueSe;
        temp.elProximoNodoEsLoQueSe = null;
        size --;
      }
    }
  }

  // Borrar el dato del final
  public void removeF(){
    if(first != null){
      if(first.elProximoNodoEsLoQueSe == null) first = null;
      else{
        Node elNodo = first;
        while (elNodo.elProximoNodoEsLoQueSe.elProximoNodoEsLoQueSe != null){
          elNodo = elNodo.elProximoNodoEsLoQueSe;
        }
        elNodo.elProximoNodoEsLoQueSe = null;
        longitud --;
      }
    }
  }

  private boolean containsR(Node elNodo, char data){
   if (elNodo == null) return false;
   if (elNodo.val == data) return true;
   return containsR(elNodo.elProximoNodoEsLoQueSe, data);
  }

  public boolean containsR(char data){
    return containsR(first, data);
  }
  }
}
