package Taller1;

public class Fecha {
	int dia, mes, anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int dia() {
        return this.dia;
    }

    public int mes() {
        return this.mes;
    }

    public int anio() {
        return this.anio;
    }

    // -1 si esta fecha es anterior a la otra
    // 0 si son iguales
    // 1 si esta fecha es posterior a la otra
    int ret = 0;
    public int comparar(Fecha otra) {
        if (this.anio < otra.anio) {
            ret = -1;
        }else if (this.anio > otra.anio){
        	ret = 1;
        }else{
        	if (this.mes < otra.mes) {
        	ret = -1;
        	}else if (this.mes > otra.mes) {
        	ret = 1;
        	}else {
        		 if (this.dia < otra.dia) {
        	        ret = -1;
        		 }else if (this.dia > otra.dia) {
        	        ret = 1;
        		 }else {
        			 ret = 0;
        		 }
        		
        	}
        }
       

        return ret;
    }

    public String toString() {
        return (this.dia +"/"+ this.mes +"/"+ this.anio);
    }
}
