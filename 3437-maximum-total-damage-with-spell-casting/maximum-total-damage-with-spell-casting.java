class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Long, Long> frequencyMap = new HashMap<>();
        for (long dmg : power) {
            frequencyMap.put(dmg, frequencyMap.getOrDefault(dmg, 0L) + 1);
        }

        List<Long> uniqueDamages = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(uniqueDamages);

        Map<Long, Long> dp = new HashMap<>();
        long prevPrevPrev = -10, prevPrev = -10, prev = -10;
        long currentMax = 0;

        for (int i = 0; i < uniqueDamages.size(); i++) {
            long current = uniqueDamages.get(i);
            long currentDamage = current * frequencyMap.get(current);
            // long currentMax = 0;

            if (current - prevPrevPrev > 2) {
                currentMax = Math.max(currentMax, currentDamage + dp.getOrDefault(prevPrevPrev, 0L));
            } else {
                currentMax = Math.max(currentMax, dp.getOrDefault(prevPrevPrev, 0L));
            }

            if (current - prevPrev > 2) {
                currentMax = Math.max(currentMax, currentDamage + dp.getOrDefault(prevPrev, 0L));
            } else {
                currentMax = Math.max(currentMax, dp.getOrDefault(prevPrev, 0L));
            }

            if (current - prev > 2) {
                currentMax = Math.max(currentMax, currentDamage + dp.getOrDefault(prev, 0L));
            } else {
                currentMax = Math.max(currentMax, dp.getOrDefault(prev, 0L));
            }

            dp.put(current, currentMax);

            prevPrevPrev = prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return currentMax;
    }
}