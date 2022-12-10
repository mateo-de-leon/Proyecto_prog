package security;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class genEncFile {
    public static void genFile() throws IOException {
        File file = new File("src/DB/dbval.dat");

        FileWriter fw = null;

        String[] dbreaded = new String[4];

        Scanner sc = null;

        try {
            sc = new Scanner(file);

            int i = 0;
            while (sc.hasNextLine()) {
                dbreaded[i] = sc.nextLine();
                i = i + 1;
            }
        } catch(Exception e) {
            if(!file.exists()) {
                if(file.createNewFile()) {
                    System.out.println("Created file");
                }
                genFile();
            }
            e.printStackTrace();
        }
        fw = new FileWriter(file);

        for (int i = 0; i < dbreaded.length; i++) {
            try {
                dbreaded[i] = Criptography.getEncryptedString(dbreaded[i], Criptography.getGlobalKey());
                fw.write(dbreaded[i] + "\n");
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
                    | BadPaddingException e) {
                        e.printStackTrace();
            }
        }
        fw.close();

        
    }
    public static String[] getDecrpytedValues() {
        Scanner sc = null;

        File file = new File("src/DB/dbval.dat");
        String[] dbreaded = new String[4];

        try {
            sc = new Scanner(file);

            int i = 0;
            while (sc.hasNextLine()) {
                dbreaded[i] = sc.nextLine();
                dbreaded[i] = Criptography.decrypt(dbreaded[i], Criptography.getGlobalKey());
                i++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        	}
        return dbreaded;
    }
}