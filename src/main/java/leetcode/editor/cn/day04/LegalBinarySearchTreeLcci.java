//实现一个函数，检查一棵二叉树是否为二叉搜索树。示例 1: 输入:     2    / \   1   3 输出: true 示例 2: 输入:     5
//    / \   1   4      / \     3   6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。    
//  根节点的值为 5 ，但是其右子节点值为 4 。 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 55 👎 0

// 合法二叉搜索树
package leetcode.editor.cn.day04;

import leetcode.editor.cn.struct.TreeNode;

public class LegalBinarySearchTreeLcci {

    public static void main(String[] args) {
        Solution solution = new LegalBinarySearchTreeLcci().new Solution();
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

        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null) {
                return true;
            }

            int val = node.val;
            if (lower != null && val <= lower) {
                return false;
            }
            if (upper != null && val >= upper) {
                return false;
            }

            if (!helper(node.right, val, upper)) {
                return false;
            }
            return helper(node.left, lower, val);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}