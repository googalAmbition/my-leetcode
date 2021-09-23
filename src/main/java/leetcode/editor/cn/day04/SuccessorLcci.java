//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 69 👎 0

// 后继者
package leetcode.editor.cn.day04;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SuccessorLcci {

    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        solution.inorderSuccessor(treeNode2, treeNode1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        private final List<TreeNode> list = new ArrayList<>();

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            midTraversal(root);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == p && i < list.size() - 1) {
                    return list.get(i + 1);
                }
            }
            return null;
        }

        private void midTraversal(TreeNode root) {

            if (root == null) {
                return;
            }
            if (root.left != null) {
                midTraversal(root.left);
            }
            list.add(root);
            if (root.right != null) {
                midTraversal(root.right);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode cur = root;
        boolean flag = false;

        while (!stack.isEmpty() || cur != null) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();

            if (flag) {
                return node;
            }
            //记录标志位，下一个节点即输出
            if (node == p) {
                flag = true;
            }

            cur = node.right;
        }

        return null;
    }
}