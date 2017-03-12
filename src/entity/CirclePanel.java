package entity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CirclePanel extends JPanel implements Indicator {
    private int state = -1;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Rectangle bound = g.getClipBounds();
        Ellipse2D circle = new Ellipse2D.Double(bound.getCenterX(), bound.getCenterY(), bound.getWidth(), bound.getHeight());
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

        g.fillOval(0, 0, bound.width - 1, bound.height - 1);
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
