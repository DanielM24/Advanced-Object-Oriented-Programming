package services;

import data.Participanti.Candidat.Candidat;
import data.Participanti.Dosar.Dosar;
import data.Participanti.Examen.Examen;
import data.Universitate.Facultate.Facultate;
import data.Universitate.Specializare.Specializare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConsoleTextService {

    private static ConsoleTextService ourInstance = new ConsoleTextService();

    public static ConsoleTextService getInstance() {
        return ourInstance;
    }

    private ConsoleTextService() {
    }

    public Facultate readConsoleFacultate(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        String nume_faculate = null;
        String adressFacultate = null;
        Integer nrLocuri = 0, nrSpec = 0;
        List<Specializare> specializari = new ArrayList<Specializare>();
        try {
            System.out.print("Numele Facultatii : ");
            nume_faculate = reader.readLine();
            System.out.print("Adresa Facultatii : ");
            adressFacultate = reader.readLine();
            System.out.print("Nr locuri : ");
            nrLocuri = in.nextInt();
            System.out.print("Nr Specializari : ");
            nrSpec = in.nextInt();

        } catch (IOException e) {
            e.printStackTrace();
        }

        for ( int i = 0; i < nrSpec; i++ )
        {
            specializari.add(ConsoleTextService.getInstance().readConsoleSpecializare());
        }
        Facultate f = new Facultate(nume_faculate, adressFacultate, nrLocuri, nrSpec, specializari);
        return f;
    }


    public Specializare readConsoleSpecializare(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        String numeS = null;
        String tip_admitere = null;
        Integer nrLoc = 0;

        try {
            System.out.print("Numele Specializarii : ");
            numeS = reader.readLine();
            System.out.print("Nr Locuri : ");
            nrLoc = in.nextInt();
            System.out.print("Tip Admitere : ");
            tip_admitere = reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        List<Candidat> c = new ArrayList<Candidat>();
        System.out.println("Cititi nr de candidati: ");
        int nrC = in.nextInt();
        for ( int i = 0; i < nrC; i++ )
        {
            c.add(ConsoleTextService.getInstance().readConsoleCandidat());
        }
        Specializare s = new Specializare(numeS, nrLoc, tip_admitere, nrC, c);
        return s;
    }

    public Candidat readConsoleCandidat(){
//        public Candidat(String cnp, String nume, String prenume, Date data_nasterii, Integer medieAdmitere, Dosar dosar, Examen examen) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        Candidat c = null;

        String cnp, nume, prenume;
        String data_nasterii;
        Float medie_admitere;
        Dosar dosar;
        Examen examen;

        try {
            System.out.print("CNP : ");
            cnp = reader.readLine();
            System.out.print("Nume : ");
            nume = reader.readLine();
            System.out.print("Prenume : ");
            prenume = reader.readLine();
            System.out.println("Data nasterii: ");
            data_nasterii = reader.readLine();
            System.out.println("Medie admitere: ");
            medie_admitere = in.nextFloat();


            // Documente
            System.out.println("Nr documente: ");
            int nrDoc = in.nextInt();
            List<String> d = new ArrayList<String>();
            for ( int i = 0; i < nrDoc; i++ ){
                d.add(reader.readLine());
            }
            dosar = new Dosar(nrDoc, d);

            // Examen
            //nota,sala, legitimatie_concurs_id
            System.out.println("ID-ul candidatului la examen: ");
            int legitimatie_concurs_id = in.nextInt();
            System.out.println("Sala: ");
            int sala = in.nextInt();
            System.out.println("Nota: ");
            Float nota = in.nextFloat();

            examen = new Examen(legitimatie_concurs_id, sala, nota);
            c = new Candidat(cnp, nume, prenume, data_nasterii, medie_admitere, dosar, examen);

        } catch (IOException e){
            e.printStackTrace();
        }
        return c;
    }
}
