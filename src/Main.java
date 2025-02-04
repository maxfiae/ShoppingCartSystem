import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menüoptionen für den Benutzer
            System.out.println("\n1. Add Product\n2. Add Discounted Product\n3. Show Cart\n4. Remove Product\n5. Exit");
            System.out.println("Choose an option: ");
            int choice = getIntInput(scanner);

            if (choice == 1) {
                System.out.println("Enter product name: ");
                String name = scanner.nextLine();
                System.out.println("Enter price: ");
                double price = getDoubleInput(scanner);
                System.out.println("Enter quantity: ");
                int quantity = getIntInput(scanner);
                cart.addProduct(new Product(name, price, quantity));

            } else if (choice == 2) {
                System.out.println("Enter product name: ");
                String name = scanner.nextLine();
                System.out.println("Enter price: ");
                double price = getDoubleInput(scanner);
                System.out.println("Enter quantity: ");
                int quantity = getIntInput(scanner);
                System.out.println("Enter discount percentage: ");
                double discount = getDoubleInput(scanner);
                cart.addProduct(new DiscountedProduct(name, price, quantity, discount));

            } else if (choice == 3) {
                cart.displayCart();

            } else if (choice == 4) {
                System.out.println("Enter product name to remove: ");
                String name = scanner.nextLine();
                System.out.println("Enter quantity to remove: ");
                int quantity = getIntInput(scanner);
                cart.removeProduct(name, quantity);

            } else if (choice == 5) {
                System.out.println("Exiting... Thank you!");
                break;

            } else {
                System.out.println("Invalid option. Please enter a number between 1 and 5.");
            }
        }
    }

    // Error Handling für double-Zahlen (Komma -> Punkt umwandeln)
    public static double getDoubleInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().replace(",", ".");
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number: ");
            }
        }
    }

    // Error Handling für int-Zahlen
    public static int getIntInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim()); // Leerzeichen wird entfernt
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number: ");
            }
        }
    }
}