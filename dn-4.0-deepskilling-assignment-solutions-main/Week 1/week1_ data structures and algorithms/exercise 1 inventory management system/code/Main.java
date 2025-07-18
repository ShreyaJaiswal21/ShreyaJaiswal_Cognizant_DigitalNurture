public class Main 
{
    public static void main(String[] args) 
    {
        InventoryManager manager = new InventoryManager();

        Product p1 = new Product(55, "apple", 100, 120023.99);
        Product p2 = new Product(17, "pear", 960, 5687.99);
        Product p3 = new Product(34, "jackfruit", 406, 9699.32);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        System.out.println("Initial Inventory:");
        manager.displayInventory();

        System.out.println("\nUpdating product apple");
        manager.updateProduct(55, 120, 169874.49);
        manager.displayInventory();

        System.out.println("\nDeleting pear...");
        manager.deleteProduct(17);
        manager.displayInventory();
    }
}
