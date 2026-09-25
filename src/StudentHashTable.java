import java.util.HashMap;
import java.util.Map;

public class StudentHashTable {
    private final Map<Integer, Student> students = new HashMap<>();

    public void put(Student student) {
        students.put(student.getId(), student);
    }

    public Student get(int id) {
        return students.get(id);
    }

    public Student remove(int id) {
        return students.remove(id);
    }

    public boolean contains(int id) {
        return students.containsKey(id);
    }

    public int size() {
        return students.size();
    }
}
