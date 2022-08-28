import java.util.*;

/*
	Question 2:
	- Write a function which, 
	- given a string S consisting of lowercase letters of the English alphabet, 
	- returns the longest consistent fragment of S which begins and ends with the same letter. 
	- If there are many possible answers you should return the one starting at the earliest position.
	
	* The length of S is within the range [1..100,000];
	* String S consists only of lowercase letters (a−z).
*/
class Solution {
	public static void main(String[] args) {
		Solution obj = new Solution();
		System.out.println("'cbaabaab' ->" + obj.longestString("cbaabaab"));
		System.out.println("'performance' ->" + obj.longestString("performance"));
		System.out.println("'cat' ->" + obj.longestString("cat"));
	}
	
	public String longestString(String str) {
		int[][] occur = new int[2][26];
		Arrays.fill(occur[0], -1);
		for (int i = 0; i < str.length(); i++) {
			int position = str.charAt(i) - 'a';
			if (occur[0][position] == -1) {
				occur[0][position] = i;
				occur[1][position] = i;
			} else {
				occur[1][position] = i;
			}
		}
		
		int maxLength = -1;
		int index = -1;
		
		for (int i = 0; i < 26; i++) {
			if (occur[0][i] == -1) {
				continue;
			}
			int currentLength = occur[1][i] - occur[0][i] + 1;
			if (maxLength == -1 || maxLength < currentLength 
				|| (maxLength == currentLength && occur[0][i] < occur[0][index])) {
					maxLength = currentLength;
					index = i;
				}
		}
		
		return str.substring(occur[0][index], occur[1][index] + 1);
	}
}