public class StudentLinkedList {
    private Student head;

    public StudentLinkedList() {
        head = null;
    }

    public boolean addStudent(Student s) {
        if (searchStudent(s.studentId) != null) {
            System.out.println("Error: Student ID " + s.studentId + " already exists!");
            return false;
        }
        if (head == null) {
            head = s;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = s;
        }
        System.out.println("Student added successfully!");
        return true;
    }

    public Student searchStudent(int id) {
        Student current = head;
        while (current != null) {
            if (current.studentId == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean updateStudent(int id, String name, String programme, double marks) {
        Student s = searchStudent(id);
        if (s == null) {
            System.out.println("Error: Student ID " + id + " not found!");
            return false;
        }
        s.name = name;
        s.programme = programme;
        s.marks = marks;
        System.out.println("Student updated successfully!");
        return true;
    }

    public boolean deleteStudent(int id) {
        if (head == null) {
            System.out.println("Error: List is empty!");
            return false;
        }
        if (head.studentId == id) {
            head = head.next;
            System.out.println("Student deleted successfully!");
            return true;
        }
        Student current = head;
        while (current.next != null && current.next.studentId != id) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Error: Student ID " + id + " not found!");
            return false;
        }
        current.next = current.next.next;
        System.out.println("Student deleted successfully!");
        return true;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n===== All Student Records =====");
        Student current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public Student getHead() {
        return head;
    }
}