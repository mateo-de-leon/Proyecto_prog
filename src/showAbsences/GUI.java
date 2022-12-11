package showAbsences;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame {
    private JScrollPane jScrollPane1;
    private Table TableGUI;

    /**
     * Simple object to create the GUI to view the absences
     */
    public Image getIconImage() {
        return Toolkit.getDefaultToolkit().getImage(GUI.class.getResource("recurs/favicon.png"));
    }
    public GUI() {


        setDefaultCloseOperation(3); // Exit on close
        setTitle("Absences");
        setIconImage(getIconImage());

        initComponents();
        getContentPane().setBackground(new Color(30, 30, 30));
        TableGUI.fixTable(jScrollPane1);
        TableGUI.setColumnAlignment(0, JLabel.CENTER);
        TableGUI.setCellAlignment(0, JLabel.CENTER);
        TableGUI.setColumnAlignment(2, JLabel.CENTER);
        TableGUI.setCellAlignment(2, JLabel.CENTER);
        TableGUI.setColumnAlignment(4, JLabel.RIGHT);
        TableGUI.setCellAlignment(4, JLabel.RIGHT);
        TableGUI.setColumnWidth(0, 50);
        TableGUI.setColumnWidth(2, 100);
        DefaultTableModel mode = (DefaultTableModel) TableGUI.getModel();
        for (int i = 1; i <= 80; i++) {
            mode.addRow(new Object[]{i, "Mateo De León", "2°IC 2°IA", "11/12/2022 13:00", "Medical License"});
        }
    }

    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        TableGUI = new Table();

        TableGUI.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Teacher", "Groups", "Date", "Reason"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableGUI);

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1189, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }
}
