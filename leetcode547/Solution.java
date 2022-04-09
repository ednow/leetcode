package leetcode547;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class Solution {
    int find(int[] p, int x) {
        if (p[x] == x) return x;
        // 路径压缩
        p[x] = find(p, p[x]);
        return p[x];

    }

    void union(int[] p, int a, int b) {
        p[find(p, b)] = find(p, a);

    }

    public int findCircleNum(int[][] isConnected) {
        int[] p = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            p[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    union(p, i, j);
                }
            }
        }

        Set<Integer> parent = new HashSet<>();
        for (int i = 0; i < p.length; i++) {
            parent.add(find(p, i));
        }

        return parent.size();
    }
}
