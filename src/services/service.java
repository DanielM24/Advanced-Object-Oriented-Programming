package services;

import data.Participanti.Candidat.Candidat;
import data.Universitate.Facultate.Facultate;

public class service {

    public Facultate add_facultate(){
        Facultate f = ConsoleTextService.getInstance().readConsoleFacultate();
        return f;
    }

    public Candidat add_candidat(){
        Candidat c = ConsoleTextService.getInstance().readConsoleCandidat();
        return c;
    }

}
