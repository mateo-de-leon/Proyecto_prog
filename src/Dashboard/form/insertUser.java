package Dashboard.form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import showAbsences.Table;

public class insertUser extends Thread{
    private Table table;
    
    public insertUser(Table table) {
        this.table = table;

        start();
        setPriority(1); // Minium priority
    }
    public void run() {
        ResultSet result;
        boolean status = true;

        for (int index = 0; index < table.getRowCount(); index++) {

            try {
                Connection conn = DB.DBConnection.getConnection();

                String sql = "INSERT INTO login (name, ci, pass, type) VALUES (?, ?, ?, ?);";
                String sql2 = "DELETE FROM login where name=? and ci=? and pass=? and type=?";

                PreparedStatement d = conn.prepareStatement(sql2);
                PreparedStatement p = conn.prepareStatement(sql);


                d.setString(1, (String) table.getValueAt(index, 1));
                d.setString(2, (String) table.getValueAt(index, 2));
                d.setString(3, (String) table.getValueAt(index, 3));
                d.setString(4, (String) table.getValueAt(index, 4));
                p.setString(1, (String) table.getValueAt(index, 1));
                p.setString(2, (String) table.getValueAt(index, 2));
                p.setString(3, (String) table.getValueAt(index, 3));
                p.setString(4, (String) table.getValueAt(index, 4));
                p.setString(5, (String) table.getValueAt(index, 5));
                d.executeUpdate();
                p.executeUpdate();

            } catch(Exception e) {
                e.printStackTrace();
                status = false;
                JOptionPane.showMessageDialog(null, "Existent user or incorrect values", "Error creating user", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
        if(status) { JOptionPane.showMessageDialog(null, "Data saved.", "Saved", JOptionPane.INFORMATION_MESSAGE);}
    }
}
