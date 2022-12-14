package Dashboard.form;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Dashboard.Searchbar.textfield.SearchOptinEvent;
import Dashboard.Searchbar.textfield.SearchOption;
import Dashboard.Searchbar.textfield.TextFieldSearchOption;
import showAbsences.Table;

public class Form_5 extends JPanel {
    private JScrollPane jScrollPane1;
    private TextFieldSearchOption txt;
    private Table TableGUI;

    private JPanel saveVaBtn;
    private JLabel saveVaTxt;
    private JPanel addRowBtn;
    private JLabel addRowTxt;
    private JPanel delRowBtn;
    private JLabel delRowTxt;

    public Form_5(int index) {
        initComponents(index);
        setOpaque(false);
        setLayout(null);
        setLayout(null);
        add(jScrollPane1);
        add(txt);

        TableGUI.fixTable(jScrollPane1);
        TableGUI.setColumnAlignment(0, JLabel.CENTER);
        TableGUI.setCellAlignment(0, JLabel.CENTER);
        TableGUI.setColumnAlignment(2, JLabel.CENTER);
        TableGUI.setCellAlignment(2, JLabel.CENTER);
        TableGUI.setColumnAlignment(4, JLabel.RIGHT);
        TableGUI.setCellAlignment(4, JLabel.RIGHT);
        TableGUI.setColumnWidth(0, 50);
        TableGUI.setColumnWidth(2, 100);

        txt.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                txt.setHint("Search by " + option.getName() + "...");
            }
        });
        txt.addOption(new SearchOption("Name", new ImageIcon(getClass().getResource("../icon/searchByUser.png"))));
        txt.addOption(new SearchOption("CI", new ImageIcon(getClass().getResource("../icon/searchByCI.png"))));

        LoadData("");
    }

    private void LoadData(String where, Object... search) {
        try {
            DefaultTableModel model = (DefaultTableModel) TableGUI.getModel();
            model.setRowCount(0);

            PreparedStatement p = DB.DBConnection.getConnection().prepareStatement("select * from teacher " + where);

            for (int i = 0; i < search.length; i++) {
                p.setObject(i + 1, search[i]);
            }

            ResultSet result = p.executeQuery();

            while(result.next()) {
                String name = result.getString("name");
                String ci = result.getString("ci");

                model.addRow(new Object[] {TableGUI.getRowCount() + 1, name, ci});
            }

            result.close();
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    

    private void initComponents(int index) {
        TableGUI = new Table();

        saveVaBtn = new JPanel();
        saveVaTxt = new JLabel();

        addRowBtn = new JPanel();
        addRowTxt = new JLabel();

        delRowBtn = new JPanel();
        delRowTxt = new JLabel();

        /*
         * DELETE ROW BUTTON
         */
        delRowTxt.setBackground(new Color(12, 12, 12));
        delRowTxt.setFont(new Font("Roboto Condensed", 1, 12));
        delRowTxt.setForeground(new Color(255, 255, 255));
        delRowTxt.setHorizontalAlignment(SwingConstants.CENTER);
        delRowTxt.setText("Delete selected row");
        delRowTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        delRowTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delRowTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delRowTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delRowTxtMouseExited(evt);
            }
        });

        GroupLayout delRowBtnLayout = new GroupLayout(delRowBtn);
        delRowBtn.setLayout(delRowBtnLayout);
        delRowBtnLayout.setHorizontalGroup(
            delRowBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(delRowTxt, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        delRowBtnLayout.setVerticalGroup(
            delRowBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(delRowTxt, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        delRowBtn.setBounds(400, 620, 130, 40);


        /*
         * ADD ROW BUTTON
         */
        addRowTxt.setBackground(new Color(12, 12, 12));
        addRowTxt.setFont(new Font("Roboto Condensed", 1, 12));
        addRowTxt.setForeground(new Color(255, 255, 255));
        addRowTxt.setHorizontalAlignment(SwingConstants.CENTER);
        addRowTxt.setText("Add row");
        addRowTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addRowTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRowTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addRowTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addRowTxtMouseExited(evt);
            }
        });

        GroupLayout addRowBtnLayout = new GroupLayout(addRowBtn);
        addRowBtn.setLayout(addRowBtnLayout);
        addRowBtnLayout.setHorizontalGroup(
            addRowBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(addRowTxt, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        addRowBtnLayout.setVerticalGroup(
            addRowBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(addRowTxt, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        addRowBtn.setBounds(250, 620, 130, 40);



        /*
         * SAVE DATA BUTTON
         */
        saveVaBtn.setBackground(new Color(12, 12, 12));
        saveVaTxt.setFont(new Font("Roboto Condensed", 1, 12));
        saveVaTxt.setForeground(new Color(255, 255, 255));
        saveVaTxt.setHorizontalAlignment(SwingConstants.CENTER);
        saveVaTxt.setText("Save data");
        saveVaTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveVaTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveVaTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveVaTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveVaTxtMouseExited(evt);
            }
        });

        GroupLayout saveVaBtnLayout = new GroupLayout(saveVaBtn);
        saveVaBtn.setLayout(saveVaBtnLayout);
        saveVaBtnLayout.setHorizontalGroup(
            saveVaBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(saveVaTxt, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        saveVaBtnLayout.setVerticalGroup(
            saveVaBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(saveVaTxt, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        saveVaBtn.setBounds(10, 620, 130, 40);


        jScrollPane1 = new JScrollPane();
        jScrollPane1.setBounds(0, 60, 1100, 550);
        txt = new TextFieldSearchOption();
        txt.setBounds(0, 0, 1100, 35);


        TableGUI.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name","CI"}
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableGUI);

        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyReleased(evt);
            }
        });

        addRowBtn.setBackground(new Color(12, 12, 12));
        delRowBtn.setBackground(new Color(12, 12, 12)); // FIX color bug

        add(saveVaBtn);
        add(addRowBtn);
        add(delRowBtn);
    }

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {
        if (txt.isSelected()) {
            int option = txt.getSelectedIndex();
            String text = "%"+txt.getText().trim()+"%";

            if(option == 0) {
                LoadData("where name like ?", text);
            }else if(option == 1) {
                LoadData("where ci like ?", text);
            }
            
        }
    }

    private void saveVaTxtMouseEntered(java.awt.event.MouseEvent evt) {
        saveVaBtn.setBackground(new Color(50, 50, 50)); // Hover effect opacity
    }
    private void saveVaTxtMouseExited(java.awt.event.MouseEvent evt) {
        saveVaBtn.setBackground(new Color(12, 12, 12));
    }
    private void saveVaTxtMouseClicked(java.awt.event.MouseEvent evt) {
        new insertAbsences(TableGUI);
    }



    private void addRowTxtMouseEntered(java.awt.event.MouseEvent evt) {
        addRowBtn.setBackground(new Color(50, 50, 50)); // Hover effect opacity
    }
    private void addRowTxtMouseExited(java.awt.event.MouseEvent evt) {
        addRowBtn.setBackground(new Color(12, 12, 12));
    }
    private void addRowTxtMouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel model = (DefaultTableModel) TableGUI.getModel();
        model.addRow(new Object[] {model.getRowCount() + 1, "", ""});
    }

    private void delRowTxtMouseEntered(java.awt.event.MouseEvent evt) {
        delRowBtn.setBackground(new Color(50, 50, 50)); // Hover effect opacity
    }
    private void delRowTxtMouseExited(java.awt.event.MouseEvent evt) {
        delRowBtn.setBackground(new Color(12, 12, 12));
    }
    private void delRowTxtMouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel model = (DefaultTableModel) TableGUI.getModel();
        model.removeRow(TableGUI.getSelectedRow());
    }
}