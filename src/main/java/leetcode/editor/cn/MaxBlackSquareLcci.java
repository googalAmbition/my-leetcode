//给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。 
//
// 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 
//最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//   [1,0,1],
//   [0,0,1],
//   [0,0,1]
//]
//输出: [1,0,2]
//解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
// 
//
// 示例 2: 
//
// 输入:
//[
//   [0,1,1],
//   [1,0,1],
//   [1,1,0]
//]
//输出: [0,0,1]
// 
//
// 提示： 
//
// 
// matrix.length == matrix[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 31 👎 0

// 最大黑方阵
package leetcode.editor.cn;

public class MaxBlackSquareLcci {

    public static void main(String[] args) {
        Solution solution = new MaxBlackSquareLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int M = 0;
        private int N = 0;

        public int[] findSquare(int[][] matrix) {
            M = matrix.length;
            N = matrix[0].length;
            int maxSize = 0, r = -1, c = -1;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] == 1 || Math.min(M - i, N - j) <= maxSize) {
                        continue;
                    }
                    int max = getMax(i, j, matrix);
                    if (max > maxSize) {
                        r = i;
                        c = j;
                        maxSize = max;
                    }
                }
            }
            return maxSize == 0 ? new int[0] : new int[] {r, c, maxSize};
        }

        private int getMax(int x, int y, int[][] matrix) {
            int ret = 1;
            LAB:
            for (int len = 1; len < Math.min(M - x, N - y); len++) {
                boolean flag = true;
                for (int k = 0; k <= len; k++) {
                    if (matrix[x + k][y] != 0 || matrix[x][y + k] != 0) {
                        break LAB;
                    }
                    if (matrix[x + len][y + k] != 0 || matrix[x + k][y + len] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ret = len + 1;
                }
            }
            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}