package Dashboard.form;

import java.sql.Connection;
import java.sql.PreparedStatement;

import showAbsences.Table;

public class insertTeachers extends Thread{
    private Table table;
    
    public insertTeachers(Table table) {
        this.table = table;

        start();
        setPriority(1); // Minium priority
    }
    public void run() {
        boolean status = true;

        for (int index = 0; index < table.getRowCount(); index++) {

            try {
                Connection conn = DB.DBConnection.getConnection();

                String sql = "INSERT INTO teacher (name, ci) VALUES (?, ?);";
                String sql2 = "DELETE FROM teacher where name=? and ci=?";

                PreparedStatement d = conn.prepareStatement(sql2);
                PreparedStatement p = conn.prepareStatement(sql);


                d.setString(1, (String) table.getValueAt(index, 1));
                d.setString(2, (String) table.getValueAt(index, 2));
                d.executeUpdate();
                p.executeUpdate();

            } catch(Exception e) {
                e.printStackTrace();
                status = false;
                Messages.Msg.ShowErrorMsg("Existent teacher or incorrect values", "Error adding teacher");
                break;
            }
        }
        if(status) { Messages.Msg.ShowOkMsg("Data saved correctly", "Data saved"); }
    }
}
