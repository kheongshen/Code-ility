import java.util.HashMap;
import java.util.Map;

public class LongestBiValuedSegment {
    public static int longestBiValuedSegment(int[] A) {
        if (A == null || A.length == 0) return 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < A.length; right++) {
            int num = A[right];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // Shrink window if more than 2 distinct values
            while (countMap.size() > 2) {
                int leftNum = A[left];
                countMap.put(leftNum, countMap.get(leftNum) - 1);
                if (countMap.get(leftNum) == 0) {
                    countMap.remove(leftNum);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // Example usage
    public static void main(String[] args) {
        int[] A = {2,3,2,3,4,3,3};
        System.out.println(longestBiValuedSegment(A)); // Output: 3
        System.out.println(getLongestBiValuedSubarray(new int[]{5,5,5,2,2,2,5,5})); 
    }

    public static int getLongestBiValuedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        
        for (int end = 0; end < nums.length; end++) {
            frequency.put(nums[end], frequency.getOrDefault(nums[end], 0) + 1);
            
            while (frequency.size() > 2) {
                frequency.put(nums[start], frequency.get(nums[start]) - 1);
                if (frequency.get(nums[start]) == 0) {
                    frequency.remove(nums[start]);
                }
                start++;
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }

}
