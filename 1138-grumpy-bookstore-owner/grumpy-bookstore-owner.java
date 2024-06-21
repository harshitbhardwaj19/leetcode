class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0;
        int max = 0;
        for (int i = 0; i <= grumpy.length - minutes; i++) {
            int sum = 0;
            for (int j = i; j < i + minutes; j++) {
                if (grumpy[j] == 1) {
                    sum += customers[j];
                }
            }
            if (sum > max) {
                max = sum;
                start = i;
            }
        }

        for(int i=start; i<start+minutes; i++){
            grumpy[i] = 0;
        }

        int total = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if(grumpy[i]==0){
                total+=customers[i];
            }
        }
        return total;
    }
}