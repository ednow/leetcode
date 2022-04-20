package leetcode934;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/shortest-bridge/
 */
public class Solution {
    // 临界区域判别
    int[][] pos = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 将此次访问到的节点标记为2
     *
     * @param i         现在要访问的节点的行坐标
     * @param j         现在要访问的节点的列坐标
     * @param graph     图
     * @param isVisited 访问记忆矩阵
     */
    void mark(int i, int j, int[][] graph, boolean[][] isVisited, List<int []> island) {
        // 访问过，或者当前不是陆地不用查找
        if (isVisited[i][j] || graph[i][j] == 0) {
            return;
        }

        // 标记这一块土地
        graph[i][j] = 2;
        island.add(new int[]{i, j});
        // 标记下一块接壤的土地
        for (int[] once : pos) {
            int x = j + once[0];
            int y = i + once[1];
            if (x >= 0 && y >= 0 && x < graph[0].length && y < graph.length && graph[y][x] == 1) {
                mark(y, x, graph, isVisited, island);
            }
        }
    }

    /**
     * 找到第一块土地
     * @param graph 图
     */
    int[] find(int[][] graph) {
        // 第一个找到的土地所接壤的土地都标记为
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int shortestBridge(int[][] grid) {

        LinkedList<int[]>[] islands =(LinkedList<int[]> [])new LinkedList<?>[2];
        islands[0] = new LinkedList<int[]>();
        islands[1] = new LinkedList<int[]>();
        for (LinkedList<int[]> island : islands) {
            // 将要被标记为2的第一块土地

            int[] block = find(grid);
//            // 先把地图划分为两个岛屿
//            List<int []> island1 = new LinkedList<>();
            mark(block[0], block[1], grid, new boolean[grid.length][grid[0].length], island);
        }

        int result = Integer.MAX_VALUE;
        for (int[] block : islands[0]) {
            for (int[] block2: islands[1]) {
                result = Math.min(result, Math.abs(block[0] - block2[0]) + Math.abs(block[1] - block2[1]));
            }
        }

        return result-1;
    }
}
