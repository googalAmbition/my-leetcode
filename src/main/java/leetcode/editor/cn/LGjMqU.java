//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
//
// Related Topics 栈 递归 链表 双指针 👍 85 👎 0

// 重排链表
package leetcode.editor.cn;

import leetcode.editor.cn.struct.ListNode;

public class LGjMqU {

    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
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

        public void reorderList(ListNode head) {

            if (head == null) {
                return;
            }
            ListNode mid = middle(head);
            ListNode l1 = head;
            ListNode l2 = mid.next;
            mid.next = null;
            l2 = revers(l2);
            merge(l1, l2);
        }

        private void merge(ListNode l1, ListNode l2) {
            ListNode l1Tmp = l1;
            ListNode l2Tmp = l2;
            while (l1 != null && l2 != null) {
                l1Tmp = l1.next;
                l2Tmp = l2.next;

                l1.next = l2;
                l1 = l1Tmp;

                l2.next = l1;
                l2 = l2Tmp;
            }
        }

        private ListNode middle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        private ListNode revers(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}