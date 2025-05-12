//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
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
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 594 👎 0

// 二叉树的层序遍历 II
package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {

    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
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

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> line = new ArrayList<>();
                while (size > 0) {
                    TreeNode treeNode = deque.pollFirst();
                    if (treeNode.left != null){
                        deque.addLast(treeNode.left);
                    }
                    if (treeNode.right != null){
                        deque.addLast(treeNode.right);
                    }
                    line.add(treeNode.val);
                    size--;
                }
                ans.add(line);
            }
            Collections.reverse(ans);
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}