//给定二叉树的根节点 root ，返回所有左叶子之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// 👍 705 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
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
        public int sumOfLeftLeaves(TreeNode root) {
            return root != null ? dfs(root) : 0;
        }

        public int dfs(TreeNode node) {
            int ans = 0;
            if (node.left != null) {
                ans += isLeafNode(node.left) ? node.left.val : dfs(node.left);
            }
            if (node.right != null && !isLeafNode(node.right)) {
                ans += dfs(node.right);
            }
            return ans;
        }

        public boolean isLeafNode(TreeNode node) {
            return node.left == null && node.right == null;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
