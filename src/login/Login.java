package login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DB.DBConnection;

/**
 * @author SrBlackDEVs
 * 
 * Credit to Anthony Zabs (Youtube) for the design
 */
public class Login extends javax.swing.JFrame{
    private static String type, user, username;

	private ImageIcon backIcon = new ImageIcon(execLogin.class.getResource("recurs/gic.png"));
    private JPanel bg;
    private JLabel backbg;
    private JPanel exitBtn;
    private JLabel exitTxt;
    private JLabel favicon;
    private JPanel header;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JPanel loginBtn;
    private JLabel loginBtnTxt;
    private JLabel passLabel;
    private JPasswordField passTxt;
    private JLabel title;
    private JLabel userLabel;
    private JTextField userTxt;
    private JPanel showAbsBtn;
    private JLabel showAbsTxt;
    int mouseX, mouseY;
    
    public Login() {
        initComponents();

        userTxt.requestFocus(); // To fix the place holders
        userTxt.setText("");
        userTxt.setForeground(Color.BLACK);
    }
    
    private void initComponents() {

        bg = new JPanel();
        backbg = new JLabel();
        header = new JPanel();
        exitBtn = new JPanel();
        exitTxt = new JLabel();
        favicon = new JLabel();
        title = new JLabel();
        userLabel = new JLabel();
        userTxt = new JTextField();
        jSeparator1 = new JSeparator();
        passLabel = new JLabel();
        passTxt = new JPasswordField();
        jSeparator2 = new JSeparator();
        loginBtn = new JPanel();
        loginBtnTxt = new JLabel();
        showAbsBtn = new JPanel();
        showAbsTxt = new JLabel();

        setDefaultCloseOperation(3);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        

        bg.setBackground(new Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backbg.setBackground(new Color(0, 134, 190));
        backbg.setIcon(backIcon);
        bg.add(backbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(548, 0, -1, 500));

        header.setBackground(new Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                try {
                    headerMouseDragged(evt);
                } catch (InterruptedException e) {
                }
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    headerMousePressed(evt);
                } catch(Exception e) {

                }
            }
        });

        exitBtn.setBackground(new Color(255, 255, 255));

        exitTxt.setFont(new Font("Roboto Light", 0, 24));
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitTxt.setPreferredSize(new Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        GroupLayout exitBtnLayout = new GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(exitBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(exitTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
        exitBtnLayout.setVerticalGroup(exitBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(exitTxt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout headerLayout = new GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(exitBtn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 800, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(exitBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 40));

        favicon.setFont(new Font("Roboto Black", 1, 24));
        favicon.setIcon(null);
        favicon.setText("HS Tech");
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        title.setFont(new Font("Roboto Black", 1, 24));
        title.setText("Sign in");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        userLabel.setFont(new Font("Roboto Light", 1, 14));
        userLabel.setText("User");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        userTxt.setFont(new Font("Roboto", 0, 12));
        userTxt.setForeground(new Color(204, 204, 204));
        userTxt.setText("Your user");
        userTxt.setBorder(null);
        userTxt.addMouseListener(new MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        bg.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 410, 30));

        jSeparator1.setForeground(new Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 410, 20));

        passLabel.setFont(new Font("Roboto Light", 1, 14));
        passLabel.setText("Password");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        passTxt.setForeground(new Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        bg.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 410, 30));
        
        jSeparator2.setForeground(new Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 410, 20));

        loginBtn.setBackground(new Color(12, 12, 12));

        loginBtnTxt.setFont(new Font("Roboto Condensed", 1, 14));
        loginBtnTxt.setForeground(new Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(SwingConstants.CENTER);
        loginBtnTxt.setText("Sign in");
        loginBtnTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
        });

        GroupLayout loginBtnLayout = new GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 130, 40));


       showAbsBtn.setBackground(new Color(12, 12, 12));

        showAbsTxt.setFont(new Font("Roboto Condensed", 1, 14));
        showAbsTxt.setForeground(new Color(255, 255, 255));
        showAbsTxt.setHorizontalAlignment(SwingConstants.CENTER);
        showAbsTxt.setText("Continue without login");
        showAbsTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showAbsTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showAbsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showAbsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showAbsMouseExited(evt);
            }
        });

        GroupLayout showAbsBtnLayout = new GroupLayout(showAbsBtn);
        showAbsBtn.setLayout(showAbsBtnLayout);
        showAbsBtnLayout.setHorizontalGroup(
            showAbsBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(showAbsTxt, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        showAbsBtnLayout.setVerticalGroup(
            showAbsBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(showAbsTxt, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(showAbsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 200, 40));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(bg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(bg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    } 

    private void headerMousePressed(java.awt.event.MouseEvent evt) throws InterruptedException {
        mouseX = evt.getX();
        mouseY = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) throws InterruptedException {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - mouseX, y - mouseY);
    }

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {
        loginBtn.setBackground(new Color(50, 50, 50)); // Hover effect opacity
    }

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {
        loginBtn.setBackground(new Color(12, 12, 12));
    }

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {
        if (userTxt.getText().equals("Your user")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
    }

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {
        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Your user");
            userTxt.setForeground(Color.gray);
        }
    }

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            String preparedState1 = "SELECT user FROM login WHERE user='" + userTxt.getText() + "';";
            String preparedState2 = "SELECT pass FROM login WHERE user='" + userTxt.getText() + "';";
            String preparedState3 = "SELECT type FROM login WHERE user='" + userTxt.getText() + "';";
            String preparedState4 = "SELECT name FROM login WHERE user='" + userTxt.getText() + "';";

            Connection conn = DBConnection.getConnection();

            Statement state1 = conn.createStatement();
            Statement state2 = conn.createStatement();
            Statement state3 = conn.createStatement();
            Statement state4 = conn.createStatement();
        
            ResultSet userR = state1.executeQuery(preparedState1);
            ResultSet passR = state2.executeQuery(preparedState2);
            ResultSet typeR = state3.executeQuery(preparedState3);
            ResultSet usernameR = state4.executeQuery(preparedState4);

            String pass = "";

            if(userR.next()) {
                user = userR.getString(1);
            }
            if(passR.next()) {
                pass = passR.getString(1);
            }
            if(typeR.next()) {
                type = typeR.getString(1);
            }
            if(usernameR.next()) {
                username = usernameR.getString(1);
            }
            if(user.equals(userTxt.getText())) {
                char[] passwd = passTxt.getPassword();
                String passwordDecrypted = new String(passwd);
                /* Use a getText() with a password field is stupid.
                 * If you want to use a getText() use a JTextField, is the same.
                 * 
                 * Security is important, you must use getPassword() and convert it to a String if is necessary
                 */

                if(pass.equals(passwordDecrypted)) {
                    dispose();
                    try {
                        new Dashboard.execDashboard().setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    private void showAbsMouseEntered(java.awt.event.MouseEvent evt) {
        showAbsBtn.setBackground(new Color(50, 50, 50)); // Hover effect opacity
    }

    private void showAbsMouseExited(java.awt.event.MouseEvent evt) {
        showAbsBtn.setBackground(new Color(12, 12, 12));
    }
    private void showAbsMouseClicked(java.awt.event.MouseEvent evt) {
        dispose();
        showAbsences.execView.main(null);
    }

    public static String getTypeUser() { return type; }
    public static String getUser() { return user; }
    public static String getUserName() { return username; }
}