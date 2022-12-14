package Dashboard.form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import showAbsences.Table;

public class insertAbsences extends Thread{
    private Table table;
    
    public insertAbsences(Table table) {
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

                String sql3 = "SELECT name FROM teacher WHERE name=? and ci=?";
                String sql = "INSERT INTO absences (name, ci, groupsAffected, initDate, finalDate, reason) VALUES (?, ?, ?, ?, ?, ?);";
                String sql2 = "DELETE FROM absences where ci=? and name=? and initDate=? and finalDate=?";

                PreparedStatement d = conn.prepareStatement(sql2);
                PreparedStatement p = conn.prepareStatement(sql);
                PreparedStatement c = conn.prepareStatement(sql3);

                c.setString(1, (String) table.getValueAt(index, 1));
                c.setString(2, (String) table.getValueAt(index, 2));

                result = c.executeQuery();
                if(result.next()) {
                    d.setString(1, (String) table.getValueAt(index, 2));
                    d.setString(2, (String) table.getValueAt(index, 1));
                    d.setString(3, (String) table.getValueAt(index, 4));
                    d.setString(4, (String) table.getValueAt(index, 5));
    
                    p.setString(1, (String) table.getValueAt(index, 1));
                    p.setString(2, (String) table.getValueAt(index, 2));
                    p.setString(3, (String) table.getValueAt(index, 3));
                    p.setString(4, (String) table.getValueAt(index, 4));
                    p.setString(5, (String) table.getValueAt(index, 5));
                    p.setString(6, (String) table.getValueAt(index, 6));
                    d.executeUpdate();
                    p.executeUpdate();
                } else {
                    status = false;
                    JOptionPane.showMessageDialog(null, "Inexistent teacher", "Error saving values", JOptionPane.ERROR_MESSAGE);
                    break;
                }

            } catch(Exception e) {
                e.printStackTrace();
                status = false;
                JOptionPane.showMessageDialog(null, "Please check the date, please use format YYYY-MM-DD", "Error saving values", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
        if(status) { JOptionPane.showMessageDialog(null, "Data saved.", "Saved", JOptionPane.INFORMATION_MESSAGE);}
    }
}
