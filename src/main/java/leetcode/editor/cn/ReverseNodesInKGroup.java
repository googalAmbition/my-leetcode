//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// 👍 2278 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.struct.ListNode;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode pre = dummy;
            ListNode end = dummy;

            while (end.next != null) {
                for (int i = 0; i < k && end != null; i++) {
                    end = end.next;
                }
                if (end == null) {
                    break;
                }
                ListNode start = pre.next;
                ListNode next = end.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = next;
                pre = start;

                end = pre;
            }
            return dummy.next;

        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return last;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
