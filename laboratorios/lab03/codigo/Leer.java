// Paquete en el que se esta trabajando
package Datos;

// fuente : https://stackoverflow.com/questions/44439172/reading-csv-file-from-url-in-java/48130273

// importar lo necesario
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Leer {

    // variable para la url
    private String urlP;
    private ArrayList<Estudiante> Curso;

    // constructor
    public Leer(String url) {
        this.urlP = url;
        this.Curso = new ArrayList<>();
    }

    public void LeerArchivo() throws IOException {

        // se leer la URL
        URL url = new URL(urlP);

        // para asegurar conexion
        URLConnection con = url.openConnection();

        // puente de secuencia bytes a secuencia de caracteres
        InputStreamReader csv = new InputStreamReader(con.getInputStream());

        // Lee texto
        BufferedReader lee = new BufferedReader(csv);

        // Para separar el texto
        String linea;
        String pSpl = ",";

        // para no repeticiones
        String ant = "";

        // guardar información
        while ((linea = lee.readLine()) != null){

            // guardar en un array para luego asignar los valores por separado
            String[] val = linea.split(pSpl);

            // filtro para solo separar las lineas necesarias
            if(val.length > 1 && (!ant.equals(val[0]))) {
                Estudiante nuevo = new Estudiante(val[0], val[3], val[13]);
                Curso.add(nuevo);
                ant = val[0];
            }
        }

    }

    public int getCurso() { return Curso.size(); }

    public String getNomEs(int a){ return this.Curso.get(a).getNom(); }

    public String getSemEs(int a) { return this.Curso.get(a).getSem(); }

    public String getNotFinEs(int a) { return this.Curso.get(a).getNotFin(); }
}
