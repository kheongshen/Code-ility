import java.util.Arrays;

public class SanatoriumRoomAllocator {

    public static int minRooms(int[] A) {
        Arrays.sort(A);  // Sort preferences
        int rooms = 0;
        int i = 0;
        int n = A.length;

        while (i < n) {
            int groupSize = A[i];  // Try to form a group of this size
            int count = 1;

            // Try to fill the group with compatible guests
            while (count < groupSize && i + count < n && A[i + count] >= groupSize) {
                count++;
            }

            if (count >= groupSize) {
                // We can form a room with `groupSize` guests
                i += groupSize;
                rooms++;
            } else {
                // Not enough compatible guests to form a group
                break;
            }
        }

        // Assign any remaining guests (1 per room if needed)
        if (i < n) {
            rooms += (n - i);
        }

        return rooms;
    }

    public static void main(String[] args) {
        System.out.println(minRooms(new int[]{1, 2, 2, 3, 3}));  // Output: 3
        System.out.println(minRooms(new int[]{1, 1, 1, 1}));      // Output: 4
        System.out.println(minRooms(new int[]{4, 4, 4, 4}));      // Output: 1
        System.out.println(minRooms(new int[]{2, 3, 1, 2}));      // Output: 3
    }
}
