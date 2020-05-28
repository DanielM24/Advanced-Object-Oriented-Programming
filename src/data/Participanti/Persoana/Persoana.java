package data.Participanti.Persoana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Persoana {
    private String cnp;
    private String nume, prenume;
    private String data_nasterii;

    public Persoana(String cnp, String nume, String prenume, String data_nasterii) {
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.data_nasterii = data_nasterii;
    }

    public Persoana() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("CNP : ");
            set_cnp(reader.readLine());
            System.out.print("Nume : ");
            set_nume(reader.readLine());
            System.out.print("Prenume : ");
            set_prenume(reader.readLine());
            System.out.print("Data nasterii : ");
            set_data_nasterii(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void set_cnp(String cnp) { this.cnp = cnp; }

    public String get_cnp() { return cnp; }

    public void set_nume(String nume) { this.nume = nume; }

    public String get_nume () { return nume; }

    public void set_prenume(String prenume) { this.prenume = prenume; }

    public String get_prenume () { return prenume; }

    public void set_data_nasterii(String data_nasterii) { this.data_nasterii = data_nasterii; }

    public String get_data_nasterii () { return data_nasterii; }
}
