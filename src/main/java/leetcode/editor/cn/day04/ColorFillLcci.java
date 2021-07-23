//编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。 
//
// 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。 
//
// 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。 
//
// 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。 
//
// 
//
// 示例： 
//
// 
//输入：
//image = [[1,1,1],[1,1,0],[1,0,1]] 
//sr = 1, sc = 1, newColor = 2
//输出：[[2,2,2],[2,2,0],[2,0,1]]
//解释: 
//初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
//初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
//注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
// 
//
// 
//
// 提示： 
//
// 
// image 和 image[0] 的长度均在范围 [1, 50] 内。 
// 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。 
// image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 
// 👍 33 👎 0

// 颜色填充
package leetcode.editor.cn.day04;

import java.util.Arrays;

public class ColorFillLcci {

    public static void main(String[] args) {
        Solution solution = new ColorFillLcci().new Solution();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(solution.floodFill(image, 1, 1, 2)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            //新值和旧值相等就没必要图了
            if (newColor == image[sr][sc]) {
                return image;
            }

            dfs(image, sr, sc, newColor, image[sr][sc]);
            return image;
        }

        public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
            //越界或者这个点不能图就返回
            if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != oldColor) {
                return;
            }
            //图色+四个方向扩散
            image[sr][sc] = newColor;
            dfs(image, sr - 1, sc, newColor, oldColor);
            dfs(image, sr + 1, sc, newColor, oldColor);
            dfs(image, sr, sc - 1, newColor, oldColor);
            dfs(image, sr, sc + 1, newColor, oldColor);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}