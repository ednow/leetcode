package leetcode547;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class Solution {
    int find(int[] set, int x) {
        if (set[x] == x) return x;
        // 路径压缩
        set[x] = find(set, x);
        return set[x];
    }

    void union(int[] set, int a, int b) {
        set[find(set, b)] = find(set, a);

    }

    public int findCircleNum(int[][] isConnected) {
        int[] set = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            set[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    union(set, i, j);
                }
            }
        }

        Set<Integer> parent = new HashSet<>();
        for (int i = 0; i < set.length; i++) {
            parent.add(find(set, i));
        }

        return parent.size();
    }
}
