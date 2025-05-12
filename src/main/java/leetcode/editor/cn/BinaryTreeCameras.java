//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
//
// 👍 713 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

public class BinaryTreeCameras {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeCameras().new Solution();
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
        int result = 0;

        public int minCameraCover(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //如果根节点看不见 需要加一
            if (dfs(root) == -1) {
                result++;
            }
            return result;
        }

        private int dfs(TreeNode node) {
            //如果当前节点为空 也是终止条件
            if (node == null) {
                return 0;
            }
            //后续遍历 左 右 根
            int left = dfs(node.left);
            int right = dfs(node.right);
            //当前节点
            //1 是相机 0 是看得到 -1 是看不到
            //三种情况
            // 需要传递的信息有三种：1.要求父节点安装相机；2.说自己有相机；3.自己不需要相机或空节点；
            // 1. 如果孩子都已经看看到 不需要 需要返回当前看不到 -1
            // 2.如果孩子有一部分看不到 当前节点需要摄像头 返回 1
            //3.如果孩子都看得到 且部分孩子有相机，当前节点返回 0

            //如果孩子有一部分看不到 当前节点需要摄像头 返回 1
            if (left == -1 || right == -1) {
                result++;
                return 1;
                //说明上面都看得到 就得判断 孩子是否有相机
            } else if (left == 1 || right == 1) {
                return 0;
            } else {
                //否则孩子没相机，且都看得到
                return -1;
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
