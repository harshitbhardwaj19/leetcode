class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int minCommon = Integer.MAX_VALUE;
        for (int fruit : basket1) {
            minCommon = Math.min(minCommon, fruit);
            map1.put(fruit, 1 + map1.getOrDefault(fruit, 0));
        }
        System.out.println(map1);
        for (int fruit : basket2) {
            minCommon = Math.min(minCommon, fruit);
            if (map1.containsKey(fruit)) {
                map1.put(fruit, map1.get(fruit) - 1);
                if (map1.get(fruit) == 0) {
                    map1.remove(fruit);
                }
            } else {
                map2.put(fruit, 1 + map2.getOrDefault(fruit, 0));
            }
        }
        System.out.println("********************");
        System.out.println(map1);
        System.out.println(map2);

        int arr1[][] = new int[map1.size()][2];
        int arr2[][] = new int[map2.size()][2];

        int i = 0;
        for (int key : map1.keySet()) {
            arr1[i][0] = key;
            arr1[i][1] = map1.get(key);
            if (arr1[i][1] % 2 == 1) {
                return -1;
            }
            i++;
        }

        i = 0;
        for (int key : map2.keySet()) {
            arr2[i][0] = key;
            arr2[i][1] = map2.get(key);
            if (arr2[i][1] % 2 == 1) {
                return -1;
            }
            i++;
        }

        Arrays.sort(arr1, (a, b) -> a[0] - b[0]);
        Arrays.sort(arr2, (a, b) -> a[0] - b[0]);

        System.out.println("arr1:");
        for (int[] row : arr1) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("arr2:");
        for (int[] row : arr2) {
            System.out.println(Arrays.toString(row));
        }

        int s1 = 0;
        int s2 = 0;
        int e1 = arr1.length - 1;
        int e2 = arr2.length - 1;

        long count = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (arr1[s1][0] < arr2[s2][0]) {
                int min = Math.min(arr1[s1][1], arr2[e2][1]);

                int swaps = min / 2;
                long costPerSwap = Math.min(2L * minCommon, (long) arr1[s1][0]);
                count += costPerSwap * swaps;

                arr1[s1][1] -= min;
                arr2[e2][1] -= min;
                if (arr1[s1][1] == 0) {
                    s1++;
                }
                if (arr2[e2][1] == 0) {
                    e2--;
                }
            } else {
                int min = Math.min(arr2[s2][1], arr1[e1][1]);

                int swaps = min / 2;
                long costPerSwap = Math.min(2L * minCommon, (long) arr2[s2][0]);
                count += costPerSwap * swaps;

                arr2[s2][1] -= min;
                arr1[e1][1] -= min;
                if (arr2[s2][1] == 0) {
                    s2++;
                }
                if (arr1[e1][1] == 0) {
                    e1--;
                }
            }
        }

        return count;
    }
}