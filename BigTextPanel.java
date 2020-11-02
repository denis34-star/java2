package sample;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class BigTextPanel extends JPanel {
    private JTextArea textArea;

    BigTextPanel() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);

        Border line = BorderFactory.createLineBorder(Color.white);
        Border empty = new EmptyBorder(10, 10, 10, 10);
        CompoundBorder border = new CompoundBorder(line, empty);
        textArea.setBorder(border);

        JScrollPane jScrollPane = new JScrollPane(textArea);
        add(jScrollPane, BorderLayout.CENTER);
    }

    JTextArea getTextArea() {
        return textArea;
    }

}
