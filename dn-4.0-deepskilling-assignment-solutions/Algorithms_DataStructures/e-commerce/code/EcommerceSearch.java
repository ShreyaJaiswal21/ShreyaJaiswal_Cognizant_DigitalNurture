import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) 
    {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() 
    {
        return "Product_ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

public class EcommerceSearch 
{

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search 
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(targetName);

            if (compare == 0)
                return products[mid];
            else if (compare < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        // Sample product data
        Product[] products = {
            new Product(203, "brush", "Lifestyle"),
            new Product(204, "iphone", "Electronics"),
            new Product(205, "helmet", "safety products"),
            new Product(210, "study table", "furniture"),
            new Product(211, "rope", "home appliances")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product to search: ");
        String searchName = sc.nextLine();

        // Linear Search
        Product resultLinear = linearSearch(products, searchName);
        if (resultLinear != null) {
            System.out.println("\n Product found using Linear Search:");
            System.out.println(resultLinear);
        } else {
            System.out.println("\nProduct not found using Linear Search.");
        }

        // Sort the array before Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search
        Product resultBinary = binarySearch(products, searchName);
        if (resultBinary != null) {
            System.out.println("\nProduct found using Binary Search:");
            System.out.println(resultBinary);
        } 
        else 
        {
            System.out.println("\nProduct not found using Binary Search.");
        }

        sc.close();
    }
}
