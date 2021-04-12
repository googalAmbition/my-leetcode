//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 115 👎 0

package leetcode.editor.cn.day01;

import leetcode.editor.cn.struct.ListNode;

public class CongWeiDaoTouDaYinLianBiaoLcof {

    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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

        public int[] reversePrint(ListNode head) {
            if (head == null) {
                return new int[0];
            }
            ListNode cur = head;
            ListNode pre = null;
            int num = 0;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                num++;
            }
            int[] result = new int[num];
            for (int i = 0; i < num; i++) {

                result[i] = pre.val;
                pre = pre.next;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}