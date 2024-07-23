class Solution {
    public int[] frequencySort(int[] nums) {
        int l = nums.length;
        Integer arr[] = new Integer[l];
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            arr[i] = num;
            i++;
        }

        Arrays.sort(arr, (a, b) -> {
            if(map.get(a) == map.get(b)){
                return b - a;
            }
            return map.get(a) - map.get(b);
        });

        int[] result = new int[l];
        for(i = 0; i < l; i++) {
            result[i] = arr[i];
        }

        return result;
    }
}