package security;

import java.io.BufferedReader;
import java.io.File;

public class genEncFile {
    public genEncFile() {
        File file = new File("/src/DB/dbarr.dat");

        if(!file.exists()) {
            try {

                file.createNewFile();

                BufferedWriter wr = new BufferedReader(null);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
