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