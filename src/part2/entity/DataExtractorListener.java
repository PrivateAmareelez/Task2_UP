package part2.entity;

import part2.action.TextExtractor;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.util.List;

public class DataExtractorListener implements DocumentListener {
    private JList<String> outputStorage;
    private TextExtractor extractor;

    public DataExtractorListener(TextExtractor textExtractor, JList<String> listDates) {
        outputStorage = listDates;
        extractor = textExtractor;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        extractText(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        extractText(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        extractText(e);
    }

    private void extractText(DocumentEvent e) {
        try {
            List<String> data = extractor.extract(e.getDocument().getText(0, e.getDocument().getLength()));

            DefaultListModel<String> listModel = (DefaultListModel<String>) outputStorage.getModel();
            listModel.removeAllElements();
            for (String s : data) {
                listModel.addElement(s);
            }
            outputStorage.updateUI();
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }
}
