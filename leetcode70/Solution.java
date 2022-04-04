public class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }

        if (n==-1){
            return 0;
        }

        return climbStairs(n-2) + climbStairs(n-1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
    }
}