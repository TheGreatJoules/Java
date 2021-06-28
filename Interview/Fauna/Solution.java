import java.io.*;
import java.util.*;

/**
 * Compiled using Java 8.
 * All input will be *.txt
 * Send over via zip folder
 * Note: Last line should have an extra blank line to register the empty line case
 * script used to run: javac Solution.java && cat *_graphs.txt | java -classpath . Solution
 */ 

class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<String, Set<String>> map = new HashMap<>();
		List<String> result = new ArrayList<>();

		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			// [Edge Case]: ignore all #
			if (line.equals("#") || line.startsWith("#")) {
				continue;
			}
			// [Edge Case]: If an empty line is found, transverse the graph, output the result in the specified format
			else if (line.isEmpty()) {
				// Purpose: Removed the empty key set during intialization.
				map.entrySet().removeIf(entry -> entry.getKey().isEmpty() && entry.getValue().isEmpty());

				if (!map.isEmpty()) {
					System.out.println(map.toString());
					process(map, result, new HashSet<>());
					result.forEach(o -> System.out.print(o + " "));
					System.out.println();
				}

				map.clear();
				result.clear();
			} 
			// [Edge Case]: If the line is not empty, continue onwards to parse data
			else {
				// [Edge Case]: The stdin line must include a colon
				if (!line.contains(":")) {
					invalidInput(1);
					System.exit(1);
				}

				// [Edge Case]: The stdin line has an invalid character.
				if (!line.matches("[a-zA-Z:,]*")){
    				invalidInput(2);
    				System.exit(1);
				}

				String[] arr = line.split("[:,]");
				createAdjlist(map, arr);
			}
		}

	}

	/**
	 * @param map the implented graph.
	 * @param result the list of ordered task.
	 * @param visited a set of visited elements to identify cycles
	 */ 
	private static void process(Map<String, Set<String>> map, List<String> result, Set<String> visited) {
		// Purpose: This will continue the iteration forward to visit all element keys.
		for (String key : map.keySet()) {
			backtracking(map, result, key, visited);
		}
	}

	/**
	 * @param map the implemented graph.
	 * @param result the list of ordered task.
	 * @param key the element selected to visit it's adjacent list.
	 * @param visited a set of visited elements to identify cycles
	 */ 
	private static void backtracking(Map<String, Set<String>> map, List<String> result, String key, Set<String> visited) {
		// [Edge Case]: If key has no neighbors, and not yet included, please add it.
		if (map.get(key).isEmpty()) {
			if (!result.contains(key)) {
				result.add(key);
			}
			return;
		}
		
		if (visited.contains(key)) {
			invalidInput(3);
			System.exit(1);
		}

		// Purpose: Iterate through the neighbors, transverse dfs until end of adjacent list
		for (String val : map.get(key)) {
			visited.add(key);
			backtracking(map, result, val, visited);
			visited.remove(key);
		}
		
		
		// Purpose: At the end of the transversal, add the element to its visited set. The element should an eligable next canidate if it hasn't yet been visited. 
		if (!result.contains(key)) {
			result.add(key);
		}
	}

	/**
	 * @param map the implemented graph.
	 * @param arr the stdin line stored as an arr with its first element being the key.
	 */ 
	private static void createAdjlist(Map<String, Set<String>> map, String[] arr) {
		map.computeIfAbsent(arr[0], o -> new HashSet<>());
		for (int i = 1; i < arr.length; i++) {
			map.computeIfAbsent(arr[i], o -> new HashSet<>());
			map.get(arr[0]).add(arr[i]);
			// map.get(arr[i]).add(arr[0]);
		}
	}

	/**
	 * @param input the selected response 
	 */
	private static void invalidInput(int input) {
		switch (input) {
			case 1:
				System.out.println("Invalid Input, No colon is found.");
				break;
			case 2:
				System.out.println("Invalid Symbol, No valid delimiter is found.");
				break;
			case 3:
				System.out.println("Cycle Detected.");
				break;
		}
	}
}