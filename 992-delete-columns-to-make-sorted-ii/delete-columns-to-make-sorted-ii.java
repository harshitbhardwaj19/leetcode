class Solution {
    public int minDeletionSize(String[] strs) {
        Set<Integer> set = new HashSet<>();
        int n = strs.length;
        int l = strs[0].length();
        int count = 0;
        System.out.println("=== INPUT ===");
        for (int i = 0; i < n; i++) {
            System.out.println("strs[" + i + "] = \"" + strs[i] + "\"");
        }
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            System.out.println("--- Comparing strs[" + i + "]=\"" + strs[i] +
                    "\" with strs[" + (i + 1) + "]=\"" + strs[i + 1] + "\" ---");

            for (int j = 0; j < l; j++) {
                char c1 = strs[i].charAt(j);
                char c2 = strs[i + 1].charAt(j);

                System.out.print("  Column " + j + ": '" + c1 + "' vs '" + c2 + "' → ");

                if (set.contains(j)) {
                    System.out.println("SKIP (already deleted)");
                    continue;
                }

                if (c1 == c2) {
                    System.out.println("EQUAL (check next column)");
                    continue;
                } else if (c1 > c2) {
                    count++;
                    set.add(j);
                    System.out.println("DELETE column " + j + " ('" + c1 + "' > '" + c2 + "')");
                    System.out.println("  Deleted columns so far: " + set);
                    System.out.println("  Count = " + count);
                    i = -1;
                    break;
                } else {
                    System.out.println("BREAK ('" + c1 + "' < '" + c2 + "', already sorted)");
                    break;
                }
            }
            System.out.println();
        }

        System.out.println("=== RESULT ===");
        System.out.println("Deleted columns: " + set);
        System.out.println("Minimum deletions: " + count);

        return count;
    }
}