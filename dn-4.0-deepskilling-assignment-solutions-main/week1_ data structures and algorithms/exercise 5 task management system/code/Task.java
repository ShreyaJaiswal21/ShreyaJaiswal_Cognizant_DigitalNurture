import java.util.Scanner;

public class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public void display() {
        System.out.println("Task_ID: " + taskId + ", Task_Name: " + taskName + ", Status: " + status);
    }

    // <--- Class for managing tasks -->
    static class TaskManager {
        private Task head = null;

        public void addTask(int id, String name, String status) {
            Task newTask = new Task(id, name, status);
            if (head == null) {
                head = newTask;
            } else {
                Task temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newTask;
            }
            System.out.println("Task added successfully");
        }

        public Task searchTask(int id) {
            Task temp = head;
            while (temp != null) {
                if (temp.taskId == id) {
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }

        public void deleteTask(int id) {
            if (head == null) {
                System.out.println("No tasks to delete");
                return;
            }

            if (head.taskId == id) {
                head = head.next;
                System.out.println("Task deleted");
                return;
            }

            Task prev = null, curr = head;
            while (curr != null && curr.taskId != id) {
                prev = curr;
                curr = curr.next;
            }

            if (curr != null) {
                prev.next = curr.next;
                System.out.println("Task deleted");
            } else {
                System.out.println("Task not found");
            }
        }

        public void displayTasks() {
            if (head == null) {
                System.out.println("No tasks to display");
                return;
            }

            Task temp = head;
            while (temp != null) {
                temp.display();
                temp = temp.next;
            }
        }
    }

    // <--- Main method --->
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                //Task addition
                case 1:
                    System.out.print("Enter Task ID:");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Task Name:");
                    String name = sc.nextLine();
                    System.out.print("Enter Task Status:");
                    String status = sc.nextLine();
                    manager.addTask(id, name, status);
                    break;

                    //Task search by ID
                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int sid = sc.nextInt();
                    Task found = manager.searchTask(sid);
                    if (found != null) {
                        System.out.println("Task found:");
                        found.display();
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                    //Task deletion
                case 3:
                    System.out.print("Enter Task ID to delete:");
                    int did = sc.nextInt();
                    manager.deleteTask(did);
                    break;

                    //Display all tasks
                case 4:
                    manager.displayTasks();
                    break;

                case 5:
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
