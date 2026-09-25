

public class ActionStack {
    private String[] stack;
    private int top;
    private int capacity;

    public ActionStack(int capacity) {
        this.capacity = capacity;
        this.stack = new String[capacity];
        this.top = -1;
    }

    public void push(String action) {
        if (top == capacity - 1) {
            System.out.println("Stack overflow!");
            return;
        }
        stack[++top] = action;
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack[top--];
    }

    public String peek() {
        if (isEmpty()) return null;
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void displayRecentActions() {
        if (isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }
        System.out.println("\n===== Recent Actions (Latest First) =====");
        for (int i = top; i >= 0; i--) {
            System.out.println((top - i + 1) + ". " + stack[i]);
        }
    }
}

5. Save (Ctrl + S)

6. ServiceQueue.java-ஐ open செய்யுங்க

7. Ctrl + A → Delete

8. இதை paste செய்யுங்க:

public class ServiceQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    public ServiceQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(String request) {
        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = request;
        size++;
        System.out.println("Request added: " + request);
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        String request = queue[front];
        front = (front + 1) % capacity;
        size--;
        return request;
    }

    public String peek() {
        if (isEmpty()) return null;
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No service requests.");
            return;
        }
        System.out.println("\n===== Service Requests =====");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + queue[(front + i) % capacity]);
        }
    }
}

