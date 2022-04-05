package leetcode112;


/**
 * https://leetcode.com/problems/path-sum/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Solution {
    // 是不是第一次走
    boolean first = true;
    // targetSum是不是大于0
    boolean isNegative = true;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (first) {
            first = false;
            if (root==null) return false;
            // 根节点满足的话,必须没有左右孩子
            if (root.val == targetSum) {
                return root.left == null && root.right == null;
            }
            if (targetSum > 0) {
                isNegative = false;
            }
        }


        // 加起来肯定大于目标数
        if (targetSum < 0 && !isNegative) {
            return false;
        }

        if (targetSum > 0 && isNegative) {
            return false;
        }

        // 走到根节点且求和完毕
        if (root == null && targetSum==0) {
            return true;
        }
        // 走到根节点且没求完
        if (root == null) {
            return false;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}
