package login;

import DB.DBConnection;

public class execLogin {

     public static void main(String args[]) throws InterruptedException{
        try {
            new Login().setVisible(true);
            DBConnection.getConnection();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}