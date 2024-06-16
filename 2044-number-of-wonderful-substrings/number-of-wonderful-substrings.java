class Solution {
    public long wonderfulSubstrings(String word) {
        int arr[] = new int[1024];

        arr[0] = 1;
        int mask = 0; 
        long count = 0;

        for (char ch : word.toCharArray()) {
            mask = mask ^ (1 << (ch - 'a'));
            count += arr[mask];
            arr[mask] += 1;

            for (int i = 0; i < 10; i++) {
                int tempMask = mask ^ (1 << i);
                count += arr[tempMask];
            }
        }
        return count;
    }
}