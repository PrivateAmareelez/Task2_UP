package part1.action;

import part1.gui.MainDialog;

public class Run {
    public static void main(String[] args) {
        MainDialog dialog = new MainDialog();
        dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
