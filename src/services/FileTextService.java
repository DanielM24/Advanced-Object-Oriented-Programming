package services;

import data.Participanti.Candidat.Candidat;
import data.Participanti.Dosar.Dosar;
import data.Participanti.Examen.Examen;
import data.Universitate.Facultate.Facultate;
import data.Universitate.Specializare.Specializare;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileTextService {
    private static FileTextService ourInstance = new FileTextService();

    public static FileTextService getInstance() {
        return ourInstance;
    }

    private FileTextService() {
    }


    public void writeTextToFile (String textToWrite, String fileNamePath) {

        try {
            PrintWriter printWriter = new PrintWriter(
                    new FileOutputStream(fileNamePath));

            printWriter.println(textToWrite);

            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //    /**
//     *
//     * @param fileNamePath
//     * @return
//     */
    public Facultate readFacultateFromFile(String fileNamePathFacultate, String fileNamePathSpecializare) {
        Facultate facultate = null;
        List<Specializare> specializari = new ArrayList<Specializare>();
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePathFacultate));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");

            LineNumberReader lineNumberReaderSpec = new LineNumberReader(
                    new FileReader(fileNamePathSpecializare));

            String lineSpec = lineNumberReaderSpec.readLine();
            while( lineSpec != null ){
                String[] valuesSpec = lineSpec.split(",");
                Specializare s = new Specializare(valuesSpec[0], Integer.parseInt(valuesSpec[1]), valuesSpec[2], 0, null);
                specializari.add(s);
                lineSpec = lineNumberReaderSpec.readLine();
            }
            facultate = new Facultate(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), specializari);
            lineNumberReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return facultate;
    }

    public Dosar readDosarFromFile(String fileNamePath) {
        Dosar dosar = null;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePath));

            String line = lineNumberReader.readLine();

            String[] values = line.split(",");

            Integer nrDoc = 0;
            System.out.println(values[0]);
            nrDoc = Integer.valueOf(values[0].substring(1));    // nu parseaza bine int-ul
            System.out.println(nrDoc);
            List<String> docs = new ArrayList<String>();
            for (int i = 1; i <= nrDoc; i++) {
                docs.add(values[i]);
            }
            dosar = new Dosar(nrDoc, docs);
            lineNumberReader.close();

        }catch(NumberFormatException e){
            e.printStackTrace();
        }   catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dosar;
    }

    public Candidat readCandidatFromFile( String fileNamePath){
        Candidat candidat = null;
        Examen examen = null;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(
                    new FileReader(fileNamePath));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");


            Dosar dosar = readDosarFromFile("D:/Facultate/An II/Semestrul II/Programare Avansata pe Obiecte/Proiect/Proiect Admitere 2020/files/Dosare_Candidati.csv");
            examen = new Examen(Integer.parseInt(values[5]), Integer.parseInt(values[6]), Float.parseFloat(values[7]));
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("dd/MM/yyyy");
            candidat = new Candidat(values[0], values[1], values[2], values[3],Float.parseFloat(values[4]), dosar,examen);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return candidat;
    }



}

