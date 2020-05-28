package data.Participanti.Candidat;

import data.Participanti.Dosar.Dosar;
import data.Participanti.Examen.Examen;
import data.Participanti.Persoana.Persoana;

import java.util.Date;

public class Candidat extends Persoana {
    private Float medie_admitere;
    private Dosar dosar;
    private Examen examen;

    public Candidat(String cnp, String nume, String prenume, String data_nasterii, Float medie_admitere, Dosar dosar, Examen examen){
        super(cnp, nume, prenume, data_nasterii);
        this.medie_admitere = medie_admitere;
        this.dosar = dosar;
        this.examen = examen;
    }

    public Candidat(String cnp, String nume, String prenume, String data_nasterii, Float medie_admitere){
        super(cnp, nume, prenume, data_nasterii);
        this.medie_admitere = medie_admitere;
    }

    public Float get_medie_admitere() { return medie_admitere; }

    public void set_medie_admitere(Float medie_admitere) { this. medie_admitere = medie_admitere; }

    public Dosar get_dosar() { return dosar; }

    public void set_dosar(Dosar dosar) {this.dosar = dosar; }

    public Examen get_examen() { return examen; }

    public void set_examen(Examen examen) {this.examen = examen; }
}