//一只蚂蚁坐在由白色和黑色方格构成的无限网格上。开始时，网格全白，蚂蚁面向右侧。每行走一步，蚂蚁执行以下操作。 
//
// (1) 如果在白色方格上，则翻转方格的颜色，向右(顺时针)转 90 度，并向前移动一个单位。 
//(2) 如果在黑色方格上，则翻转方格的颜色，向左(逆时针方向)转 90 度，并向前移动一个单位。 
//
// 编写程序来模拟蚂蚁执行的前 K 个动作，并返回最终的网格。 
//
// 网格由数组表示，每个元素是一个字符串，代表网格中的一行，黑色方格由 'X' 表示，白色方格由 '_' 表示，蚂蚁所在的位置由 'L', 'U', 'R',
// 'D' 表示，分别表示蚂蚁 左、上、右、下 的朝向。只需要返回能够包含蚂蚁走过的所有方格的最小矩形。 
//
// 示例 1: 
//
// 输入: 0
//输出: ["R"]
// 
//
// 示例 2: 
//
// 输入: 2
//输出:
//[
//  "_X",
//  "LX"
//]
// 
//
// 示例 3: 
//
// 输入: 5
//输出:
//[
//  "_U",
//  "X_",
//  "XX"
//]
// 
//
// 说明： 
//
// 
// K <= 100000 
// 
// Related Topics 数组 哈希表 字符串 矩阵 模拟 
// 👍 20 👎 0

// 兰顿蚂蚁
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LangtonsAntLcci {

    public static void main(String[] args) {
        Solution solution = new LangtonsAntLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private char[] STR_DIR = {'R', 'D', 'L', 'U'};
        private int DIR[] = {0, 1, 0, -1, 0};

        public List<String> printKMoves(int K) {
            long curX = 100000, curY = 100000, maxX = 100000, minX = 100000;
            int dir = 0;
            long maxY = 100001, minY = 100001;
            HashSet<Long> black = new HashSet<Long>();
            for (int i = 0; i < K; i++) {
                curX += DIR[dir];
                curY += DIR[dir + 1];
                if (curX < minX)
                    minX = curX;
                else if (curX > maxX)
                    maxX = curX;
                if (curY < minY)
                    minY = curY;
                else if (curY > maxY)
                    maxY = curY;
                long pos = (curX << 24) + curY;
                if (black.contains(pos)) {
                    black.remove(pos);
                    dir = (dir + 3) % 4;
                } else {
                    black.add(pos);
                    dir = (dir + 1) % 4;
                }
            }
            curX += DIR[dir];
            curY += DIR[dir + 1];
            if (curX < minX)
                minX = curX;
            else if (curX > maxX)
                maxX = curX;
            if (curY < minY)
                minY = curY;
            else if (curY > maxY)
                maxY = curY;
            char[][] map = new char[(int) (maxX - minX + 1)][(int) (maxY - minY + 1)];
            for (int i = 0; i < map.length; i++)
                Arrays.fill(map[i], '_');
            for (long i: black)
                map[(int) ((i >> 24) - minX)][(int) ((i & 0xffffff) - minY)] = 'X';
            map[(int) (curX - minX)][(int) (curY - minY)] = STR_DIR[dir];
            List<String> ret = new ArrayList<String>();
            for (int i = 0; i < map.length; i++)
                ret.add(new String(map[i]));
            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}