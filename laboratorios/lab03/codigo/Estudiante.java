package Datos;

public class Estudiante {

    private String nom;
    private String sem;
    private String notFin;

    // constructor
    public Estudiante(String nom, String sem, String notFin){

        this.nom = nom;
        this.sem = sem;
        this.notFin = notFin;
    }

    // get and set nombres
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}

    // get and set semestre
    public String getSem() {return sem;}
    public void setSem(String nom) {this.sem = nom;}

    // get and set Nota Final
    public String getNotFin() { return notFin; }
    public void setNotFin(String notFin) { this.notFin = notFin; }
}
