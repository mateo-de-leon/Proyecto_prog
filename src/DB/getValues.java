package DB;

import java.sql.DriverManager;

import security.genEncFile;

/**
 * Simple object to get values from a Database
 */
public class getValues {

    /**
     * 0: DB
     * 1: User
     * 2: Password
     * 3: Host
     */
    private static String[] db = new String[4]; 
    
    /**
     * 
     * @param nameDB Name of the DB
     * @param userDB User for the DB
     * @param passwdDB Password of the DB
     * @param host Host for the DB. Set null if localhost
     */
    public static void setDB(String nameDB, String userDB, String passwdDB, String host) {
        db[0] = nameDB;
        db[1] = userDB;
        db[2] = passwdDB;
        
        if(host == null) {
            db[3] = "localhost:3306";
        } else {
            db[3] = host;
        }
    }
    public static void setAutoDB() {
        db = genEncFile.getDecrpytedValues();
    }
    public static boolean testConnection() {
        setAutoDB();
        String url = "jdbc:mysql://" + db[3] + "/" + db[0] + "?useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url, db[1], "mateo");        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
}
