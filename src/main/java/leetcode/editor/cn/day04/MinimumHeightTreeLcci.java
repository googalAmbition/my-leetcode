//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
// 示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
// 0
// / \        -3
//  9
//  /   /      -10  5
//  Related Topics 树 二叉搜索树 数组 分治 二叉树
// 👍 95 👎 0

// 最小高度树
package leetcode.editor.cn.day04;

import leetcode.editor.cn.struct.TreeNode;

public class MinimumHeightTreeLcci {

    public static void main(String[] args) {
        Solution solution = new MinimumHeightTreeLcci().new Solution();
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

        public TreeNode sortedArrayToBST(int[] nums) {
            return create(0, nums.length - 1, nums);
        }

        private TreeNode create(int start, int end, int[] nums) {
            if (start > end) {
                return null;
            } else if (start == end) {
                return new TreeNode(nums[start]);
            } else if (start + 1 == end) {
                TreeNode parent = new TreeNode(nums[end]);
                parent.left = new TreeNode(nums[start]);
                return parent;
            }
            int mid = (start + end) / 2;
            TreeNode parent = new TreeNode(nums[mid]);
            parent.left = create(start, mid - 1, nums);
            parent.right = create(mid + 1, end, nums);
            return parent;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}