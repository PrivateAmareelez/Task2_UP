package part2.action;

import part2.gui.MainDialog;

import java.awt.*;

public class Run {
    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();
        dialog.setPreferredSize(new Dimension(400, 300));
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
