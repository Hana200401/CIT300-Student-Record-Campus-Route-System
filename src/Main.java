public class Main {
    public static void main(String[] args) {
        Student ada = new Student(1001, "Ada Lovelace", "Computer Science");
        Student alan = new Student(1002, "Alan Turing", "Information Technology");
        Student grace = new Student(1003, "Grace Hopper", "Software Engineering");

        StudentLinkedList studentList = new StudentLinkedList();
        studentList.add(ada);
        studentList.add(alan);
        studentList.add(grace);
        System.out.println("Students in linked list:");
        studentList.printAll();

        ActionStack actionStack = new ActionStack();
        actionStack.push("Register course");
        actionStack.push("Submit assignment");
        System.out.println("Last action: " + actionStack.pop());

        ServiceQueue serviceQueue = new ServiceQueue();
        serviceQueue.add(ada);
        serviceQueue.add(alan);
        System.out.println("Next student for service: " + serviceQueue.serveNext());

        BST studentTree = new BST();
        studentTree.insert(alan);
        studentTree.insert(ada);
        studentTree.insert(grace);
        System.out.println("Tree search: " + studentTree.search(1003));

        StudentHashTable studentTable = new StudentHashTable();
        studentTable.put(ada);
        studentTable.put(alan);
        System.out.println("Hash table contains 1002: " + studentTable.contains(1002));

        CampusGraph campus = new CampusGraph();
        campus.connect("Library", "Student Center");
        campus.connect("Student Center", "Science Building");
        campus.connect("Library", "Administration");
        System.out.println("Campus traversal: " + campus.breadthFirstSearch("Library"));
    }
}
