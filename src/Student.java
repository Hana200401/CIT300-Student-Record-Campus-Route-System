public class Student {
    public int studentId;
    public String name;
    public String programme;
    public double marks;
    public Student next;

    public Student(int studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + name + 
               " | Programme: " + programme + " | Marks: " + marks;
    }
}