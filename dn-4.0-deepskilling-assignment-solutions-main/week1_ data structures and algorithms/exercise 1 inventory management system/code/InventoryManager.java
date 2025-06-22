import java.util.HashMap;
public class InventoryManager 
{
    private final HashMap<Integer, Product> inventory;

    public InventoryManager() 
    {
        inventory = new HashMap<>();
    }

    // Add new product
    public void addProduct(Product p) 
    {
        inventory.put(p.productId, p);
    }

    // Update existing product
    public void updateProduct(int id, int quantity, double price) 
    {
        Product p = inventory.get(id);
        if (p != null) 
        {
            p.quantity = quantity;
            p.price = price;
        } else 
        {
            System.out.println("Product not found.");
        }
    }

    // Delete existing product
    public void deleteProduct(int id) 
    {
        if (inventory.remove(id) == null) 
        {
            System.out.println("Product not found.");
        }
    }

    // Display current inventory
    public void displayInventory() 
    {
        if (inventory.isEmpty()) 
        {
            System.out.println("Inventory is empty.");
        } else 
        {
            for (Product p : inventory.values()) 
            {
                System.out.println(p);
            }
        }
    }
}
