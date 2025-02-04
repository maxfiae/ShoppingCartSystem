public class Product {
    private final String name;      // Name des Produkts
    private final double price;     // Einzelpreis des Produkts
    private int quantity;           // Anzahl der Produkte im Warenkorb

    // Konstruktor zum Erstellen eines Produkts mit Name, Preis und Menge
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    // Gibt den Namen des Produkts zurück
    public String getName() {
        return name;
    }

    // Erhöht die Menge, falls ein bestehendes Produkt erneut hinzugefügt wird
    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    // Verringert die Menge des Produkts (wird für das Entfernen genutzt)
    public void reduceQuantity(int amount) {
        if (amount >= quantity) {
            quantity = 0; // Falls mehr entfernt wird als vorhanden, setzen wir die Menge auf 0
        } else {
            quantity -= amount;
        }
    }

    // Gibt die aktuelle Menge zurück
    public int getQuantity() {
        return quantity;
    }

    // Berechnet den Gesamtpreis des Produkts
    public double getTotalPrice() {
        return price * quantity;
    }

    // Gibt eine formatierte String-Darstellung des Produkts zurück
    public String toString() {
        return name + " | Price: €" + String.format("%.2f", price) + " | Quantity: " + quantity +
                " | Total: €" + String.format("%.2f", getTotalPrice());
    }
}
