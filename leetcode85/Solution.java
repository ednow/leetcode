package leetcode85;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 题目：https://leetcode.com/problems/maximal-rectangle/
 * 解法：https://blog.csdn.net/qq_17550379/article/details/86237801
 * 把每一行以上的区域看成是问题84的直方图
 */
public class Solution {

    /**
     * 背
     * @param heights
     * @return
     */
    int maximalRectangle(int[] heights) {
        int ans = 0;
        int []right = new int[heights.length];
        // 最后一个元素的边界是n
        right[heights.length - 1] = heights.length;
        int []left = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.pop()] = i;
            }
            left[i] = (stack.isEmpty() ? -1: stack.peek());
            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        // 初始化高度数组
        int[][] heights = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(heights[i], 0);
        }
        for (int i = 0; i < matrix.length; i++) {  // row
            for (int j = 0; j < matrix[i].length; j++) { // col
                for (int k = i; k >= 0; k--) {
                    if (matrix[k][j] == '0') {
                        break;
                    }
                    heights[i][j]++;
                }
            }
        }

        int ans = 0;
        // 每一行都进行单调栈搜索
        for (int[] height : heights) {
            ans = Math.max(ans, maximalRectangle(height));
        }
        return ans;
    }
}
