package leetcode739;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int [] ans= new int[temperatures.length];
        Arrays.fill(ans, 0);
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

}
