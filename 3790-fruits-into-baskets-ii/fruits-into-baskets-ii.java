class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (!getLeftMost(fruits[i], baskets)) {
                count++;
            }
        }
        return count;
    }

    public boolean getLeftMost(int count, int[] baskets) {
        boolean found = false;
        for (int i = 0; i < baskets.length; i++) {
            if (count <= baskets[i]) {
                baskets[i] = 0;
                found = true;
                break;
            }
        }
        return found;
    }
}