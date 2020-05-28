package data.Universitate.Admitere;

import data.Participanti.Candidat.Candidat;

import java.util.List;

public class Admitere {
    private int numar_candidati;
    private List<Candidat> lista_candidati;
    private String proba_admitere;

    public Admitere(int numar_candidati, List<Candidat> lista_candidati, String proba_admitere) {
        this.numar_candidati = numar_candidati;
        this.lista_candidati = lista_candidati;
        this.proba_admitere = proba_admitere;
    }

    public Admitere(String File){

    }

    public void set_numar_candidati(int numar_candidati) { this.numar_candidati = numar_candidati; }

    public int get_numar_candidati() { return numar_candidati; }

    public void set_lista_candidati(List<Candidat> lista_candidati) { this.lista_candidati = lista_candidati; }

    public List<Candidat> get_lista_candidati() { return lista_candidati; }

    public void set_proba_admitere(String proba_admitere) {this. proba_admitere = proba_admitere; }

    public String get_proba_admitere() { return proba_admitere; }
}