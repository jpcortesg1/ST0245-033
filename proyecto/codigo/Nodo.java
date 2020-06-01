import java.util.ArrayList;

public class Nodo {
    private Nodo derecha;
    private Nodo izquierda;
    private ArrayList<Estudiante> datos;

    public Nodo(Nodo derecha, Nodo izquierda, ArrayList<Estudiante> datos) {
        this.derecha = derecha;
        this.izquierda = izquierda;
        this.datos = datos;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    public ArrayList<Estudiante> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Estudiante> datos) {
        this.datos = datos;
    }
}
