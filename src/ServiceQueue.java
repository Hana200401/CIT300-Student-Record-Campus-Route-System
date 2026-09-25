import java.util.ArrayDeque;
import java.util.Queue;

public class ServiceQueue {
    private final Queue<Student> students = new ArrayDeque<>();

    public void add(Student student) {
        students.offer(student);
    }

    public Student serveNext() {
        return students.poll();
    }

    public Student peek() {
        return students.peek();
    }

    public boolean isEmpty() {
        return students.isEmpty();
    }
}
