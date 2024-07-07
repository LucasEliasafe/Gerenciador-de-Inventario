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


        }


    }
}
