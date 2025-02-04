public class DiscountedProduct extends Product {
    private double discountRate; // Rabatt in Prozent

    // Konstruktor für rabattierte Produkte mit Menge
    public DiscountedProduct(String name, double price, int quantity, double discountRate) {
        super(name, price, quantity); // Ruft den Konstruktor der Elternklasse auf
        this.discountRate = discountRate;
    }

    // Berechnet den rabattierten Gesamtpreis
    @Override
    public double getTotalPrice() {
        return super.getTotalPrice() * (1 - discountRate / 100); // Rabatt wird abgezogen
    }
}
