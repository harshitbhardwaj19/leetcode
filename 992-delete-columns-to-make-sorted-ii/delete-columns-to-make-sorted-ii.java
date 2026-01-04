class Solution {
    public int minDeletionSize(String[] strs) {
        Set<Integer> set = new HashSet<>();
        int n = strs.length;
        int l = strs[0].length();
        int count = 0;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < l; j++) {
                char c1 = strs[i].charAt(j);
                char c2 = strs[i + 1].charAt(j);

                if (set.contains(j)) {
                    continue;
                }
                
                if (c1 == c2) {
                    continue;
                } else if (c1 > c2) {
                    count++;
                    set.add(j);
                    i = -1;
                    break;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}