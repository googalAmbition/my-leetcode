//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1315 👎 0

// 删除链表的倒数第 N 个结点
package leetcode.editor.cn;

import leetcode.editor.cn.struct.ListNode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode fast = head, slow = head;
            while (n >= 0 && fast != null) {
                fast = fast.next;
                n--;
            }
            if (n != -1) {
                return head == null ? null : head.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }

            if (slow.next != null) {
                slow.next = slow.next.next;
            }

            return head;
        }

        public ListNode removeNthFromEnd2(ListNode head, int n) {
            ListNode fast = head, slow = head;

            while (n + 1 > 0 && fast != null) {
                fast = fast.next;
                n--;
            }

            if (n != -1) {
                return head == null ? null : head.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return head;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}