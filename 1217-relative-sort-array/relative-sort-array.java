class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int arr[] = new int[arr1.length];
        int i = 0;
        for (int num : arr2) {
            int count = map.get(num);
            while (count > 0) {
                arr[i] = num;
                i++;
                count--;
            }
            map.remove(num);
        }
        Set<Integer> set= map.keySet();
        for(int num : set){
            int count = map.get(num);
            while (count > 0) {
                arr[i] = num;
                i++;
                count--;
            }
        }
        return arr;
    }
}