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

            }


        }


    }
}
