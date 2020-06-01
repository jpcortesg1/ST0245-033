/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.TreeSet;
import javafx.util.Pair;

/**
 *
 * @author julianrojasgallego
 */
public class Arbol {

    private static Nodo raiz;

    private static boolean [] datosUsados = new boolean[77];

    // Crear la Raiz
    public Nodo crearNodo(ArrayList<Estudiante> m){
        if(m.size() == 0) return null;
        Pair<Integer,String> mejorVariable = mejorVariable(m);
        Pair<ArrayList<Estudiante>,ArrayList<Estudiante>> dividos = dividirEnDos(m, mejorVariable.getKey(), mejorVariable.getValue());
        if (datoUsado(datosUsados)) {
            return null;
        }if (parar(dividos.getKey(), dividos.getValue())){
            if(dividos.getValue().get(0).getVaribles().get(77).equals("1")) return new Nodo (null, null, dividos.getValue());
            return new Nodo (null, null, dividos.getKey());
        }
        else{
            Nodo nodoIzquierdo = crearNodo(dividos.getKey());
            Nodo nodoDerecho = crearNodo(dividos.getValue());

            datosUsados[mejorVariable.getKey()] = true;

            return new Nodo(nodoDerecho, nodoIzquierdo, m);
        }
    }

    public Nodo recArbol(Nodo cual){
        ArrayList<String> exito = new ArrayList<>();
        if (cual.getIzquierda() != null) recArbol(cual.getIzquierda());
        if (cual.getDerecha() != null) recArbol(cual.getDerecha());

        if (cual.getDerecha() == null && cual.getIzquierda() == null){
            return  cual;
        }
        return null;
    }

    public boolean parar(ArrayList<Estudiante> m, ArrayList<Estudiante> p){
        if(datoUsado(recorrer(m)) && datoUsadoNegativo(recorrer(p))){
            return true;
        }if(datoUsado(recorrer(p)) && datoUsadoNegativo(recorrer(m))){
            return true;
        }
        return false;
    }

    public boolean [] recorrer(ArrayList<Estudiante> m){
        boolean [] julian = new boolean[m.size()] ;
        for (int i = 0; i < m.size(); i++){
            if(m.get(i).getVaribles().get(77).equals("1")){
                julian[i] = true;
            }else{
                julian[i] = false;
            }
        }

        return  julian;
    }


    public static boolean datoUsado (boolean[] datosUsados) {
        for (int i = 0; i < datosUsados.length; i++)
            if (!datosUsados[i])
                return false;
        return true;
    }

    public static boolean datoUsadoNegativo (boolean[] datosUsados) {
        for (int i = 0; i < datosUsados.length; i++)
            if (datosUsados[i])
                return false;
        return true;
    }

    // Metodo Para obtener los valores de una variable
    public static TreeSet<String> valoresVariable(ArrayList<Estudiante> m, int data){
        TreeSet<String> alternatives = new TreeSet();
        for (Estudiante estudiante : m) alternatives.add(estudiante.getVaribles().get(data));
        return alternatives;
    }

    // Metodo para saber cuantos estudiantes tienen un valor en una variable variable
    public static int numAlter (ArrayList<Estudiante> m, int data, String val) {
        int numInstances = 0;
        for (Estudiante estudiante : m)
            if (estudiante.getVaribles().get(data).equals(val))
                numInstances++;
        return numInstances;
    }

    // Metodo Para dividir un ArrayList en dos ArrayList
    public static Pair<ArrayList<Estudiante>, ArrayList<Estudiante>> dividirEnDos (ArrayList<Estudiante> m, int data, String alt) {
        int numAlter = numAlter(m, data, alt);
        ArrayList<Estudiante> matrizLaVariableEsIgualAlValor = new ArrayList<>(numAlter);
        ArrayList<Estudiante> matrizLaVariableNOEsIgualAlValor = new ArrayList<>(m.size() - numAlter);
        int success = 0, noSuccess = 0;
        for (int i = 1; i < m.size(); i++) {
            if (m.get(i).getVaribles().get(data).equals(alt)) {
                matrizLaVariableEsIgualAlValor.add(m.get(i));
                success++;
            } else {
                matrizLaVariableNOEsIgualAlValor.add(m.get(i));
                noSuccess++;
            }
        }
        return new Pair<ArrayList<Estudiante>,ArrayList<Estudiante>>(matrizLaVariableEsIgualAlValor,matrizLaVariableNOEsIgualAlValor);
    }

    // Calcular gini
    public static double giniIndex (ArrayList<Estudiante> m) {
        double losQueSi = numAlter(m, 77, "1");
        if (m.size() != 0) {
            double losQueNo = m.size() - losQueSi - 1;
            double res = Math.pow(losQueNo / m.size() - 1, 2) + Math.pow(losQueSi / m.size() - 1, 2);

            // System.out.println("tamaño: " + m.size() + "exito: " +  losQueSi + " no: " + losQueNo + " res:" + res);

            return 1 - Math.pow(losQueNo / m.size() - 1, 2) - Math.pow(losQueSi / m.size() - 1, 2);
        }
        return 1;
    }

    // Calcular gini index de un valor de una variable
    public static double giniIndexData (ArrayList<Estudiante> m, int data,  String val){
        Pair<ArrayList<Estudiante>, ArrayList<Estudiante>> pair = dividirEnDos(m, data, val);
        double igual = giniIndex(pair.getKey());
        double diferente = giniIndex(pair.getValue());

        return                   Math.abs((igual*pair.getKey().size()) + (diferente*pair.getValue().size())) / (pair.getKey().size() + pair.getValue().size());
    }

