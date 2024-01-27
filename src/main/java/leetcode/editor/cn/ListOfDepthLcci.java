//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 链表 二叉树 
// 👍 54 👎 0

// 特定深度节点链表
package leetcode.editor.cn;

import leetcode.editor.cn.struct.ListNode;
import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepthLcci {

    public static void main(String[] args) {
        Solution solution = new ListOfDepthLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {

        public ListNode[] listOfDepth(TreeNode tree) {

            //双层列表单独保存每一层的节点
            List<List<TreeNode>> ans = new ArrayList<>();
            if (tree == null) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(tree);
            //二叉树层序遍历
            while (!queue.isEmpty()) {
                //保存每一层节点
                List<TreeNode> list = new ArrayList<>();
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    list.add(node);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ans.add(list);
            }

            //二叉树深度,即列表元素个数
            int m = ans.size();
            //创建m个保存链表头节点的ListNode类型数组
            ListNode[] listNode = new ListNode[m];
            //遍历每一层的二叉树节点从而创建链表
            for (int j = 0; j < m; j++) {
                List<TreeNode> nodeList = ans.get(j);
                //创建虚拟节点,方便链表头节点和next节点统一处理
                ListNode dummyNode = new ListNode(-1);
                ListNode curr = dummyNode;
                for (int i = 0; i < nodeList.size(); i++) {
                    curr.next = new ListNode(nodeList.get(i).val);
                    curr = curr.next;
                }
                //保存头节点
                listNode[j] = dummyNode.next;
            }
            return listNode;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}