import java.util.*;

public class LeetCode1647 {
	public int minDeletions(String s) {
		int deletions = 0;
		Map<Character, Integer> freq = new HashMap<>();
		Map<Integer, Stack<Character>> dup = new HashMap<>();

		// Count all the frequencies
		for (Character c : s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}

		// Iterate through the frequencies
		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			// Map all the unique counts
			if (!dup.containsKey(entry.getValue())) {
				dup.put(entry.getValue(), new Stack<>());
			}

			// Add the character corresponding to the frequencies
			dup.get(entry.getValue()).add(entry.getKey());

			// If there is more than one then find the next empty slot
			if (dup.get(entry.getValue()).size() > 1) {
				int current = entry.getValue();
				Stack<Character> stack = dup.get(entry.getValue());
				
				// Transverse until there is only one unique character for frequency
				while (dup.get(entry.getValue()).size() > 1) {
					current--;
					if (current == 0) {
						stack.pop();
						deletions++;
						break;
					}

					if (!dup.containsKey(current)) {
						dup.put(current, new Stack<>());
						dup.get(current).add(entry.getKey());
						stack.pop();
					}
					deletions++;
				}
			}
		}
		return deletions;
	}
}