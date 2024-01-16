import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class EShop {
    public List<Product> products = new ArrayList<>();
    public ShoppingCart cart = new ShoppingCart();

    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
        products.add(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void addToCart(Product product) {
        cart.addItem(product);
        System.out.println("Added to cart: " + product.getName());
    }

    public void displayCart() {
        List<Product> cartItems = cart.getItems();
        System.out.println("Shopping Cart:");
        for (Product product : cartItems) {
            System.out.println(product);
        }
        System.out.println("Total: $" + cart.calculateTotal());
    }
    public void saveItemsToFile() {

        String directoryPath = "C:\\Users\\99470\\Desktop\\SaleSystem";
        String fileName = "products.txt";
        String filePath = Paths.get(directoryPath, fileName).toString();

        try {
            Files.createDirectories(Paths.get(directoryPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            Iterator n = this.products.iterator();

            while (n.hasNext()) {
                Product products = (Product) n.next();

                try {
                    writer.write("Product adi: " + products.name + ",\nQiymeti: " + products.price);
                } catch (IOException m) {
                    System.out.println("Error bas verdi: " + m.getMessage());
                }
            }

            writer.close();
        } catch (IOException k) {
            System.out.println("Error bas verdi: " + k.getMessage());
        }
    }
}