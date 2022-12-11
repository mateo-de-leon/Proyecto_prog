package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;
    private static String[] db = new String[4];

    private static void connectToDB() {
        try {
            db = security.genEncFile.getDecrpytedValues();

            String url = "jdbc:mysql://" + db[3] + "/" + db[0] + "?allowPublicKeyRetrieval=true&&useSSL=false";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, db[1], db[2]);
        } catch(Exception e) { e.printStackTrace(); }
    }
    public static Connection getConnection() {
        for (int i = 0; i < db.length; i++) {
            if(db[i] == null) {
                connectToDB();
                getConnection();
                break;
            }
        }

        return connection;
    }

}
