class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        
        // sorted[i] = true means strs[i] < strs[i+1] is already established
        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;
        
        for (int col = 0; col < m; col++) {
            // Check if this column causes any violation
            boolean needDelete = false;
            for (int i = 0; i < n - 1; i++) {
                // Only check pairs that aren't already sorted
                if (!sorted[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    needDelete = true;
                    break;
                }
            }
            
            if (needDelete) {
                deletions++;
            } else {
                // Keep this column - update sorted status
                for (int i = 0; i < n - 1; i++) {
                    if (strs[i].charAt(col) < strs[i + 1].charAt(col)) {
                        sorted[i] = true;
                    }
                }
            }
        }
        
        return deletions;
    }
}