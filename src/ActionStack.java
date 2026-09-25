import java.util.ArrayDeque;
import java.util.Deque;

public class ActionStack {
    private final Deque<String> actions = new ArrayDeque<>();

    public void push(String action) {
        actions.push(action);
    }

    public String pop() {
        return actions.isEmpty() ? null : actions.pop();
    }

    public String peek() {
        return actions.peek();
    }

    public boolean isEmpty() {
        return actions.isEmpty();
    }
}
