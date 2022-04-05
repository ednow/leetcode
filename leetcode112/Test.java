package leetcode112;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;


public class Test {
//    private List<TreeNode> queue = new LinkedList<>();


    private void initTree(LinkedList<Integer> tree, LinkedList<TreeNode> queue) {
        var root = queue.removeFirst();

        // 插入左孩子
        if (!tree.isEmpty()) {
            var val = tree.removeFirst();
//            System.out.println(val);
            if (val != null) {
                root.left = new TreeNode(val);
                queue.add(root.left);
            }

        }

        // 插入右孩子
        if (!tree.isEmpty()) {
            var val = tree.removeFirst();
            if (val != null) {
                root.right = new TreeNode(val);
                queue.add(root.right);
            }
        }

        if (!tree.isEmpty()) {
            initTree(tree, queue);
        }
    }

    public TreeNode doInitTree(Integer [] tree) {
        LinkedList<Integer> listOfTree = new LinkedList<>(Arrays.asList(tree));
        var root = new TreeNode(listOfTree.removeFirst());
        initTree(listOfTree, new LinkedList<>(Arrays.asList(root)));
        return root;
    }


    public static void main(String[] args) {
        // 根节点通过的话也不行。
//        System.out.println(new Solution().hasPathSum(new TreeNode(1, new TreeNode(2), null), 1));
        var s = new Solution();
        var t = new Test();
//        [1,2,null,3,null,4,null,5]
//        6
        // 在节点3的右孩子处加起来为6，但是不是到根节点
        // false
//        System.out.println(
//                s
//                .hasPathSum(t.doInitTree(new Integer[]{1, 2, null, 3, null, 4, null, 5}), 6)
//        );
//        [5,4,8,11,null,13,4,7,2,null,null,null,1]
//        22

        System.out.println(
                s
                        .hasPathSum(t.doInitTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1}), 22)
        );

//        [8,9,-6,null,null,5,9]
    }
}
