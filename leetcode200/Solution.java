package leetcode200;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    int find(int[] p, int x) {
        if (p[x]==x) return x;
        p[x] = find(p, p[x]);
        return p[x];
    }

    void union(int[] p, int a, int b) {
        p[find(p, a)] = find(p, b);
    }

    public int numIslands(char[][] grid) {
        int[] p = new int[grid.length* grid.length];
        // 探照方向
        int[][] pos = new int[][]{{0, 1}, {1, 0}, {1, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}};
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int [] once: pos) {
                    // 如果探照合法而且是连接的
                    int x = i + once[0];
                    int y = i + once[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[i][j] == '1' && grid[x][y] == '1') {
                        union(p, i*j, x*y);
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == '1') {
                    set.add(find(p, i * j));
                }
            }
        }
        return set.size();
    }
}
