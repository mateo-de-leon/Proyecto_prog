package login;


import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;



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
        keepSigned.setBounds(80, 347, 114, 21);
        showPassword = new JCheckBox();
        showPassword.setBounds(287, 296, 91, 21);

        userField = new JTextField();
        userField.setBounds(80, 213, 201, 20);
        userLabel = new JLabel("User"); 
        userLabel.setLocation(80, 188);
        userLabel.setSize(58, 14);

        passwordField = new JPasswordField();
        passwordField.setBounds(80, 297, 201, 20);
        passwordLabel = new JLabel("Password"); 
        passwordLabel.setLocation(80, 272);
        passwordLabel.setSize(58, 14);


        setSize(400, 600);
        getContentPane().setLayout(null);


        getContentPane().add(keepSigned);
        getContentPane().add(showPassword);

        getContentPane().add(userField);
        getContentPane().add(userLabel);

        getContentPane().add(passwordField);
        getContentPane().add(passwordLabel);
        
        JButton submit = new JButton("Submit");
        submit.setBounds(80, 407, 201, 47);
        getContentPane().add(submit);



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
