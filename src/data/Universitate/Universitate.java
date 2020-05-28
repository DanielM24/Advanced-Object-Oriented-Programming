package data.Universitate;

import data.Universitate.Facultate.Facultate;
import services.ConsoleTextService;

import java.util.HashSet;
import java.util.Set;

public class Universitate {
    String nume_universitate;
    String oras;
    int numar_facultati;
    Set<Facultate> facultati = new HashSet<Facultate>();

    public Universitate(String nume_universitate, String strada, int numar_facultati, Set<Facultate> facultati) {
        this.nume_universitate = nume_universitate;
        this.oras = strada;
        this.numar_facultati = numar_facultati;
        this.facultati = facultati;
    }

    public void set_nume_universitate(String nume_universitate) { this.nume_universitate = nume_universitate; }

    public String get_nume_universitate() { return nume_universitate; }

    public void set_oras(String strada) { this.oras = strada; }

    public String get_oras() { return oras; }

    public void set_numar_facultati(int numar_facultati) { this.numar_facultati = numar_facultati; }

    public int get_numar_facultati() { return numar_facultati; }

    public void set_facultati(Set<Facultate> facultati) { this.facultati = facultati; }

    public Set<Facultate> get_facultati() { return facultati; }

    public void add_facultate( Facultate newFacultate ){
        facultati.add(newFacultate);
    }
    public void add_facultate(){
        Facultate newFacultate = ConsoleTextService.getInstance().readConsoleFacultate();
        facultati.add(newFacultate);
    }
}