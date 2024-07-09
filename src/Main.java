import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        String filename = "products.txt";

        manager.loadFromFile(filename);

        while (true) {
            System.out.println("\n--- Menu Gerenciador ");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("5. Salvar e Sair");
            System.out.println("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Nome do produto: ");
                    String name = scanner.nextLine();
                    System.out.println("Quantidade: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Preço: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    manager.addProduct(new Product(name, quantity, price));
                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("Produtos no Inventário:");
                    manager.listProducts();
                    break;

                case 3:
                    System.out.println("Nome do produto a ser atualizado: ");
                    String oldName = scanner.nextLine();
                    System.out.println("Novo nome do produto: ");
                    String newName = scanner.nextLine();
                    System.out.println("Nova quantidade: ");
                    int newQuantity = scanner.nextInt();
                    System.out.println("Novo preço: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();

                    manager.updateProduct(oldName, new Product(newName, newQuantity, newPrice));
                    System.out.println("Produto atualizado com sucesso!");
                    break;

                case 4:
                    System.out.println("Nome do produto a ser excluido: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteProduct(deleteName);
                    System.out.println("Produto excluído.");
                    break;

                case 5:
                    manager.saveToFile(filename);
                    System.out.println("Produtos salvos no arquivo. Saindo. . .");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }
        }
    }
}
