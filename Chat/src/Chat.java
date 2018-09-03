import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {

    public Chat() {
        init();
    }

    public static void main(String[] args) {
        Chat chat = new Chat();

    }

    private void init() {
        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(50, 50, 400, 400);
        setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(30, 10, 320, 300);
        textArea.setEditable(false);
        add(textArea);

        JTextField textField = new JTextField();
        textField.setBounds(30, 320, 200, 30);
        add(textField);

        JButton button = new JButton("Send");
        button.setBounds(250, 320, 100, 30);
        add(button);

        setVisible(true);

        ActionListener listener= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                textArea.append(text + "\n");
                textField.setText("");
            }
        };
        button.addActionListener(listener);
        textField.addActionListener(listener);
    }
}
