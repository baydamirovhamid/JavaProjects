import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

public class EShopSaleSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EShop eShop = new EShop();


        System.out.println("Enter product details (name, price) or type 'done' to finish:");

        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
            String[] productDetails = input.split(",");
            if (productDetails.length == 2) {
                String productName = productDetails[0].trim();
                double productPrice = Double.parseDouble(productDetails[1].trim());
                eShop.addProduct(productName, productPrice);
            } else {
                System.out.println("Invalid input. Please enter product details in the format: name, price");
            }
        }

        eShop.displayProducts();

        System.out.println("Enter the name of the product to add to the cart (or 'done' to finish):");
        while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
            Product selectedProduct = findProductByName(eShop, input);
            if (selectedProduct != null) {
                eShop.addToCart(selectedProduct);
            } else {
                System.out.println("Product not found.");
            }
        }

        eShop.displayCart();
        scanner.close();
    }

    public static Product findProductByName(EShop eShop, String productName) {
        for (Product product : eShop.getProducts()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}



