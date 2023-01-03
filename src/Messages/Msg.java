package Messages;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;

/**
 * ErrorMessage
 */
public class Msg {
    public static void ShowErrorMsg(String text) {
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
            JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.ERROR_MESSAGE);
        } catch(Exception ex) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
    public static void ShowErrorMsg(String text, String title) {
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
            JOptionPane.showMessageDialog(null, text, title, JOptionPane.ERROR_MESSAGE);
        }  catch(Exception ex) {
            System.err.println( "Failed to initialize LaF" );
        }
    }

    public static void ShowOkMsg(String text) {
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
            JOptionPane.showMessageDialog(null, text, "Ok", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception ex) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
    public static void ShowOkMsg(String text, String title) {
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
            JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
        }  catch(Exception ex) {
            System.err.println( "Failed to initialize LaF" );
        }
    }
}