class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, (a, b) -> {
            int h1 = Integer.parseInt(a.substring(0, 2));
            int h2 = Integer.parseInt(b.substring(0, 2));
            int m1 = Integer.parseInt(a.substring(3));
            int m2 = Integer.parseInt(b.substring(3));
            if (h1 == h2) {
                return m1 - m2;
            } else {
                return h1 - h2;
            }
        });
        System.out.println(timePoints);
        int len = timePoints.size();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            String a = timePoints.get(i);
            String b = timePoints.get(i + 1);
            int h1 = Integer.parseInt(a.substring(0, 2));
            int h2 = Integer.parseInt(b.substring(0, 2));
            int m1 = Integer.parseInt(a.substring(3));
            int m2 = Integer.parseInt(b.substring(3));
            int diff = ((h2 - h1) * 60) + m2 - m1;
            min = Math.min(min, diff);
        }
        String a = timePoints.get(len - 1);
        String b = timePoints.get(0);
        int h1 = Integer.parseInt(a.substring(0, 2));
        int h2 = Integer.parseInt(b.substring(0, 2));
        int m1 = Integer.parseInt(a.substring(3));
        int m2 = Integer.parseInt(b.substring(3));
        int diff = ((h2 - h1 + 24) * 60) + m2 - m1;
        min = Math.min(min, diff);
        return min;
    }
}