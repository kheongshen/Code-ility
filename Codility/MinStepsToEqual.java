import java.util.Arrays;

public class MinStepsToEqual {

    public static int minSteps(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        int median = A[n / 2];  // use middle element (works for both even/odd n)
        int steps = 0;

        for (int num : A) {
            steps += Math.abs(num - median);
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(minSteps(new int[]{1, 2, 3}));          // Output: 2
        System.out.println(minSteps(new int[]{1, 10, 2, 9}));      // Output: 16
        System.out.println(minSteps(new int[]{5, 5, 5, 5}));       // Output: 0
        System.out.println(minSteps(new int[]{1}));                // Output: 0
        System.out.println(minSteps(new int[]{3,2,1,1,2,3,1}));   
    }
}
