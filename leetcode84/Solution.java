package leetcode84;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/
 * 在一维数组中对每一个数找到第一个比自己小的元素。这类“在一维数组中找第一个满足某种条件的数”的场景就是典型的单调栈应用场景。
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int len = 0;
            // 向左边扩散
            for (int j = i-1; j >= 0; j--) {
                if (heights[j] >= heights[i]) {
                    len++;
                } else { // 结束扩散
                    break;
                }
            }
            // 向右边扩散
            for (int j = i+1; j < heights.length; j++) {
                if (heights[j] >= heights[i]) {
                    len++;
                } else { // 结束扩散
                    break;
                }
            }
            result = Math.max(result, heights[i] * (len + 1));
        }
        return result;
    }
}
