package data.Universitate.Specializare;

import data.Participanti.Candidat.Candidat;
import java.util.ArrayList;
import java.util.List;

public class Specializare {
    private String nume_specializare;
    private int numar_locuri_specializare;
    private String tip_admitere_specializare;
    private Integer numar_candidati;
    private List<Candidat> candidati = new ArrayList<Candidat>();

    public Specializare(String nume_specializare, int numar_locuri_specializare, String tip_admitere_specializare, Integer numar_candidati ,List<Candidat> c) {
        this.nume_specializare = nume_specializare;
        this.numar_locuri_specializare = numar_locuri_specializare;
        this.tip_admitere_specializare = tip_admitere_specializare;
        this.numar_candidati = numar_candidati;
        this.candidati = c;
    }

    public void set_nume_specializare(String nume_specializare) { this.nume_specializare = nume_specializare; }

    public String get_nume_specializare() { return nume_specializare; }

    public void set_numar_locuri_specializare(int numar_locuri_specializare) { this.numar_locuri_specializare = numar_locuri_specializare; }

    public int get_numar_locuri_specializare() { return numar_locuri_specializare; }

    public void set_tip_admitere_specializare(String tip_admitere_specializare) { this.tip_admitere_specializare = tip_admitere_specializare; }

    public String get_tip_admitere_specializare() { return tip_admitere_specializare; }

    public void set_candidati(List<Candidat> c){ this.candidati = c; }

    public void add_candidat(Candidat c ){ candidati.add(c); }

    public List<Candidat> get_candidati(){ return candidati; }

    public void set_numar_candidati(Integer numar_candidati) { this.numar_candidati = numar_candidati; }

    public Integer get_numar_candidati() { return numar_candidati; }
}