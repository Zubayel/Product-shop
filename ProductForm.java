import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProductForm extends JFrame {
    private JTextField nameField, priceField, quantityField;
    private JButton submitButton, viewButton;

    public ProductForm() {
        setTitle("Product Entry Form");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Product Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        add(quantityField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            ProductRepository.addProduct(new Product(name, price, quantity));
            JOptionPane.showMessageDialog(this, "Product Added Successfully!");
        });
        add(submitButton);

        viewButton = new JButton("View Products");
        viewButton.addActionListener(new ProductFormViewButtonAction());
        add(viewButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
