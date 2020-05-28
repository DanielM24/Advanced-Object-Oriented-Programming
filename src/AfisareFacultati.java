import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.Box;

public class AfisareFacultati extends JFrame {

    private JPanel panelAfisareFac;
    private Box vBox;


    public AfisareFacultati() {
        final JFrame frame = new JFrame("Afisarea Facultatilor");
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Inapoi") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyForm myForm = new MyForm();
                myForm.setVisible(true);
                dispose();
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

}
