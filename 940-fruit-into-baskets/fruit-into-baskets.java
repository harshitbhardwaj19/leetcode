class Solution {
    public int totalFruit(int[] fruits) {
        int fruit1 = -1;
        int fruit2 = -1;
        int lastIndex1 = -1;
        int lastIndex2 = -1;
        int start = 0;
        int max = 0;
        for (int end = start; end < fruits.length; end++) {

            if (fruit1 == -1) {
                fruit1 = fruits[end];
            } else if (fruit2 == -1 && fruits[end] != fruit1) {
                fruit2 = fruits[end];
            } else if (fruits[end] != fruit1 && fruits[end] != fruit2) {
                if (lastIndex1 < lastIndex2) {
                    start = lastIndex1 + 1;
                    fruit1 = fruits[end];
                } else {
                    start = lastIndex2 + 1;
                    fruit2 = fruits[end];
                }
            }

            if (fruits[end] == fruit1) {
                lastIndex1 = end;
            } else if (fruits[end] == fruit2) {
                lastIndex2 = end;
            }

            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}