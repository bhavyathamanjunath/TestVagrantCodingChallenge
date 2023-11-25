import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product {
    String name;
    double UPrice;
    int gstPercentage;
    int quantity;
    double totalGST;
    double totalPrice;

    Product(String name, double unitPrice, int gstPercentage, int quantity) {
        this.name = name;
        this.UPrice = unitPrice;
        this.gstPercentage = gstPercentage;
        this.quantity = quantity;

        
        this.totalGST = (unitPrice * gstPercentage / 100.0) * quantity;
        this.totalPrice = unitPrice * quantity;
        if (unitPrice >= 500) {
            this.totalPrice *= 0.95;
        }
    }
}

public class App {
    public static void main(String[] args) {
       
        List<Product> basket = new ArrayList<>();
        basket.add(new Product("Leather wallet", 1100, 18, 1));
        basket.add(new Product("Umbrella", 900, 12, 4));
        basket.add(new Product("Cigarette", 200, 28, 3));
        basket.add(new Product("Honey", 100, 0, 2));

        
        Product maxGSTProduct = Collections.max(basket, (a, b) -> Double.compare(a.totalGST, b.totalGST));

        
        double totalAmountToPay = basket.stream()
                .mapToDouble(product -> product.totalPrice + product.totalGST)
                .sum();

        
        System.out.println("Product with Maximum GST: " + maxGSTProduct.name + " with GST " + maxGSTProduct.totalGST);
        System.out.println("Total amount: " + totalAmountToPay);
    }
}
