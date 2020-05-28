package data.Universitate.Facultate;

import data.Universitate.Admitere.Admitere;
import data.Universitate.Specializare.Specializare;
import services.ConsoleTextService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facultate {
    private String nume_facultate;
    private String adresa_facultate;
    private int numar_locuri_total;
    private int numar_specializari;
    private List<Specializare> specializari = new ArrayList();

    public Facultate(String nume_facultate, String adresa_facultate, int numar_locuri_total, int numar_specializari, List<Specializare> specializari) {
        this.nume_facultate = nume_facultate;
        this.adresa_facultate = adresa_facultate;
        this.numar_locuri_total = numar_locuri_total;
        this.numar_specializari = numar_specializari;
        this.specializari = specializari;
    }


    public Facultate(String nume_facultate, String adresa_facultate, int numar_locuri_total, int numar_specializari ){
        this.nume_facultate = nume_facultate;
        this.adresa_facultate = adresa_facultate;
        this.numar_locuri_total = numar_locuri_total;
        this.numar_specializari = numar_specializari;

        for ( int i = 0; i < numar_specializari; i++ )
        {
            this.specializari.add(ConsoleTextService.getInstance().readConsoleSpecializare());
        }
    }

    public void set_nume_facultate(String nume_facultate) { this.nume_facultate = nume_facultate; }

    public String get_nume_facultate() { return nume_facultate; }

    public void set_adresa_facultate(String adresa_facultate) { this.adresa_facultate = adresa_facultate; }

    public String get_adresa_facultate() { return adresa_facultate; }

    public void set_numar_locuri_total(int numar_locuri_total) { this.numar_locuri_total = numar_locuri_total; }

    public int get_numar_locuri_total() { return numar_locuri_total; }

    public void set_numar_specializari(int numar_specializari) { this.numar_specializari = numar_specializari; }

    public int get_numar_specializari() { return numar_specializari; }

    public void set_specializari(List<Specializare> specializari) { this.specializari = specializari; }

    public List<Specializare> get_specializari() { return specializari; }
}