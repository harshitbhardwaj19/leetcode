class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int xorSum = 0;
        int totalSize = nums.length;
        int actualSize = nums.length - 2;

        // XOR all elements of the array
        for (int i = 0; i < totalSize; i++) {
            xorSum ^= nums[i];
        }

        // XOR all numbers from 0 to actualSize - 1 (excluding the two sneaky numbers)
        for (int i = 0; i < actualSize; i++) {
            xorSum ^= i;
        }

        // Find the rightmost set bit in xorSum
        int rightmostSetBit = xorSum & ~(xorSum - 1);

        int firstSneakyNumber = 0;
        int secondSneakyNumber = 0;

        // Separate the numbers into two groups based on the rightmost set bit
        for (int i = 0; i < totalSize; i++) {
            if ((nums[i] & rightmostSetBit) != 0) {
                firstSneakyNumber ^= nums[i];
            } else {
                secondSneakyNumber ^= nums[i];
            }
        }

        // XOR the range of numbers from 0 to actualSize - 1
        for (int i = 0; i < actualSize; i++) {
            if ((i & rightmostSetBit) != 0) {
                firstSneakyNumber ^= i;
            } else {
                secondSneakyNumber ^= i;
            }
        }

        return new int[]{firstSneakyNumber, secondSneakyNumber};
    }
}