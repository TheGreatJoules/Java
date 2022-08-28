import java.util.Random;

public class RandomSelect {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5};
		int[] freq = new int[] {5, 4, 3, 2, 1};

		System.out.println(pickRandom(arr, freq));
	}

	/**
	 * 1. 	Select a random number in an array
	 * 2. 	Given a second array freq where freq[i] represents the occurence of the ith
	 * 		number in the array, how to randomly select a number in array based on the frequency
	 * 3.	Could you complete the section in a single pass
	 * 
	 */ 
	public static int pickRandom(int[] array, int[] freq) {
		int[] sums = new int[array.length];
		int randValue = 0;
		int sum = 0;
		int randIndex = 0;
		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			sums[i] = sum + freq[i];
			randValue += random.nextInt(freq[i] + 1);
			sum += freq[i];
			System.out.println("SUM[i]: " + sums[i]);
			System.out.println("SUM: " + sum);
			while (randIndex < (array.length - 1)
				&& randValue >= sums[randIndex]
				&& randIndex <= i) {
				randIndex++;
			}
		}

		return array[randIndex];
	} 
}