import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class InventoryManager {
    private List<Product> products;
    private List<Sale> sales;

    public InventoryManager() {
        this.products = new ArrayList<>();
        this.sales = new ArrayList<>();
    }

    public void registerSale(String productName, int quantitySold) {
        Product product = findProductByName(productName);
        if (product != null && product.getQuantity() >= quantitySold) {
            product.setQuantity(product.getQuantity() - quantitySold);

            Sale sale = new Sale(product, quantitySold,LocalDate.now());
            sales.add(sale);

            System.out.println("Venda registrada com sucesso.");
        } else {
            System.out.println("Produto não encontrado ou estoque insuficiente para realizar a venda.");
        }
    }

    private Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }



    public void generateSalesReport() {
        if (sales.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            System.out.println("Relatório de vendas.");
            for (Sale sale : sales) {
                System.out.println("Data: " + sale.getDate());
                System.out.println("Produto: " + sale.getProduct().getName());
                System.out.println("Quantidade vendida: " + sale.getQuantitySold());
                System.out.println("--------------------");
            }
        }
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
                product.setUnitPrice(newProduct.getUnitPrice());
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
                writer.write(product.getName() + "," + product.getQuantity() + "," + product.getUnitPrice());
                writer.newLine();
            }
            System.out.println("Produtos salvos no arquivo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar produtos no arquivo: " + e.getMessage());
        }
    }


    public void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Arquivo " + filename + " criado.");
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int quantity = Integer.parseInt(parts[1]);
                    double unitPrice = Double.parseDouble(parts[2]);
                    products.add(new Product(name, quantity, unitPrice));
                }
            }
            System.out.println("Produtos carregados do arquivo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao carregar produtos do arquivo: " + e.getMessage());
        }
    }
}