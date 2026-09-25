public class BST {
    private static class Node {
        private final Student student;
        private Node left;
        private Node right;

        private Node(Student student) {
            this.student = student;
        }
    }

    private Node root;

    public void insert(Student student) {
        root = insert(root, student);
    }

    private Node insert(Node node, Student student) {
        if (node == null) {
            return new Node(student);
        }
        if (student.getId() < node.student.getId()) {
            node.left = insert(node.left, student);
        } else if (student.getId() > node.student.getId()) {
            node.right = insert(node.right, student);
        }
        return node;
    }

    public Student search(int id) {
        Node current = root;
        while (current != null) {
            if (id == current.student.getId()) {
                return current.student;
            }
            current = id < current.student.getId() ? current.left : current.right;
        }
        return null;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.student);
        printInOrder(node.right);
    }
}
