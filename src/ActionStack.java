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
