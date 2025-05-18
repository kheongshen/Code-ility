import java.util.HashSet;
import java.util.Set;

public class compareArrayFindSame {
    
    public static Set<Integer> findSame(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : A) {
            setA.add(num);
        }

        for (int num : B) {
            if (setA.contains(num)) {
                result.add(num);
            }
            setB.add(num);
        }

        return result;
    }
    public static Set<Integer> findSame2(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : A) {
            setA.add(num);
        }

        for (int num : B) {
            if (setA.contains(num)) {
                result.add(num);
            }
        }

        return result;
    }

    public static int countCommonDigits(int A, int B) {
        Set<Character> digitsA = new HashSet<>();
        Set<Character> digitsB = new HashSet<>();

        for (char c : String.valueOf(A).toCharArray()) {
            digitsA.add(c);
        }

        for (char c : String.valueOf(B).toCharArray()) {
            digitsB.add(c);
        }

        digitsA.retainAll(digitsB); // Keep only common elements
        return digitsA.size();
    }

    public static void main(String[] args) {
        int A = 12345;
        int B = 54321;
        System.out.println("Common digits: " + countCommonDigits(A, B)); // Output: 5
    }

}
