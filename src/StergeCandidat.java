import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

public class StergeCandidat extends JFrame {
    private JTextField numeText;
    private JTextField prenumeText;
    private JButton stergeCandidatul;
    private JButton inapoi;
    private JPanel panelStergeCandidat;

    public StergeCandidat() {


        add(panelStergeCandidat);
        setTitle("Stergeti Facultati");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        stergeCandidatul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nume = numeText.getText();
                numeText.setText("");
                String prenume = prenumeText.getText();
                prenumeText.setText("");

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admitere?autoReconnect=true&useSSL=false", "root", "root1234");
                    PreparedStatement pst = conn.prepareStatement("delete from candidati where nume=? and prenume=?");
                    pst.setString(1, nume);
                    pst.setString(2, prenume);
                    pst.executeUpdate();

                } catch (SQLException ex) {
                    System.out.println("Eroare la conectarea la BD");
                }

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("stergeCandidatul", timestamp);

            }



        });


        inapoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyForm myForm = new MyForm();
                myForm.setVisible(true);
//                myForm.pack();
                dispose();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("inapoi", timestamp);
            }
        });
    }
    public void setService(String actiune, Timestamp timestamp) {
        try (PrintWriter writer = new PrintWriter(new File("actiuni.csv"))) {

            StringBuilder sb = new StringBuilder();

//                    System.out.println(timestamp);
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
