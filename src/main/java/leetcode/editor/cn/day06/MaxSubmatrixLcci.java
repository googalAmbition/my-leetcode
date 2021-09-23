//给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。 
//
// 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满
//足条件的子矩阵，返回任意一个均可。 
//
// 注意：本题相对书上原题稍作改动 
//
// 示例： 
//
// 输入：
//[
//   [-1,0],
//   [0,-1]
//]
//输出：[0,1,0,1]
//解释：输入中标粗的元素即为输出所表示的矩阵 
//
// 
//
// 说明： 
//
// 
// 1 <= matrix.length, matrix[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 前缀和 
// 👍 91 👎 0

// 最大子矩阵
package leetcode.editor.cn.day06;

public class MaxSubmatrixLcci {

    public static void main(String[] args) {
        Solution solution = new MaxSubmatrixLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] getMaxMatrix(int[][] matrix) {
            int M = matrix.length;
            int N = matrix[0].length;
            int[][][] DP = new int[N][N][M];
            int[][][] ST = new int[N][N][M];
            int max = matrix[0][0], sx = 0, sy = 0, ex = 0, ey = 0;
            for (int j = 0; j < N; j++) {
                DP[j][j][0] = matrix[0][j];
                if (max < DP[j][j][0]) {
                    max = DP[j][j][0];
                    sy = j;
                    ey = j;
                }
            }
            for (int i = 1; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (DP[j][j][0] > 0) { DP[j][j][i] = DP[j][j][0] + matrix[i][j]; } else {
                        DP[j][j][i] = matrix[i][j];
                        ST[j][j][i] = i;
                    }
                    if (max < DP[j][j][i]) {
                        max = DP[j][j][i];
                        sx = ST[j][j][i];
                        ex = i;
                        sy = j;
                        ey = j;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    DP[j][k][0] = DP[j][k - 1][0] + matrix[0][k];
                    if (max < DP[j][k][0]) {
                        max = DP[j][k][0];
                        sx = 0;
                        ex = 0;
                        sy = j;
                        ey = k;
                    }
                }
            }
            for (int i = 1; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = matrix[i][j];
                    for (int k = j + 1; k < N; k++) {
                        sum += matrix[i][k];
                        if (DP[j][k][i - 1] > 0) {
                            DP[j][k][i] = DP[j][k][i - 1] + sum;
                            ST[j][k][i] = ST[j][k][i - 1];
                        } else {
                            DP[j][k][i] = sum;
                            ST[j][k][i] = i;
                        }
                        if (max < DP[j][k][i]) {
                            max = DP[j][k][i];
                            sx = ST[j][k][i];
                            ex = i;
                            sy = j;
                            ey = k;
                        }
                    }
                }
            }
            return new int[] {sx, sy, ex, ey};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}