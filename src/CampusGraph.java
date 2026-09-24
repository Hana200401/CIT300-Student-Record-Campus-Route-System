import java.util.*;

public class CampusGraph {
    private Map<String, List<String>> adjacencyList;

    public CampusGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addLocation(String location) {
        if (adjacencyList.containsKey(location)) {
            System.out.println("Location already exists!");
            return;
        }
        adjacencyList.put(location, new ArrayList<>());
        System.out.println("Location added: " + location);
    }

    public void removeLocation(String location) {
        if (!adjacencyList.containsKey(location)) {
            System.out.println("Location not found!");
            return;
        }
        for (String loc : adjacencyList.keySet()) {
            adjacencyList.get(loc).remove(location);
        }
        adjacencyList.remove(location);
        System.out.println("Location removed: " + location);
    }

    public void addConnection(String loc1, String loc2) {
        if (!adjacencyList.containsKey(loc1) || !adjacencyList.containsKey(loc2)) {
            System.out.println("Error: One or both locations do not exist!");
            return;
        }
        if (loc1.equals(loc2)) {
            System.out.println("Error: Cannot connect a location to itself!");
            return;
        }
        if (adjacencyList.get(loc1).contains(loc2)) {
            System.out.println("Connection already exists!");
            return;
        }
        adjacencyList.get(loc1).add(loc2);
        adjacencyList.get(loc2).add(loc1);
        System.out.println("Connection added: " + loc1 + " <--> " + loc2);
    }

    public void removeConnection(String loc1, String loc2) {
        if (!adjacencyList.containsKey(loc1) || !adjacencyList.containsKey(loc2)) {
            System.out.println("Error: One or both locations do not exist!");
            return;
        }
        if (!adjacencyList.get(loc1).contains(loc2)) {
            System.out.println("Connection does not exist!");
            return;
        }
        adjacencyList.get(loc1).remove(loc2);
        adjacencyList.get(loc2).remove(loc1);
        System.out.println("Connection removed: " + loc1 + " <--> " + loc2);
    }

    public void displayConnections() {
        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations.");
            return;
        }
        System.out.println("\n===== Campus Network =====");
        for (String loc : adjacencyList.keySet()) {
            System.out.println(loc + " -> " + adjacencyList.get(loc));
        }
    }

    public void BFS(String start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Start location not found!");
            return;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void DFS(String start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Start location not found!");
            return;
        }
        Set<String> visited = new HashSet<>();
        System.out.print("DFS Traversal: ");
        DFSUtil(start, visited);
        System.out.println();
    }

    private void DFSUtil(String current, Set<String> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (String neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }
}