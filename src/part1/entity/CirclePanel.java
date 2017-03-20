package part1.entity;

import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel implements Indicator {
    private int state = -1;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Rectangle bound = g.getClipBounds();
        switch (state) {
            case 1:
                g.setColor(Color.GREEN);
                break;
            case 0:
                g.setColor(Color.RED);
                break;
            default:
                g.setColor(getBackground());
        }

        g.fillOval(0, 0, bound.width, bound.height);
    }

    @Override
    public int getIndicator() {
        return state;
    }

    @Override
    public void setIndicator(int state) {
        this.state = state;
        updateUI();
    }
}
