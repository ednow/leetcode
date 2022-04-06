package leetcode23;

public class Test {
    Solution s = new Solution();
    static Test t = new Test();

    /**
     * 根据数字数组创建链表
     * @param arr 节点值数组
     * @return 创建好链表的头节点
     */
    ListNode initList(int [] arr) {
        var head = new ListNode(arr[0]);
        var a = head;
        for (int i = 1; i < arr.length; i++) {
            a.next = new ListNode(arr[i]);
            a = a.next;
        }

        return head;
    }

    void case1() {
//        [[1,4,5],[1,3,4],[2,6]]
        var head = s.mergeKLists(new ListNode[]{
                initList(new int[]{1, 4, 5}),
                initList(new int[]{1, 3, 4}),
                initList(new int[]{2,6})
        });
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }

    }

    public static void main(String[] args) {
        t.case1();
    }
}
