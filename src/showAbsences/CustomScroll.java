package showAbsences;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

public class CustomScroll extends JScrollBar {

    public CustomScroll() {
        setUI(new ScrollDesign());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(new Color(30, 30, 30));
    }
}
