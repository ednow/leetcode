import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 记忆之前找到过的数字
    public Map<Integer, Integer> remember = new HashMap<>();


    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == -1) {
            return 0;
        }

        if (!remember.containsKey(n)) {
            remember.put(n, climbStairs(n - 2) + climbStairs(n - 1));
        }
        return remember.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
    }
}