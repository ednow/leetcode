package leetcode209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < target && i + len < nums.length) {
                len++;
                sum = sum + nums[i];
                continue;
            }
            if (sum >= target) {
                len--;
                sum = sum - nums[i - len];
            }

        }

        return len;
    }
}
