# CIT300 Project

A small Java project demonstrating common data structures in a student-services context.

## Structure

- `src/Student.java` - Student model
- `src/StudentLinkedList.java` - Linked list of students
- `src/ActionStack.java` - LIFO action history
- `src/ServiceQueue.java` - FIFO student service queue
- `src/BST.java` - Binary search tree keyed by student ID
- `src/StudentHashTable.java` - Student lookup table
- `src/CampusGraph.java` - Campus locations and breadth-first traversal
- `src/Main.java` - Runnable demonstration

## Compile and run

From the project root:

```text
javac -d out src/*.java
java -cp out Main
```

No external libraries are required. Java 8 or newer is sufficient.
