//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
// Related Topics 栈 链表 数学 👍 530 👎 0

// 两数相加 II
package leetcode.editor.cn;

import leetcode.editor.cn.struct.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbersIi {

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
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

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            Deque<ListNode> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
            stack(d1, l1);
            stack(d2, l2);

            Deque<Integer> ans = new ArrayDeque<>();
            int flag = 0;
            while (!d1.isEmpty() || !d2.isEmpty()) {
                int a = 0, b = 0;
                if (!d1.isEmpty()) {
                    a = d1.poll().val;
                }
                if (!d2.isEmpty()) {
                    b = d2.pop().val;
                }
                int sum = a + b + flag;
                flag = sum > 9 ? 1 : 0;
                ans.push(sum > 9 ? sum - 10 : sum);
            }
            ListNode head = new ListNode(), cur = head;

            if (flag ==1){
                cur.next = new ListNode(1);
                cur = cur.next;
            }
            while (!ans.isEmpty()) {
                cur.next = new ListNode(ans.pop());
                cur = cur.next;
            }

            return head.next;
        }

        private void stack(Deque<ListNode> stack, ListNode node) {
            ListNode cur = node;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}