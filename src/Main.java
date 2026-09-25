import java.util.Scanner;

public class Main {
    static StudentLinkedList studentList = new StudentLinkedList();
    static ActionStack actionStack = new ActionStack(100);
    static ServiceQueue serviceQueue = new ServiceQueue(100);
    static BST bst = new BST();
    static StudentHashTable hashTable = new StudentHashTable(100);
    static CampusGraph graph = new CampusGraph();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1: addStudent(); break;
                case 2: updateStudent(); break;
                case 3: deleteStudent(); break;
                case 4: studentList.displayAll(); break;
                case 5: addServiceRequest(); break;
                case 6: processServiceRequest(); break;
                case 7: actionStack.displayRecentActions(); break;
                case 8: bst.inorder(); break;
                case 9: searchStudentHashing(); break;
                case 10: addLocation(); break;
                case 11: removeLocation(); break;
                case 12: addConnection(); break;
                case 13: removeConnection(); break;
                case 14: graph.displayConnections(); break;
                case 15: traverseGraph(); break;
                case 16: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 16);
        sc.close();
    }

    static void printMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST/AVL");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS or DFS");
        System.out.println("16. Exit");
    }

    static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
            }
        }
    }

    static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double val = sc.nextDouble();
                sc.nextLine();
                return val;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
            }
        }
    }

    static void addStudent() {
        int id = getIntInput("Enter Student ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Programme: ");
        String prog = sc.nextLine();
        double marks = getDoubleInput("Enter Marks (0-100): ");
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks! Must be between 0 and 100.");
            return;
        }
        Student s = new Student(id, name, prog, marks);
        if (studentList.addStudent(s)) {
            bst.insert(s);
            hashTable.insert(s);
            actionStack.push("Added student ID " + id);
        }
    }

    static void updateStudent() {
        int id = getIntInput("Enter Student ID to update: ");
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Programme: ");
        String prog = sc.nextLine();
        double marks = getDoubleInput("Enter New Marks (0-100): ");
        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks!");
            return;
        }
        if (studentList.updateStudent(id, name, prog, marks)) {
            actionStack.push("Updated student ID " + id);
        }
    }

    static void deleteStudent() {
        int id = getIntInput("Enter Student ID to delete: ");
        if (studentList.deleteStudent(id)) {
            actionStack.push("Deleted student ID " + id);
        }
    }

    static void addServiceRequest() {
        System.out.print("Enter service request: ");
        String req = sc.nextLine();
        serviceQueue.enqueue(req);
        actionStack.push("Added service request");
    }

    static void processServiceRequest() {
        String req = serviceQueue.dequeue();
        if (req != null) {
            System.out.println("Processed: " + req);
            actionStack.push("Processed service request");
        }
    }

    static void searchStudentHashing() {
        int id = getIntInput("Enter Student ID to search: ");
        Student s = hashTable.search(id);
        if (s == null) {
            System.out.println("Student not found!");
        } else {
            System.out.println("Found: " + s);
        }
    }

    static void addLocation() {
        System.out.print("Enter location name: ");
        String loc = sc.nextLine();
        graph.addLocation(loc);
        actionStack.push("Added location " + loc);
    }

    static void removeLocation() {
        System.out.print("Enter location name: ");
        String loc = sc.nextLine();
        graph.removeLocation(loc);
        actionStack.push("Removed location " + loc);
    }

    static void addConnection() {
        System.out.print("Enter location 1: ");
        String loc1 = sc.nextLine();
        System.out.print("Enter location 2: ");
        String loc2 = sc.nextLine();
        graph.addConnection(loc1, loc2);
    }

    static void removeConnection() {
        System.out.print("Enter location 1: ");
        String loc1 = sc.nextLine();
        System.out.print("Enter location 2: ");
        String loc2 = sc.nextLine();
        graph.removeConnection(loc1, loc2);
    }

    static void traverseGraph() {
        System.out.print("Enter start location: ");
        String start = sc.nextLine();
        System.out.println("1. BFS");
        System.out.println("2. DFS");
        int opt = getIntInput("Choose: ");
        if (opt == 1) graph.BFS(start);
        else if (opt == 2) graph.DFS(start);
        else System.out.println("Invalid option!");
    }
}