package leetcode684;

/**
 * https://leetcode-cn.com/problems/redundant-connection/
 */
public class Solution {
    int find(int[] p, int x) {
        if (p[x]==x) return x;
        p[x] = find(p, p[x]);
        return p[x];
    }

    void union(int[] p, int a, int b) {
        p[find(p, a)] = find(p, b);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = null;
        int[] p = new int[edges.length+1];
        for (int i = 0; i < edges.length; i++) {
            p[i] = i;
        }
        for (int[] edge : edges) {
            int a = find(p, edge[0]);
            int b = find(p, edge[1]);
            union(p, edge[0], edge[1]);
            int c = find(p, edge[0]);
            int d = find(p, edge[1]);
            // 如果之前已经连上过
            if (a==b && c == d) {
                result = edge;
            }


        }

        return result;
    }
}
