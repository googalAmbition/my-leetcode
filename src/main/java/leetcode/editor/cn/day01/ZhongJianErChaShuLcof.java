//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 370 👎 0

package leetcode.editor.cn.day01;

import leetcode.editor.cn.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof {

    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();

        int[] in = {4, 2, 5, 1, 6, 3, 7};
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        solution.buildTree(pre, in);
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

        private Map<Integer, Integer> indexMap;

        public TreeNode myBuildTree(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft) {
            if (preorderLeft > preorderRight) {
                return null;
            }

            // 在中序遍历中定位根节点
            int inorderRoot = indexMap.get(preorder[preorderLeft]);

            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorderLeft]);
            // 得到左子树中的节点数目
            int sizeLeftSubtree = inorderRoot - inorderLeft;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 sizeLeftSubtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, 0, n - 1, 0);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}