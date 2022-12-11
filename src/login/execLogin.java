package login;

import DB.DBConnection;

public class execLogin {

     public static void main(String args[]) throws InterruptedException{
        try {
            new Login().setVisible(true);
            DBConnection.getConnection();
        } catch(Exception e) {
            if(e.getClass().toString().equals("class java.lang.NullPointerException")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error with paths. \nIcons not found in path.", "Error main_001", 0);
            }
            e.printStackTrace();
        }
    }
}