package Dashboard.form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Dashboard.Searchbar.textfield.SearchOptinEvent;
import Dashboard.Searchbar.textfield.SearchOption;
import Dashboard.Searchbar.textfield.TextFieldSearchOption;
import showAbsences.Table;

public class Form_2 extends JPanel {
    private JScrollPane jScrollPane1;
    private TextFieldSearchOption txt;
    private Table TableGUI;

    public Form_2(int index) {
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
        txt.addOption(new SearchOption("Type", new ImageIcon(getClass().getResource("../icon/searchByType.png"))));

        LoadData("");
    }

    private void LoadData(String where, Object... search) {
        try {
            DefaultTableModel model = (DefaultTableModel) TableGUI.getModel();
            model.setRowCount(0);

            PreparedStatement p = DB.DBConnection.getConnection().prepareStatement("select * from login " + where);

            for (int i = 0; i < search.length; i++) {
                p.setObject(i + 1, search[i]);
            }

            ResultSet result = p.executeQuery();

            while(result.next()) {
                String name = result.getString("name");
                String ci = result.getString("ci");
                String type = result.getString("type");

                model.addRow(new Object[] {TableGUI.getRowCount() + 1, name, ci, type});
            }

            result.close();
            p.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    

    private void initComponents(int index) {
        TableGUI = new Table();

        jScrollPane1 = new JScrollPane();
        jScrollPane1.setBounds(0, 56, 785, 482);
        txt = new TextFieldSearchOption();
        txt.setBounds(0, 0, 785, 34);


        TableGUI.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name","CI", "Type"}
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
    }

    private void txtKeyReleased(java.awt.event.KeyEvent evt) {
        if (txt.isSelected()) {
            int option = txt.getSelectedIndex();
            String text = "%"+txt.getText().trim()+"%";

            if(option == 0) {
                LoadData("where name like ?", text);
            }else if(option == 1) {
                LoadData("where ci like ?", text);
            }else if(option == 2) {
                LoadData("where type like ?", text);
            }
            
        }
    }
}