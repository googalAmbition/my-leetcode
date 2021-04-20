//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 752 👎 0

// 螺旋矩阵
package leetcode.editor.cn.day03;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> spiralOrder(int[][] matrix) {
            int maxRow = matrix.length;
            int maxCol = matrix[0].length;
            int minRow = 0, minCol = 0;
            List<Integer> re = new ArrayList<>();
            while (maxRow > minRow && maxCol > minCol) {

                for (int i = minCol; i < maxCol; i++) {
                    re.add(matrix[minCol][i]);
                }
                minRow++;
                if (maxRow == minRow) {
                    break;
                }
                for (int i = minRow; i < maxRow; i++) {
                    re.add(matrix[i][maxCol - 1]);
                }
                maxCol--;
                if (minCol == maxCol) {
                    break;
                }
                for (int i = maxCol - 1; i >= minCol; i--) {
                    re.add(matrix[maxRow - 1][i]);
                }
                maxRow--;

                for (int i = maxRow - 1; i >= minRow; i--) {
                    re.add(matrix[i][minCol]);
                }
                minCol++;
            }
            return re;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}