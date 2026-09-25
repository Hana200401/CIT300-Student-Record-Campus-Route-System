import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CampusGraph {
    private final Map<String, List<String>> connections = new HashMap<>();

    public void addLocation(String location) {
        connections.putIfAbsent(location, new ArrayList<>());
    }

    public void connect(String first, String second) {
        addLocation(first);
        addLocation(second);
        connections.get(first).add(second);
        connections.get(second).add(first);
    }

    public List<String> breadthFirstSearch(String start) {
        List<String> visitedOrder = new ArrayList<>();
        if (!connections.containsKey(start)) {
            return visitedOrder;
        }

        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            visitedOrder.add(current);
            for (String neighbor : connections.get(current)) {
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return visitedOrder;
    }
}
