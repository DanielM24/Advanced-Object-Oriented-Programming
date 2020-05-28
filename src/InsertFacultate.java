import data.Participanti.Candidat.Candidat;
import data.Universitate.Facultate.Facultate;
import data.Universitate.Specializare.Specializare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class InsertFacultate extends JFrame {
    private JPanel panelFacultate;
    private JTextField introducetiNumeleFacultatiiTextField;
    private JTextField introducetiAdresaTextField;
    private JTextField nrTotalDeLocuriTextField;
    private JTextField nrSpecializariTextField;
    private JButton adaugaSpecializareButton;
    private JTextField numeSpecializareText;
    private JTextField nrLocuriText;
    private JTextField tipAdmitereText;
    private JButton AddFacultate;
    private JButton inapoi;

    private List<Specializare> specializari = new ArrayList<>();

    public InsertFacultate() {
        add(panelFacultate);
        setTitle("Intoduceti Facultate");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        adaugaSpecializareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = numeSpecializareText.getText();
                String tip = tipAdmitereText.getText();
                Integer nrLoc = Integer.parseInt(nrLocuriText.getText());
                Integer nrCand = 0;
                List<Candidat> c = new ArrayList<Candidat>();

                Specializare s = new Specializare(nume, nrLoc, tip, nrCand, c);
                specializari.add(s);

                numeSpecializareText.setText("");
                tipAdmitereText.setText("");
                nrLocuriText.setText("");
            }
        });


        AddFacultate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fac = introducetiNumeleFacultatiiTextField.getText();
                String adresa = introducetiAdresaTextField.getText();
                Integer nrLoc = Integer.parseInt(nrTotalDeLocuriTextField.getText());
                Integer nrSpec = Integer.parseInt(nrSpecializariTextField.getText());

                Facultate f = new Facultate(fac, adresa, nrLoc, nrSpec, specializari);

                introducetiAdresaTextField.setText("");
                introducetiNumeleFacultatiiTextField.setText("");
                nrSpecializariTextField.setText("");
                nrTotalDeLocuriTextField.setText("");

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admitere?autoReconnect=true&useSSL=false", "root", "root1234");
                    Statement stFac = conn.createStatement();
                    String idMaxFac = "select max(id) from facultati";
                    ResultSet rsFac = stFac.executeQuery(idMaxFac);
                    Integer idxFac = 0, idxSpec = 0;
                    while (rsFac.next()) {
                        idxFac = rsFac.getInt("max(id)");
                    }
                    idxFac++;

                    Statement stSpec = conn.createStatement();
                    String idMaxSpec = "select max(id_specializare) from specializari";
                    ResultSet rsSpec = stSpec.executeQuery(idMaxSpec);
                    while (rsSpec.next()) {
                        idxSpec = rsSpec.getInt("max(id_specializare)");
                    }
                    idxSpec++;

                    PreparedStatement pst = conn.prepareStatement("INSERT INTO facultati" + " VALUES (?, ?, ?, ?, ?)");
                    pst.setInt(1, idxFac);
                    pst.setString(2, fac);
                    pst.setString(3, adresa);
                    pst.setInt(4, nrLoc);
                    pst.setInt(5, nrSpec);
                    pst.executeUpdate();

                    for (int i = 0; i < nrSpec; i++) {

                        PreparedStatement specSTM = conn.prepareStatement("INSERT into specializari" + " VALUES (?,?,?,?,?)");
                        specSTM.setInt(1, idxSpec);
                        idxSpec++;
                        specSTM.setInt(2, idxFac);
                        specSTM.setString(3, specializari.get(i).get_nume_specializare());
                        specSTM.setInt(4, specializari.get(i).get_numar_locuri_specializare());
                        specSTM.setInt(5, 0);
                        specSTM.executeUpdate();
                    }

                } catch (SQLException ex) {
                    System.out.println("Eroare la conectare la BD");
                }
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("AddFacultate", timestamp);

            }
        });
        inapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyForm myForm = new MyForm();
                myForm.setVisible(true);
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("inapoi", timestamp);
            }
        });
    }

    public void setService(String actiune, Timestamp timestamp) {
        try (PrintWriter writer = new PrintWriter(new File("actiuni.csv"))) {

            StringBuilder sb = new StringBuilder();

            sb.append(actiune);
            sb.append(',');
            sb.append(timestamp);
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }



}
