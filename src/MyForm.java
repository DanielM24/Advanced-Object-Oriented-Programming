import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

public class MyForm extends JFrame {

    private JPanel rootPanel;
    private JButton adaugaFacultateButton;
    private JButton afiseazaFacultatiButton;
    private JButton adaugaCandidatiButton;
    private JButton afiseazaCandidatiiButton;
    private JButton stergeFacultateButton;
    private JButton stergeCandidatButton;

    public MyForm() {
        add(rootPanel);
        setTitle("Admitere 2020 - 2021");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adaugaFacultateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertFacultate insertFacultate = new InsertFacultate();
                insertFacultate.setVisible(true);
                insertFacultate.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("adaugaFacultateButton", timestamp);
            }
        });
        adaugaCandidatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertCandidat insertCandidat = new InsertCandidat();
                insertCandidat.setVisible(true);
                insertCandidat.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("adaugaCandidatiButton", timestamp);
            }
        });
        afiseazaFacultatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAfisareFacultati();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("afiseazaFacultatiButton", timestamp);
            }
        });
        afiseazaCandidatiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAfisareCandidati();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("afiseazaCandidatiiButton", timestamp);
            }
        });
        stergeFacultateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StergeFacultate stergeFacultate = new StergeFacultate();
                stergeFacultate.setVisible(true);
                stergeFacultate.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("stergeFacultateButton", timestamp);
            }
        });
        stergeCandidatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StergeCandidat stergeCandidat = new StergeCandidat();
                stergeCandidat.setVisible(true);
                stergeCandidat.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("stergeCandidatiButton", timestamp);
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

    public void createAfisareFacultati() {
        final JFrame frame = new JFrame("Afisarea Facultatilor");
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Inapoi") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyForm myForm = new MyForm();
                myForm.setVisible(true);
                frame.dispose();
            }
        }));

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admitere?autoReconnect=true&useSSL=false", "root", "root1234");
            Statement st = conn.createStatement();
            String qry = "select nume from facultati";
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                frame.add(new JTextField("Facultatea de " + rs.getString("nume")));
                frame.validate();
                frame.repaint();
            }


        } catch (SQLException ex) {
            System.out.println("Eroare la conecatrea la BD");
        }


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }


    public void createAfisareCandidati() {
        final JFrame frame = new JFrame("Afisarea Candidatilor");
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Inapoi") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyForm myForm = new MyForm();
                myForm.setVisible(true);
                frame.dispose();
            }
        }));

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admitere?autoReconnect=true&useSSL=false", "root", "root1234");
            Statement st = conn.createStatement();
            String qry = "select nume, prenume from candidati";
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                frame.add(new JTextField(rs.getString("nume") + " " + rs.getString("prenume")));
                frame.validate();
                frame.repaint();
            }


        } catch (SQLException ex) {
            System.out.println("Eroare la conecatrea la BD");
        }


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }


}
