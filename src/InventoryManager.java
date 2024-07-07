import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class InventoryManager {
    private List<Product> products;

    public InventoryManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void listProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void updateProduct(String name, Product newProduct) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.setName(newProduct.getName());
                product.setQuantity(newProduct.getQuantity());
                product.setPrice(newProduct.getPrice());
                break;
            }
        }
    }

    public void deleteProduct(String name) {
        products.removeIf(product -> product.getName().equals(name));
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Product product : products) {
                writer.write(product.getName() + "," + product.getQuantity() + "," + product.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar produtos no arquivo: " + e.getMessage());
        }
    }

    public void lo


}
