package leetcode210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 有向图
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        // 添加哨兵
        for (int i = 0; i < numCourses; i++) {
            graph.get(i).add(i);
        }
        // 链接被指向的节点
        for (int[] prerequisite: prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }
        List<Integer> sequence = new LinkedList<>();
        boolean isChange = true;
        while (!graph.isEmpty() && isChange) {
            for (List<Integer> node : graph) {
                if (node.size()==1) {
                    sequence.add(node.get(0));
                    graph.remove(node);
                }
            }
        }
        return null;
    }
}
