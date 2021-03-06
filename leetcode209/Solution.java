package leetcode209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        boolean isFind = false;
        for (int i = 0; i < nums.length; i++) {
            // 增加右边的范围
            if (sum < target) {
                len++;
                sum = sum + nums[i];
            }
            // 缩小左边的范围
            while (sum >= target) {
                isFind = true;
                if (len <= result) {
                    result = len;
                }
                len--;
                sum = sum - nums[i - len];
            }

        }
        if (isFind) {
            return result;
        } else {
            return 0;
        }

    }
}
