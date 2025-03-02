class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);

        for (int edge[] : edges) {
            if (dsu.find(edge[0]) == dsu.find(edge[1])) {
                return edge;
            }
            dsu.union(edge[0], edge[1]);
        }
        return null;
    }
}

class DSU {
    int rank[];
    int parent[];

    DSU(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    int find(int a) {
        if (a != parent[a]) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }

    void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) {
            return;
        }
        if (rank[parA] > rank[parB]) {
            rank[parA] += rank[parB];
            parent[parB] = parA;
        } else {
            rank[parB] += rank[parA];
            parent[parA] = parB;
        }
    }
}