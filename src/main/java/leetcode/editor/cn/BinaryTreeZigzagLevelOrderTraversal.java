//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 666 👎 0

// 二叉树的锯齿形层序遍历
package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

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

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            boolean flag = true;
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> line = new ArrayList<>();
                while (size > 0) {
                    TreeNode treeNode;
                    if (flag) {
                        treeNode = deque.pollFirst();
                        if (treeNode.left != null) {
                            deque.addLast(treeNode.left);
                        }
                        if (treeNode.right != null) {
                            deque.addLast(treeNode.right);
                        }
                    } else {
                        treeNode = deque.pollLast();
                        if (treeNode.right != null) {
                            deque.addFirst(treeNode.right);
                        }
                        if (treeNode.left != null) {
                            deque.addFirst(treeNode.left);
                        }
                    }
                    line.add(treeNode.val);
                    size--;
                }
                ans.add(line);
                flag = !flag;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}