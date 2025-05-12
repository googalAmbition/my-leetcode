//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// 👍 508 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 0;

        public int totalNQueens(int n) {
            int[][] board = new int[n][n];
            for (int[] ints : board) {
                Arrays.fill(ints, 0);
            }
            dfs(board, 0);
            return ans;
        }

        private void dfs(int[][] board, int row) {

            if (row == board.length) {
                ans = ans + 1;
                return;
            }
            for (int col = 0; col < board.length; col++) {
                if (!isValid(board, row, col)) {
                    continue;
                }
                board[row][col] = 1;
                dfs(board, row + 1);
                board[row][col] = 0;

            }

        }


        private boolean isValid(int[][] board, int row, int col) {
            int n = board.length;
            for (int i = 0; i < n; i++) {
                if (board[i][col] == 1) {
                    return false;
                }
            }

            //左上
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 1) {
                    return false;
                }
            }

            //右上
            for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }

            return true;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
