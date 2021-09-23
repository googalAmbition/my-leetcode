//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角
//移动到右下角的路径。 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释: 
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角） 
//
// 说明：r 和 c 的值均不超过 100。 
// Related Topics 数组 动态规划 回溯 矩阵 
// 👍 65 👎 0

// 迷路的机器人
package leetcode.editor.cn.day05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RobotInAGridLcci {

    public static void main(String[] args) {
        Solution solution = new RobotInAGridLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        LinkedList<List<Integer>> list = new LinkedList<>();

        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {

            dfs(obstacleGrid, 0, 0);
            return list;
        }

        public boolean dfs(int[][] obstacleGrid, int x, int y) {
            if (x < 0 || x >= obstacleGrid.length ||
                y < 0 || y >= obstacleGrid[0].length ||
                obstacleGrid[x][y] != 0) {
                return false;
            }
            obstacleGrid[x][y] = 1;                //设置为访问过
            list.add(Arrays.asList(x, y));          //添加这个点
            if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
                return true;           //到终点了
            }
            if (dfs(obstacleGrid, x + 1, y)) {   //是否这条路径可以到终点
                return true;
            }
            if (dfs(obstacleGrid, x, y + 1)) {   //是否这条路径可以到终点
                return true;
            }
            list.removeLast();                    //从这个点出发无法到达终点，移除这个点
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}