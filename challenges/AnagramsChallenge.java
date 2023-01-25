import java.util.*;

public class AnagramsChallenge {

    private class SolutionA {
        private static boolean areAnagrams(String first, String second) {
                return areAnagrams("", first, second);
            }

            private static boolean areAnagrams(String soFar, String remaining, String target) {
                if (remaining.length() == 0)
                    return soFar.equals(target);
                
                    for (int i = 0; i < remaining.length(); i++) {
                        String whatsLeft =  remaining.substring(0, i) + remaining.substring(i+1);
                        System.out.println(whatsLeft);
                        if (areAnagrams(soFar + remaining.charAt(i), whatsLeft, target)) {
                            return true;
                        }             
                    }
                return false;
        }
    }

    private class SolutionB {
        public int kSimilarity(String A, String B) {
            Map<String, Integer> map = new HashMap<>();
            return backtrack(A.toCharArray(), B, map, 0);
        }

        private int backtrack(char[] A, String B, Map<String, Integer> map, int i) {
            String sa = new String(A);
            if (sa.equals(B)) {
                return 0;
            }

            if (map.containsKey(sa)) {
                return map.get(sa);
            }

            int min = Integer.MAX_VALUE;
            while (i < A.length && A[i] == B.charAt(i)) {
                i++;
            }
            
            for (int j = i + 1; j < B.length(); j++) {
                if (A[j] == B.charAt(i)) {
                    swap(A, i, j);
                    int next = backtrack(A, B, map, i + 1);
                    if (next != Integer.MAX_VALUE) {
                        min = Math.min(min, next + 1);
                    }
                    swap(A, i, j);
                }
            }
            map.put(sa, min);
            return min;
        }

        private void swap(char[] cs, int i, int j) {
            char temp = cs[i];
            cs[i] = cs[j];
            cs[j] = temp;
        }
    }

    public static void main(String[] args) {
        SolutionA sol_a = new SolutionA()
        SolutionB sol_b = new SolutionB()
        String test1 = "ab";
        String test2 = "b";
        areAnagrams(test1, test2);
    }   
}