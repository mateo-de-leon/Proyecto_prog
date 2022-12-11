package showAbsences;

/**
 * execView
 */
public class execView {
    public static void main(String[] args) {
        try {
            new GUI().setVisible(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}