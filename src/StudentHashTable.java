public class StudentHashTable {
    private Student[] table;
    private int capacity;

    public StudentHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Student[capacity];
    }

    private int hashFunction(int id) {
        return id % capacity;
    }

    public void insert(Student s) {
        int index = hashFunction(s.studentId);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index].studentId == s.studentId) {
                System.out.println("Duplicate ID in Hash Table!");
                return;
            }
            index = (index + 1) % capacity;
            if (index == startIndex) {
                System.out.println("Hash table is full!");
                return;
            }
        }
        table[index] = s;
    }

    public Student search(int id) {
        int index = hashFunction(id);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index].studentId == id) {
                return table[index];
            }
            index = (index + 1) % capacity;
            if (index == startIndex) break;
        }
        return null;
    }

    public boolean delete(int id) {
        int index = hashFunction(id);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index].studentId == id) {
                table[index] = null;
                return true;
            }
            index = (index + 1) % capacity;
            if (index == startIndex) break;
        }
        return false;
    }
}