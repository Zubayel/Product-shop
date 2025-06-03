import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductView extends JFrame {
    public ProductView() {
        setTitle("Product List");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] columnNames = { "Name", "Price", "Quantity", "Total" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        List<Product> products = ProductRepository.getAllProducts();
        double allTotal = 0.0;

        for (Product product : products) {
            double total = product.getPrice() * product.getQuantity();
            allTotal += total;

            Object[] rowData = {
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                total
            };
            model.addRow(rowData);
        }

        Object[] totalRow = { "", "", "ALL TOTAL = " ,allTotal };
        model.addRow(totalRow);

        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        setVisible(true);

        JButton backButton = new JButton("Add Product");
        backButton.addActionListener(e -> dispose());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
