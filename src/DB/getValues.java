package DB;

import java.io.File;

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
    String[] db = new String[3]; 
    
    /**
     * 
     * @param nameDB Name of the DB
     * @param userDB User for the DB
     * @param passwdDB Password of the DB
     * @param host Host for the DB. Set null if localhost
     */
    public void setDB(String nameDB, String userDB, String passwdDB, String host) {
        this.db[0] = nameDB;
        this.db[1] = userDB;
        this.db[2] = passwdDB;
        
        if(host == null) {
            this.db[3] = "localhost:3306";
        } else {
            this.db[3] = host;
        }
    }
    public void setAutoDB(File file) {
        
    }
    
}
