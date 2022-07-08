//给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差不超过 1。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [-10,-3,0,5,9]
//输出: [0,-3,9,-10,null,5]
//解释: 一个可能的答案是[0，-3,9，-10,null,5]，它表示所示的高度平衡的二叉搜索树。
// 
//
// 示例 2: 
//
// 
//输入: head = []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// head 中的节点数在[0, 2 * 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 二叉搜索树 链表 分治 二叉树 👍 712 👎 0

// 有序链表转换二叉搜索树
package leetcode.editor.cn;

import leetcode.editor.cn.struct.ListNode;
import leetcode.editor.cn.struct.TreeNode;

public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        Solution solution = new ConvertSortedListToBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        ListNode globalHead;

        public TreeNode sortedListToBST(ListNode head) {
            globalHead = head;
            int length = getLength(head);
            return buildTree(0, length - 1);
        }

        public int getLength(ListNode head) {
            int ret = 0;
            while (head != null) {
                ++ret;
                head = head.next;
            }
            return ret;
        }

        public TreeNode buildTree(int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = (left + right + 1) / 2;
            TreeNode root = new TreeNode();
            root.left = buildTree(left, mid - 1);
            root.val = globalHead.val;
            globalHead = globalHead.next;
            root.right = buildTree(mid + 1, right);
            return root;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}