    // Mejor variable
    public Pair<Integer,String> mejorVariable(ArrayList<Estudiante> m){
        double minGini = 1;
        String val = "";
        int dato = -1;
        for (int i = 1; i < m.get(0).getVaribles().size() - 1; i++) {
            // Este "for" me recorre todas las alternativas de la variable que este analizando.
            for (String altTemp : valoresVariable(m, i)) {
                //Esta l?nea me calcula el gini index de esa variable con esa alternativa de los dos "for" anteriores.
                double giniTemp = giniIndexData(m, i, altTemp);
                if (giniTemp < minGini) {
                    val = altTemp;
                    minGini = giniTemp;
                    dato = i;
                }
            }
        }
        System.out.println(minGini);
        Pair<Integer,String> respuesta = new Pair(dato, val);
        return respuesta;
    }







    public double laImpurezaDeLosDatosDeUnaMatriz(ArrayList<Estudiante> m){
        double losQueTienenExito = 0;
        double losQueNoTienenExito = 0;
        for (int fila = 1; fila < m.size() ; fila++){
            if (m.get(fila).getVaribles().get(m.get(fila).getVaribles().size()-1).equalsIgnoreCase("1")){
                losQueTienenExito++;
            }
            if (m.get(fila).getVaribles().get(m.get(fila).getVaribles().size() - 1).equalsIgnoreCase("0")) {
                losQueNoTienenExito++;
            }
        }

        return 1 - Math.pow(losQueNoTienenExito / m.size() - 1, 2) - Math.pow(losQueTienenExito / m.size() - 1, 2);
    }



    public  Pair<ArrayList<Estudiante>,ArrayList<Estudiante>> dividirUnaMatrizEnDosMatrices(ArrayList<Estudiante> m, int posVariable, String valor){
        ArrayList<Estudiante> matrizLaVariableEsIgualAlValor = new ArrayList<>();
        ArrayList<Estudiante> matrizLaVariableNOEsIgualAlValor = new ArrayList<>();
        // Copiar los datos a las matrices
        int fila = 1;
        int filaN1 = 1;
        int filaN2=1;
        while(fila < m.size()){
            if(m.get(fila).getVaribles().get(posVariable).equalsIgnoreCase(valor)){
                matrizLaVariableEsIgualAlValor.add(m.get(filaN1));
                fila++;
                filaN1++;
            }else
            {
                matrizLaVariableNOEsIgualAlValor.add(m.get(filaN2));
                fila++;
                filaN2++;
            }
        }

//        System.out.println("EstudiantesLaVariableEsIgualAlValor "+matrizLaVariableEsIgualAlValor.size() ) ;
        Pair<ArrayList<Estudiante>,ArrayList<Estudiante>> parejaDeMatrices = new Pair<ArrayList<Estudiante>,ArrayList<Estudiante>>(matrizLaVariableEsIgualAlValor,matrizLaVariableNOEsIgualAlValor);
        return parejaDeMatrices;
    }

    public  TreeSet<String> posiblesValoresSinRepetirDeUnaVariable(ArrayList<Estudiante> m, int variable){
        TreeSet<String> respuesta = new TreeSet();
        for (int fila = 0; fila < m.size(); fila++)
            respuesta.add(m.get(fila).getVaribles().get(variable));
        return respuesta;
    }

    public double calcularElGiniPonderado(ArrayList<Estudiante> m, int variable, String valor){
        Pair<ArrayList<Estudiante>,ArrayList<Estudiante>> parejaDeMatrices = dividirUnaMatrizEnDosMatrices(m,variable,valor);
        double elGiniDeLaMatrizDeLaIzquierda = laImpurezaDeLosDatosDeUnaMatriz(parejaDeMatrices.getKey());
        double elGiniDeLaMatrizDeLaDerecha = laImpurezaDeLosDatosDeUnaMatriz(parejaDeMatrices.getValue());
        double elGiniPonderado = ((elGiniDeLaMatrizDeLaIzquierda*parejaDeMatrices.getKey().size()) + (elGiniDeLaMatrizDeLaDerecha*parejaDeMatrices.getValue().size())) /  (parejaDeMatrices.getKey().size() + parejaDeMatrices.getValue().size());

        return elGiniPonderado;
    }


    public Pair<Integer,String> encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(ArrayList<Estudiante> m){
        double laImpurezaMenorDentreTodoElmundo = 1;
        String elMejorValorDentreTodoElMundo = "";
        int laPosDeLaVariableDondeEstaElMejorValor = -1;
        for (int columna = 1; columna < m.get(0).getVaribles().size()-1; columna++){
            TreeSet<String> valores = posiblesValoresSinRepetirDeUnaVariable(m, columna);
            for (String unValor : valores) {
                double impurezaPonderadaDeEstaColumnaConEsteValor = calcularElGiniPonderado(m, columna, unValor);
                if (impurezaPonderadaDeEstaColumnaConEsteValor < laImpurezaMenorDentreTodoElmundo){
                    laImpurezaMenorDentreTodoElmundo = impurezaPonderadaDeEstaColumnaConEsteValor;
                    elMejorValorDentreTodoElMundo = unValor;
                    laPosDeLaVariableDondeEstaElMejorValor = columna;
                }
            }
        }

        System.out.println(laImpurezaMenorDentreTodoElmundo);
        Pair<Integer,String> respuesta = new Pair(laPosDeLaVariableDondeEstaElMejorValor, elMejorValorDentreTodoElMundo);
        return respuesta;
    }

}