class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);

        int sum = 0;
        int count = 0;
        int boxSum = 0;

        for (int s : apple) {
            sum += s;
        }

        for (int i = capacity.length-1; i >= 0; i--) {
            boxSum += capacity[i];
            count++;
            if (boxSum >= sum) {
                return count;
            }
        }
        return -1;
    }
}