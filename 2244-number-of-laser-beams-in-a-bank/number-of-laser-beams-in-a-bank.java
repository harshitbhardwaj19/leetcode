class Solution {
    public int numberOfBeams(String[] bank) {
        int total = 0;
        int prev = -1;

        for (String row : bank) {
            int l = row.length();
            int count = 0;
            for (int i = 0; i < l; i++) {
                if (row.charAt(i) == '1') {
                    count++;
                }
            }
            if (count == 0) {
                continue;
            }

            if (prev == -1) {
                prev = count;
            } else {
                total += count * prev;
                prev = count;
            }
        }
        return total;
    }
}