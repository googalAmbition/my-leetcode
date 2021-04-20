//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 213 👎 0

// 顺时针打印矩阵
package leetcode.editor.cn.day02;

public class ShunShiZhenDaYinJuZhenLcof {

    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.spiralOrder(test);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] spiralOrder(int[][] matrix) {

            int row = matrix.length;
            if (row == 0) {
                return new int[0];
            }
            int col = matrix[0].length;
            int[] result = new int[row * col];

            int rowMin = 0, colMin = 0;
            int index = 0;

            while (colMin < col && rowMin < row) {

                for (int k = colMin; k < col; k++) {
                    result[index] = matrix[colMin][k];
                    index++;
                }
                rowMin++;
                if (rowMin == row) {
                    break;
                }
                for (int k = rowMin; k < row; k++) {
                    result[index] = matrix[k][col - 1];
                    index++;
                }
                col--;
                if (colMin == col) {
                    break;
                }
                for (int k = col - 1; k >= colMin; k--) {
                    result[index] = matrix[row - 1][k];
                    index++;
                }
                row--;
                for (int k = row - 1; k >= rowMin; k--) {
                    result[index] = matrix[k][colMin];
                    index++;
                }
                colMin++;
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}