//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不
//应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。 
//
// 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,0,2], low = 1, high = 2
//输出：[1,null,2]
// 
//
// 示例 2： 
//
/**
 * 3
 * 0       4
 * 2
 * 1
 */
// 
//输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//输出：[3,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 10⁴] 内 
// 0 <= Node.val <= 10⁴ 
// 树中每个节点的值都是 唯一 的 
// 题目数据保证输入是一棵有效的二叉搜索树 
// 0 <= low <= high <= 10⁴ 
// 
//
// 👍 921 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

public class TrimABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new TrimABinarySearchTree().new Solution();
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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            // 找到第一个满足条件节点
            while (root != null && (root.val < low || root.val > high)) {
                if (root.val < low) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
            if (root == null) {
                return null;
            }

            // 左子树处理
            TreeNode treeNode = root;
            while (treeNode.left != null) {
                // 左子树小于边界,取右子树
                if (treeNode.left.val < low) {
                    treeNode.left = treeNode.left.right;
                } else {
                    treeNode = treeNode.left;
                }
            }

            TreeNode node = root;
            while (node.right != null) {
                if (node.right.val > high) {
                    node.right = node.right.left;
                } else {
                    node = node.right;
                }
            }
            return root;
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
