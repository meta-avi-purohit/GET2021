import java.util.*;

interface UndirectedGraph {
	boolean isConnected();

	void reacheable(int a);

	void mst();

	void shortestPath(int a, int b);
}

class Edge implements Comparable<Edge> {
	int v;
	int w;

	public Edge() {
	}

	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}

	public int getDestination() {
		return v;
	}

	public int getWeight() {
		return w;
	}

	public String toString() {
		return "" + v;
	}

	@Override
	public int compareTo(Edge edge) {
		return this.w - edge.w;
	}
}

public class Graph implements UndirectedGraph {
	int vertices;
	List<Edge>[] adjacencylist;
	Set<Integer> reachable = new HashSet<Integer>();
	int dist[];
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	Set<Integer> settled = new HashSet<Integer>();

	Graph(int vertices) {
		this.vertices = vertices;
		adjacencylist = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjacencylist[i] = new ArrayList<>();
		}
		this.dist = new int[vertices];
	}

	/*
	 * Function to add Edge in Graph
	 */
	public void addEgde(int source, int destination, int weight) {
		adjacencylist[source].add(new Edge(destination, weight));
		adjacencylist[destination].add(new Edge(source, weight));
	}

	public String toString() {
		String result = "";
		for (int i = 0; i < adjacencylist.length; i++)
			result += i + "->" + adjacencylist[i] + "\n";
		return result;
	}

	/*
	 * DFS Algorithm
	 */
	public boolean DFS(int s) {
		int[] visited = new int[vertices];
		for (int i = 0; i < vertices; i++)
			visited[i] = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(s);

		while (stack.empty() == false) {
			s = stack.peek();
			stack.pop();
			if (visited[s] == 0) {
				visited[s] = 1;
			}
			Iterator<Edge> itr = adjacencylist[s].iterator();

			while (itr.hasNext()) {
				Edge v = itr.next();
				if (visited[v.getDestination()] == 0)
					stack.push(v.v);
			}

		}
		if (stack.empty()) {
			return true;
		}
		return false;
	}

	/*
	 * checks if a given graph is conneted or not
	 */
	@Override
	public boolean isConnected() {
		boolean check = DFS(0);
		if (check == true) {
			return true;
		}
		return false;
	}

	/*
	 * Function uses DFS for checking reachable nodes
	 */
	@Override
	public void reacheable(int a) {
		int[] visited = new int[vertices];
		for (int i = 0; i < vertices; i++)
			visited[i] = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(a);

		while (stack.empty() == false) {
			int s = stack.peek();
			stack.pop();
			if (visited[s] == 0) {
				visited[s] = 1;
			}
			Iterator<Edge> itr = adjacencylist[s].iterator();

			while (itr.hasNext()) {
				Edge v = itr.next();
				if (visited[v.getDestination()] == 0)
					stack.push(v.v);
				reachable.add(v.getDestination());
			}

		}
		reachable.remove(a);
	}

	/*
	 * Function calculate and display the mst
	 */
	@Override
	public void mst() {
		Boolean[] mstset = new Boolean[vertices];
		Edge[] e = new Edge[vertices];
		int[] parent = new int[vertices];

		for (int i = 0; i < vertices; i++)
			e[i] = new Edge();

		for (int i = 0; i < vertices; i++) {
			mstset[i] = false;
			e[i].w = Integer.MAX_VALUE;
			e[i].v = i;
			parent[i] = -1;
		}
		mstset[0] = true;
		e[0].w = 0;
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		for (int i = 0; i < vertices; i++)
			queue.add(e[i]);
		while (!queue.isEmpty()) {
			Edge node0 = queue.poll();
			mstset[node0.v] = true;
			for (Edge iterator : adjacencylist[node0.v]) {
				if (mstset[iterator.getDestination()] == false) {
					if (e[iterator.getDestination()].w > iterator.getWeight()) {
						queue.remove(e[iterator.getDestination()]);
						e[iterator.getDestination()].w = iterator.getWeight();
						queue.add(e[iterator.getDestination()]);
						parent[iterator.getDestination()] = node0.v;
					}
				}
			}
		}
		for (int i = 1; i < vertices; i++) {
			int w = 0;
			for (int j = 0; j < adjacencylist[i].size(); j++) {
				if (adjacencylist[i].get(j).v == parent[i]) {
					w = adjacencylist[i].get(j).getWeight();
				}
			}
			System.out.println(parent[i] + " - " + i + " - " + w);
		}
	}

	/*
	 * Calculate the shortest path from a to b
	 */
	@Override
	public void shortestPath(int a, int b) {

		for (int i = 0; i < vertices; i++)
			dist[i] = Integer.MAX_VALUE;
		pq.add(new Edge(a, 0));
		
		dist[a] = 0;

		while (settled.size() != vertices) {
			int u = pq.remove().v;
			settled.add(u);
			e_Neighbours(u);
		}
		System.out.println("The shorted path from node :");
		System.out.println(a + " to " + b + " is " + dist[b]);
	}

	/*
	 * check for all the adjecant vetrices of u
	 */
	private void e_Neighbours(int u) {
		int edgeDistance = -1;
		int newDistance = -1;
		for (int i = 0; i < adjacencylist[u].size(); i++) {
			Edge v = adjacencylist[u].get(i);
			if (!settled.contains(v.v)) {
				edgeDistance = v.w;
				newDistance = dist[u] + edgeDistance;
				if (newDistance < dist[v.v])
					dist[v.v] = newDistance;
				pq.add(new Edge(v.v, dist[v.v]));
			}
		}
	}

	/*
	 * Main Function
	 */
	public static void main(String[] args) {
		int vertices = 9;
		Graph graph = new Graph(vertices);
		// graph.addEgde(0, 1, 4);
		// graph.addEgde(0, 4, 3);
		// graph.addEgde(1, 2, 5);
		// graph.addEgde(1, 3, 2);
		// graph.addEgde(1, 4, 8);
		// graph.addEgde(2, 3, 7);
		// graph.addEgde(3, 4, 2);
		graph.addEgde(0, 1, 4);
		graph.addEgde(0, 7, 8);
		graph.addEgde(1, 2, 8);
		graph.addEgde(1, 7, 11);
		graph.addEgde(7, 6, 1);
		graph.addEgde(7, 8, 7);
		graph.addEgde(2, 3, 7);
		graph.addEgde(2, 5, 4);
		graph.addEgde(2, 8, 2);
		graph.addEgde(6, 5, 2);
		graph.addEgde(6, 8, 6);
		graph.addEgde(3, 4, 9);
		graph.addEgde(3, 5, 14);
		graph.addEgde(5, 4, 10);
		System.out.println("###############################");
		System.out.println("Graph is :");
		System.out.println(graph);
		System.out.println("###############################");
		System.out.println("Graph is Connected : " + graph.isConnected());
		System.out.println("###############################");
		graph.reacheable(0);
		System.out.println("Reachable Nodes : " + graph.reachable);
		System.out.println("###############################");
		System.out.println("MST : ");
		graph.mst();
		System.out.println("###############################");
		graph.shortestPath(0, 4);
		System.out.println("###############################");

	}
}
