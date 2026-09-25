public class StudentLinkedList {
    private static class Node {
        private final Student student;
        private Node next;

        private Node(Student student) {
            this.student = student;
        }
    }

    private Node head;

    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Student findById(int id) {
        Node current = head;
        while (current != null) {
            if (current.student.getId() == id) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    public boolean removeById(int id) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (current.student.getId() == id) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void printAll() {
        Node current = head;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }
}
