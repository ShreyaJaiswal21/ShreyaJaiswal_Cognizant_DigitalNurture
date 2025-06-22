class CustomerOrder {
    int orderId;
    String customerName;
    double totalPrice;

    public CustomerOrder(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order_ID: " + orderId + ", Customer: " + customerName + ", Total:" + totalPrice;
    }
}

public class Order {

    // Bubble Sort (Descending order of totalPrice)
    public static void bubbleSort(CustomerOrder[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice < orders[j + 1].totalPrice) {
                    CustomerOrder temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Quick Sort (Descending order of totalPrice)
    public static void quickSort(CustomerOrder[] orders, int low, int high) {
        if (low < high) {
            int p = partition(orders, low, high);
            quickSort(orders, low, p - 1);
            quickSort(orders, p + 1, high);
        }
    }

    private static int partition(CustomerOrder[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice > pivot) {
                i++;
                CustomerOrder temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        CustomerOrder temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void displayOrders(CustomerOrder[] orders, String title) {
        System.out.println("\n" + title);
        for (CustomerOrder order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        CustomerOrder[] orders = {
            new CustomerOrder(101, "Eva", 1980.0),
            new CustomerOrder(102, "robin", 6580.5),
            new CustomerOrder(103, "ram", 5700.0),
            new CustomerOrder(104, "rohit", 1600.0),
            new CustomerOrder(105, "tarun", 2000.0)
        };

        // Clone arrays so sorting doesn't interfere
        CustomerOrder[] bubbleSorted = orders.clone();
        CustomerOrder[] quickSorted = orders.clone();

        // Bubble Sort
        bubbleSort(bubbleSorted);
        displayOrders(bubbleSorted, "Sorted by Bubble Sort ");

        // Quick Sort
        quickSort(quickSorted, 0, quickSorted.length - 1);
        displayOrders(quickSorted, "Sorted by Quick Sort");
    }
}
