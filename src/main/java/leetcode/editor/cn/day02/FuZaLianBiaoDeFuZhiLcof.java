//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 链表 
// 👍 186 👎 0

// 复杂链表的复制
package leetcode.editor.cn.day02;

import leetcode.editor.cn.struct.Node;

public class FuZaLianBiaoDeFuZhiLcof {

    public static void main(String[] args) {
        Solution solution = new FuZaLianBiaoDeFuZhiLcof().new Solution();
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        solution.copyRandomList(node0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
    class Solution {

        public Node copyRandomList(Node head) {
            if (head==null){
                return null;
            }
            Node copy = head;
            while (copy != null) {
                Node next = copy.next;
                Node node = new Node(copy.val);
                copy.next = node;
                node.next = next;
                copy = next;
            }
            Node copyR = head;

            while (copyR != null) {
                Node next = copyR.next;
                if (copyR.random != null) {
                    Node random = copyR.random;
                    next.random = random.next;
                }
                copyR = next.next;
            }

            Node curOld = head;
            Node newHead = head.next;
            Node newCur = newHead;
            while (newCur.next != null) {
                Node next = newCur.next;
                Node newNext = next.next;

                curOld.next = next;
                newCur.next = newNext;

                newCur = newCur.next;
                curOld = curOld.next;
            }
            curOld.next = null;
            newCur.next = null;

            return newHead;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}