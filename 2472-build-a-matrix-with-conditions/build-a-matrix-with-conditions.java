class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        int rowIncoming[] = new int[k + 1];

        for (int row[] : rowConditions) {
            if (!rowMap.containsKey(row[0])) {
                rowMap.put(row[0], new ArrayList<>());
            }
            if (!rowMap.get(row[0]).contains(row[1])) {
                rowMap.get(row[0]).add(row[1]);
                rowIncoming[row[1]] += 1;
            }
        }
        int rowForGivenVal[] = new int[k + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (rowIncoming[i] == 0) {
                q.add(i);
            }
        }

        int rowNumber = 0;
        if (q.size() == 0) {
            return new int[][] {};
        }
        while (q.size() > 0) {

            int value = q.remove();
            if (rowIncoming[value] == -1) {
                continue;
            }
            rowForGivenVal[value] = rowNumber;
            rowNumber++;
            rowIncoming[value] = -1;

            if (rowMap.containsKey(value)) {
                for (int i : rowMap.get(value)) {
                    rowIncoming[i] -= 1;
                }
            }

            for (int i = 1; i <= k; i++) {
                if (rowIncoming[i] == 0) {
                    q.add(i);
                }
            }

        }
        if (rowNumber < k) {
            return new int[][] {};
        }

        Map<Integer, List<Integer>> colMap = new HashMap<>();
        int colIncoming[] = new int[k + 1];

        for (int col[] : colConditions) {
            if (!colMap.containsKey(col[0])) {
                colMap.put(col[0], new ArrayList<>());
            }
            if (!colMap.get(col[0]).contains(col[1])) {
                colMap.get(col[0]).add(col[1]);
                colIncoming[col[1]] += 1;
            }
        }
        int colForGivenVal[] = new int[k + 1];
        q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (colIncoming[i] == 0) {
                q.add(i);
            }
        }
        int colNumber = 0;
        if (q.size() == 0) {
            return new int[][] {};
        }
        while (q.size() > 0) {
            int value = q.remove();
            if (colIncoming[value] == -1) {
                continue;
            }
            colForGivenVal[value] = colNumber;
            colNumber++;
            colIncoming[value] = -1;

            if (colMap.containsKey(value)) {
                for (int i : colMap.get(value)) {
                    colIncoming[i] -= 1;
                }
            }

            for (int i = 1; i <= k; i++) {
                if (colIncoming[i] == 0) {
                    q.add(i);
                }
            }

        }
        if (colNumber < k) {
            return new int[][] {};
        }

        int matrix[][] = new int[k][k];
        for (int i = 1; i <= k; i++) {
            matrix[rowForGivenVal[i]][colForGivenVal[i]] = i;
        }

        return matrix;
    }
}