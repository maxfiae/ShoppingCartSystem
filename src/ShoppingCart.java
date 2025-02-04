import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> products = new ArrayList<>();   // Liste der Produkte im Warenkorb

    // Fügt ein Produkt zum Warenkorb hinzu (oder erhöht die Menge, falls es bereits existiert)
    public void addProduct(Product product) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(product.getName())) {  // Falls Produkt bereits vorhanden
                p.increaseQuantity(product.getQuantity());  // Menge erhöhen
                return;
            }
        }
        products.add(product);  // Falls nicht vorhanden, neues Produkt hinzufügen
    }

    // Entfernt eine bestimmte Menge eines Produkts oder löscht es ganz, falls die Menge 0 erreicht
    public void removeProduct(String productName, int quantityToRemove) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                p.reduceQuantity(quantityToRemove);

                if (p.getQuantity() == 0) {     // Falls das Produkt keine Menge mehr hat, löschen
                    products.remove(p);
                    System.out.println(productName + " completely removed from cart.");
                } else {
                    System.out.println("Removed " + quantityToRemove + "x " + productName);
                }
                return;
            }
        }
        System.out.println("Product not found in cart.");   // Falls Produkt nicht existiert
    }

    // Berechnet den Gesamtpreis des Warenkorbs
    public double getTotalPrice() {
        double total = 0;
        for (Product p : products) {
            total += p.getTotalPrice();
        }
        return total;
    }

    // Gibt den Warenkorb aus
    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("\nShopping Cart: ");
            for (Product p : products) {
                if (p instanceof DiscountedProduct) {
                    System.out.println(p.getName() + " (Discounted) | Price: €" + String.format("%.2f", p.getTotalPrice()));
                } else {
                    System.out.println(p);
                }
            }
            System.out.println("Total Price: €" + String.format("%.2f", getTotalPrice()));
        }
    }
}
