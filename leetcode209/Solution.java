package leetcode209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = 0;
        int sum = 0;
        int result = len;
        for (int i = 0; i < nums.length; i++) {
            // 增加右边的范围
            if (sum < target) {
                len++;
                sum = sum + nums[i];
            }
            // 缩小左边的范围
            while (sum >= target) {
                result = len;
                len--;
                sum = sum - nums[i - len];
            }

        }
        return result;
    }
}
