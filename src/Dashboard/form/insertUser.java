package Dashboard.form;

import java.sql.Connection;
import java.sql.PreparedStatement;

import showAbsences.Table;

public class insertUser extends Thread{
    private Table table;
    
    public insertUser(Table table) {
        this.table = table;

        start();
        setPriority(1); // Minium priority
    }
    public void run() {
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

                if(login.Login.getUser() == table.getValueAt(index, 1)) {
                    Messages.Msg.ShowOkMsg("You can't delete the user that you are using", "Error deleting user");
                } else {
                    if(login.Login.getTypeUser().equals("Director")) {
                        Messages.Msg.ShowErrorMsg("You can't delete the user of a director", "Error deleting user");
                    } else {
                        d.executeUpdate();
                        p.executeUpdate();
                    }
                }

            } catch(Exception e) {
                e.printStackTrace();
                status = false;
                Messages.Msg.ShowErrorMsg("Existent user or incorrect values", "Error creating user");
                break;
            }
        }
        if(status) { Messages.Msg.ShowOkMsg("Data saved correctly", "Data saved"); }
    }
}
