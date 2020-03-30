//Paquete en el que se esta trabajando
package Datos;

import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {

        // Fundamentos de programación
        Leer primero = new Leer("https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/laboratorios/lab03/datasets/NOTAS%20ST0242.csv");

        // Estructura de Datos 1
        Leer segundo = new Leer("https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/laboratorios/lab03/datasets/NOTAS%20ST0245.csv");

        // Estructura de Datos 2
        Leer tercero = new Leer("https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/laboratorios/lab03/datasets/NOTAS%20ST0247.csv");

        // crear arreyList cursos para insertar los cursos
        ArrayList<Leer> Cursos = new ArrayList<>();

        // insertar los curso
        Cursos.add(primero); // Fundamentos de programación
        Cursos.add(segundo); // Estructura de Datos 1
        Cursos.add(tercero); // Estructura de Datos 2

        // Cargar datos
        for (Leer curso : Cursos) { curso.LeerArchivo(); }

        //Scanner
        Scanner esc = new Scanner(System.in);

        // Que quiere hacer
        System.out.println("(Ingresar numero) Desea buscar: ");
        System.out.println("1. Buscar Total de estudiante de un curso por semestre");
        System.out.println("2. Buscar nota de un estudiante en un curso especifico");

        // que hacer
        String que = esc.nextLine();

        // Para no distinguir entre mayusculas, minusculas y letras con acentos.
        Collator comparador = Collator.getInstance();
        comparador.setStrength(Collator.PRIMARY);

        // Opción primera
        if(que.equals("1")){

            // cual curso buscar
            System.out.println("Ingrese el curso: ");
            System.out.println("Fundamentos de programación");
            System.out.println("Estructura de Datos 1");
            System.out.println("Estructura de Datos 2");
            que = esc.nextLine();
            System.out.println("Ingrese el semestre: ");
            String tem = esc.nextLine();

            // si es fundamentos
            if(comparador.equals(que, "Fundamentos de programación")){

                for(int i = 0 ; i < Cursos.get(0).getCurso(); i++){

                    if (Cursos.get(0).getSemEs(i).equals(tem)){ System.out.println("Nombre: " + Cursos.get(0).getNomEs(i) + " Nota final: " + Cursos.get(0).getNotFinEs(i)); }
                }
            // si es estructuras 1
            }else if (comparador.equals(que, "Estructura de datos 1")){

                for(int i = 0 ; i < Cursos.get(1).getCurso(); i++){

                    if (Cursos.get(1).getSemEs(i).equals(tem)){ System.out.println("Nombre: " + Cursos.get(1).getNomEs(i) + " Nota final: " + Cursos.get(1).getNotFinEs(i)); }
                }
            // si es estructuras 2
            }else if(comparador.equals(que, "Estructura de datos 2")){

                for(int i = 0 ; i < Cursos.get(2).getCurso(); i++){

                    if (Cursos.get(2).getSemEs(i).equals(tem)){ System.out.println("Nombre: " + Cursos.get(2).getNomEs(i) + " Nota final: " + Cursos.get(2).getNotFinEs(i)); }
                }
            // Si no se cumple ninguna
            }else { System.out.println("Opcion no valida"); }

        // si es la opción dos
        }else if(que.equals("2")){

            // Seleccionar nombre del estudiante
            System.out.println("Escribir el nombre del estudiante:");
            que = esc.nextLine();

            // seleccionar el semestre
            System.out.println("Escriba el semestre: ");
            String tem = esc.nextLine();

            if(Integer.parseInt(tem) >= 20142 && Integer.parseInt(tem) <= 20152 ) {
                // Buscar el estudiante y el semestre en todos los cursos
                for (int i = 0; i < Cursos.get(0).getCurso(); i++) {
                    if (Cursos.get(0).getNomEs(i).equals(que) && Cursos.get(0).getSemEs(i).equals(tem)) {
                        System.out.println("En Fundamentos de programación " + " su nota fue: " + Cursos.get(0).getNotFinEs(i));
                    }if(i==Cursos.get(0).getCurso()-1){
                        System.out.println("El estudiante no cursó Fundamentos de programación en el semestre " + tem);
                    }
                }

                for (int i = 0; i < Cursos.get(1).getCurso(); i++) {
                    if (Cursos.get(1).getNomEs(i).equals(que) && Cursos.get(1).getSemEs(i).equals(tem)) {
                        System.out.println("En Estructura de datos 1 " + " su nota fue: " + Cursos.get(1).getNotFinEs(i));
                    }else if(i==Cursos.get(1).getCurso()-1){
                        System.out.println("El estudiante no cursó Estructura de datos 1 en el semestre " + tem);
                    }
                }

                for (int i = 0; i < Cursos.get(2).getCurso(); i++) {
                    if (Cursos.get(2).getNomEs(i).equals(que) && Cursos.get(2).getSemEs(i).equals(tem)) {
                        System.out.println("En Estructura de datos 2 " + " su nota fue: " + Cursos.get(2).getNotFinEs(i));
                    }else if(i==Cursos.get(2).getCurso()-1){
                        System.out.println("El estudiante no cursó Estructura de datos 2 en el semestre " + tem);
                    }
                }
            }else{
                System.out.println("El Semestre no es valido");
            }

        // si ninguna de las opciones está
        } else { System.out.println("Opcion Invalida"); }
    }
}
