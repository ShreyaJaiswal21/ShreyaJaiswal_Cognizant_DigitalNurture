import java.util.Scanner;
public class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee_ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
    }

    // <---Employee Management System Logic--->
    static class EmployeeManager {
        private Employee[] employees;
        private int size;

        public EmployeeManager(int capacity) {
            employees = new Employee[capacity];
            size = 0;
        }

        public void addEmployee(Employee emp) {
            if (size < employees.length) {
                employees[size++] = emp;
                System.out.println("Employee added");
            } else {
                System.out.println("Array is full");
            }
        }

        public Employee searchEmployee(int id) {
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == id) {
                    return employees[i];
                }
            }
            return null;
        }

        public void deleteEmployee(int id) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (employees[i].employeeId == id) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                for (int i = index; i < size - 1; i++) {
                    employees[i] = employees[i + 1];
                }
                employees[--size] = null;
                System.out.println("Employee deleted");
            } else {
                System.out.println("Employee not present in database");
            }
        }

        public void displayAllEmployees() {
            if (size == 0) {
                System.out.println("Record is empty");
                return;
            }
            for (int i = 0; i < size; i++) {
                employees[i].display();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager(100); // max 100 employees

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            //switch case to handle user input and perform add,search,traverse,delete operations
            switch (choice) {

                //Employee addition
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Position: ");
                    String position = sc.next();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    Employee emp = new Employee(id, name, position, salary);
                    manager.addEmployee(emp);
                    break;


                    //Employee search
                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    Employee found = manager.searchEmployee(searchId);
                    if (found != null) {
                        System.out.println("Employee found:");
                        found.display();
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                    //Employee deletion
                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteEmployee(deleteId);
                    break;


                    //Display all employees
                case 4:
                    manager.displayAllEmployees();
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
