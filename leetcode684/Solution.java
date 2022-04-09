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
            union(p, edge[0], edge[1]);

            int parent = find(p, edge[0]);
            // 如果他们之间有同一个父亲，且这个父亲不再他们之中，而且他们之间有连接
            if (parent != edge[0] && parent != edge[1]) {
                result = edge;
            }
        }

        return result;
    }
}
