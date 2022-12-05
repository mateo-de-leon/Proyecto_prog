package login;


import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



/** */
public class LOL extends JFrame{
    // Components to use

    private static JCheckBox keepSigned, showPassword;

    private static JTextField userField;
    private static JLabel userLabel;

    private static JPasswordField passwordField;
    private static JLabel passwordLabel;


    public LOL() {
        super();

        // Initialize components

        keepSigned = new JCheckBox();
        keepSigned.setBounds(0, 0, 0, 0);
        showPassword = new JCheckBox();
        showPassword.setBounds(0, 0, 0, 0);

        userField = new JTextField();
        userField.setBounds(0, 0, 0, 0);
        userLabel = new JLabel("User"); 
        userLabel.setBounds(0, 0, 0, 0);userLabel.setLabelFor(userField);

        passwordField = new JPasswordField();
        passwordField.setBounds(0, 0, 0, 0);
        passwordLabel = new JLabel("Password"); 
        passwordLabel.setBounds(0, 0, 384, 561);passwordLabel.setLabelFor(passwordField);


        setSize(400, 600);
        getContentPane().setLayout(null);


        getContentPane().add(keepSigned);
        getContentPane().add(showPassword);

        getContentPane().add(userField);
        getContentPane().add(userLabel);

        getContentPane().add(passwordField);
        getContentPane().add(passwordLabel);



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
