package hust.soict.dsai.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
        Container cp = getContentPane();
        addCommonComponents(cp);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Title:"));
        JTextField titleField = new JTextField(20);
        panel.add(titleField);

        panel.add(new JLabel("Cost:"));
        JTextField costField = new JTextField(20);
        panel.add(costField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            double cost = Double.parseDouble(costField.getText());
            store.addMedia(new Book(title, cost));
            JOptionPane.showMessageDialog(this, "Book added successfully");
        });
        cp.add(panel, BorderLayout.CENTER);
        cp.add(addButton, BorderLayout.SOUTH);
    }
}


