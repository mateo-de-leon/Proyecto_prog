package login;


import java.awt.LayoutManager;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/** */
public class GUI extends JFrame{
    // Components to use

    private static JCheckBox keepSigned, showPassword;

    private static JTextField userField;
    private static JLabel userLabel;

    private static JPasswordField passwordField;
    private static JLabel passwordLabel;


    public GUI() {
        super();

        // Initialize components

        keepSigned = new JCheckBox();
        showPassword = new JCheckBox();

        userField = new JTextField();
        userLabel = new JLabel("User"); userLabel.setLabelFor(userField);

        passwordField = new JPasswordField();
        passwordLabel = new JLabel("Password"); passwordLabel.setLabelFor(passwordField);


        // Window config
        setLayout(null);
        setSize(400, 600);


        add(keepSigned);
        add(showPassword);

        add(userField);
        add(userLabel);

        add(passwordField);
        add(passwordLabel);



        setVisible(true);
    }



    /**
     * @return the keepSigned
     */
    public static JCheckBox getKeepSigned() {
        return keepSigned;
    }

    /**
     * @return the showPassword
     */
    public static JCheckBox getShowPassword() {
        return showPassword;
    }

    /**
     * @return the userField
     */
    public static JTextField getUserField() {
        return userField;
    }

    /**
     * @return the userLabel
     */
    public static JLabel getUserLabel() {
        return userLabel;
    }

    /**
     * @return the passwordField
     */
    public static JPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * @return the passwordLabel
     */
    public static JLabel getPasswordLabel() {
        return passwordLabel;
    }
}
