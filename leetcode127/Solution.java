package leetcode127;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class Solution {

    class Item {
        // 节点的层数
        public int level;
        // 节点的编号
        public int id;
        public Item(int level, int id) {
            this.level = level;
            this.id = id;
        }
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int[][] graph = new int[wordList.size()][wordList.size()];
        // 初始化状态转移矩阵
        for (int[] row: graph) {
            Arrays.fill(row, 0);
        }
        for (int i = 0; i < wordList.size()-1; i++) {
            for (int j = i+1; j < wordList.size(); j++) {
                int diff = 0;
                // 如果只有一个个字母不一样
                for (int k = 0; k < wordList.get(i).length(); k++) {
                    if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }

        int end = wordList.indexOf(endWord);
        if (end == -1) {
            return 0;
        }
        boolean[] isReach = new boolean[wordList.size()];
        Queue<Item> q = new ArrayDeque<>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < wordList.size()-1; i++) {
            int diff = 0;
            // 如果只有一个个字母不一样
            for (int k = 0; k < wordList.get(i).length(); k++) {
                if (wordList.get(i).charAt(k) != beginWord.charAt(k)) {
                    diff++;
                }
            }
            if (diff == 1) {
                q.add(new Item(1, i));
                isReach[i] = true;
            }
        }

        while (!q.isEmpty()) {
            Item item = q.poll();
            if (item.id == end && item.level < result) {
                result = item.level;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (!isReach[i] && graph[i][item.id] == 1) {
                    isReach[item.id] = true;
                    q.add(new Item(item.level+1, i));
                }
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result+1;
    }
}
