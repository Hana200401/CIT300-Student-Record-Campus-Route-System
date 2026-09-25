public class BST {
    class Node {
        Student student;
        Node left, right;

        Node(Student s) {
            this.student = s;
            left = right = null;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    public void insert(Student s) {
        root = insertRec(root, s);
    }

    private Node insertRec(Node root, Student s) {
        if (root == null) {
            root = new Node(s);
            return root;
        }
        if (s.studentId < root.student.studentId) {
            root.left = insertRec(root.left, s);
        } else if (s.studentId > root.student.studentId) {
            root.right = insertRec(root.right, s);
        }
        return root;
    }

    public Student search(int id) {
        return searchRec(root, id);
    }

    private Student searchRec(Node root, int id) {
        if (root == null || root.student.studentId == id) {
            return root == null ? null : root.student;
        }
        if (id < root.student.studentId) {
            return searchRec(root.left, id);
        }
        return searchRec(root.right, id);
    }

    public void inorder() {
        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }
        System.out.println("\n===== Students in BST (Sorted by ID) =====");
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.student);
            inorderRec(root.right);
        }
    }
}