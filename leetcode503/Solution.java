package leetcode503;

import java.util.Arrays;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            boolean isFind = false;
            // 向右边找大的元素
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    isFind = true;
                    ans[i] = nums[j];
                    break;
                }
            }
            if (isFind) {
                continue;
            }
            // 再从0开始找下一个更大的元素
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }
}
