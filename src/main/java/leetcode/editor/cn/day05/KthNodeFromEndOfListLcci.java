//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。 
//
// 注意：本题相对原题稍作改动 
//
// 示例： 
//
// 输入： 1->2->3->4->5 和 k = 2
//输出： 4 
//
// 说明： 
//
// 给定的 k 保证是有效的。 
// Related Topics 链表 双指针 
// 👍 75 👎 0

// 返回倒数第 k 个节点
package leetcode.editor.cn.day05;

import leetcode.editor.cn.struct.ListNode;

public class KthNodeFromEndOfListLcci {

    public static void main(String[] args) {
        Solution solution = new KthNodeFromEndOfListLcci().new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        solution.kthToLast(l1, 1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        public int kthToLast(ListNode head, int k) {
            ListNode fast = head, slow = head;

            while (fast != null) {
                fast = fast.next;
                slow = --k < 0 ? slow.next : slow;
            }
            return slow.val;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}