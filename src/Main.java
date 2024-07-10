import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);
        String filename = "products.txt";


        while (true) {
            System.out.println("\n--- Menu de Gerenciamento de Inventário ---");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Atualizar produto");
            System.out.println("4. Excluir produto");
            System.out.println("5. Salvar");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String name = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Preço unitário: ");
                    double unitPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consumir nova linha

                    manager.addProduct(new Product(name, quantity, unitPrice));
                    System.out.println("Produto adicionado.");
                    break;

                case 2:
                    System.out.println("Produtos no inventário:");
                    manager.listProducts();
                    break;

                case 3:
                    System.out.print("Nome do produto a ser atualizado: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Novo nome do produto: ");
                    String newName = scanner.nextLine();
                    System.out.print("Nova quantidade: ");
                    int newQuantity = scanner.nextInt();
                    System.out.print("Novo preço unitário: ");
                    double newUnitPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consumir nova linha

                    manager.updateProduct(oldName, new Product(newName, newQuantity, newUnitPrice));
                    System.out.println("Produto atualizado.");
                    break;

                case 4:
                    System.out.print("Nome do produto a ser excluído: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteProduct(deleteName);
                    System.out.println("Produto excluído.");
                    break;

                case 5:
                    manager.saveToFile(filename);
                    System.out.println("Produtos salvos no arquivo.");
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;


                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}