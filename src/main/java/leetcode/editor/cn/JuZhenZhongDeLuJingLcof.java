//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
// 如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 278 👎 0

package leetcode.editor.cn;

public class JuZhenZhongDeLuJingLcof {

    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int m, n;

        public boolean exist(char[][] board, String word) {

            m = board.length;
            n = board[0].length;
            char[] chars = word.toCharArray();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == chars[0]) {
                        board[i][j] = '/';
                        if (dfs(i, j, 1, board, chars)) {
                            return true;
                        }
                        board[i][j] = chars[0];
                    }
                }
            }
            return false;
        }

        private boolean dfs(int x, int y, int index, char[][] board, char[] chars) {
            if (index == chars.length) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == chars[index]) {
                    board[nx][ny] = '/';
                    if (dfs(nx, ny, index + 1, board, chars)) {
                        return true;
                    }
                    board[nx][ny] = chars[index];
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 深度优先搜索 + 剪枝
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int row, int col, int k) {
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[row][col] = '\0';
        boolean res =
            dfs(board, word, row + 1, col, k + 1) || dfs(board, word, row - 1, col, k + 1) || dfs(board, word, row, col + 1, k + 1) || dfs(
                board, word, row, col - 1, k + 1);
        board[row][col] = word[k];
        return res;
    }
}