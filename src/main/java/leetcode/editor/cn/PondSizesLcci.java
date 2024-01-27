//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
//相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。 
// 示例： 
// 输入：
//[
//  [0,2,1,0],
//  [0,1,0,1],
//  [1,1,0,1],
//  [0,1,0,1]
//]
//输出： [1,2,4]
// 
// 提示： 
// 
// 0 < len(land) <= 1000 
// 0 < len(land[i]) <= 1000 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 69 👎 0

// 水域大小
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class PondSizesLcci {

    public static void main(String[] args) {
        Solution solution = new PondSizesLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final int[] DIR = {-1, 0, 1, 0, -1, -1, 1, 1, -1};
        private int M = 0;
        private int N = 0;
        private int[][] map = null;
        private final int MAX = 1000;
        private final int[][] queue = new int[MAX][2];

        public int[] pondSizes(int[][] land) {
            M = land.length;
            N = land[0].length;
            map = land;
            boolean[][] visit = new boolean[M][N];
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] || land[i][j] != 0) {
                        continue;
                    }
                    visit[i][j] = true;
                    arr.add(bfs(i, j, visit));
                }
            }
            int[] ret = new int[arr.size()];
            int k = 0;
            for (Integer i: arr) {
                ret[k++] = i;
            }
            Arrays.sort(ret);
            return ret;
        }

        private int bfs(int i, int j, boolean[][] visit) {
            queue[0][0] = i;
            queue[0][1] = j;
            int step = 0, end = 1, count = 1;
            while (step < end) {
                int x = queue[step][0];
                int y = queue[step][1];
                for (int k = 0; k < 8; k++) {
                    int xx = x + DIR[k];
                    int yy = y + DIR[k + 1];
                    if (xx < 0 || xx >= M || yy < 0 || yy >= N) {
                        continue;
                    }
                    if (visit[xx][yy] || map[xx][yy] != 0) {
                        continue;
                    }
                    visit[xx][yy] = true;
                    queue[end][0] = xx;
                    queue[end][1] = yy;
                    count++;
                    end++;
                    end %= MAX;
                }
                step++;
                step %= MAX;
            }
            return count;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}