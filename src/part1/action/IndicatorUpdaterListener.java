package part1.action;

import part1.entity.Indicator;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class IndicatorUpdaterListener implements DocumentListener {
    private TextProcessor processor;
    private Indicator indicator;

    public IndicatorUpdaterListener(TextProcessor proc, Indicator indicator) {
        processor = proc;
        this.indicator = indicator;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkText(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkText(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkText(e);
    }

    private void checkText(DocumentEvent e) {
        try {
            String s = e.getDocument().getText(0, e.getDocument().getLength());
            if (s.isEmpty()) {
                indicator.setIndicator(-1);
            } else if (processor.check(s)) {
                indicator.setIndicator(1);
            } else {
                indicator.setIndicator(0);
            }
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }
}
