import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String FILE_NAME = "products.txt";
    private static List<Product> products = new ArrayList<>();

    static {
        loadProducts();
    }

    public static void addProduct(Product product) {
        products.add(product);
        saveProductToFile(product);
    }

    public static List<Product> getAllProducts() {
        return products;
    }

    private static void saveProductToFile(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(product.getName() + "," + product.getPrice() + "," + product.getQuantity());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadProducts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    int quantity = Integer.parseInt(parts[2]);
                    products.add(new Product(name, price, quantity));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
