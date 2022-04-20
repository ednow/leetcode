package leetcode934;

public class Test {
    public static void main(String[] args) {
        var s = new Solution();
//        System.out.println(new Solution().shortestBridge(new int[][]{{0, 1}, {1, 0}}));
//        [[1,1,0,0,0],[1,0,0,0,0],[1,0,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
        System.out.println(new Solution().shortestBridge(
                new int[][]{
                        {1, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1}
                }
        ));
    }
}
