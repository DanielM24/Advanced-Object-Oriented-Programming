import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;

public class StergeFacultate extends JFrame {
    private JTextField facultateText;
    private JButton stergeFacultatea;
    private JButton inapoi;
    private JPanel panelStergeFac;

    public StergeFacultate() {
        add(panelStergeFac);
        setTitle("Stergeti Facultati");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        stergeFacultatea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stergereFac = facultateText.getText();
                facultateText.setText("");

                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admitere?autoReconnect=true&useSSL=false", "root", "root1234");
                    PreparedStatement pst = conn.prepareStatement("delete from facultati where nume=?");
                    pst.setString(1, stergereFac);
                    pst.executeUpdate();

                } catch (SQLException ex) {
                    System.out.println("Eroare la conectarea la BD");
                }
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setService("stergeFacultatea", timestamp);
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
        try (FileWriter writer = new FileWriter("actiuni.csv", true)) {

            StringBuilder sb = new StringBuilder();

            sb.append(actiune);
            sb.append(',');
            sb.append(timestamp);
            sb.append('\n');

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
