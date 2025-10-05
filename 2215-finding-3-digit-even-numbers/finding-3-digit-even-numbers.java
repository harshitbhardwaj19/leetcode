class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int l = digits.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < l; i++) {
            if (digits[i] == 0) {
                    continue;
            }
            for (int j = 0; j < l; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < l; k++) {
                    if (digits[k]%2 == 1 || k == j || k == i) {
                        continue;
                    }
                    set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }
        System.out.println(set);
        int arr[] = new int[set.size()];
        int i =0;
        for (Integer num : set) {
            arr[i] = num;
            i++;
        }
        Arrays.sort(arr);
        return arr;
    }
}