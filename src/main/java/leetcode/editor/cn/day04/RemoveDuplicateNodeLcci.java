//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 哈希表 链表 双指针 
// 👍 111 👎 0

// 移除重复节点
package leetcode.editor.cn.day04;

import leetcode.editor.cn.struct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodeLcci {

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println(solution.removeDuplicateNodes(n1));
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

        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) {
                return head;
            }
            Set<Integer> occurred = new HashSet<>();
            occurred.add(head.val);
            ListNode pos = head;
            // 枚举前驱节点
            while (pos.next != null) {
                // 当前待删除节点
                if (occurred.add(pos.next.val)) {
                    pos = pos.next;
                } else {
                    pos.next = pos.next.next;
                }
            }
            pos.next = null;
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}