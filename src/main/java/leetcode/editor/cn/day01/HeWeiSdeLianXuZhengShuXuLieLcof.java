//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 230 👎 0

// 和为s的连续正数序列
package leetcode.editor.cn.day01;

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof {

    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        solution.findContinuousSequence(9);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] findContinuousSequence(int target) {
            List<int[]> vec = new ArrayList<>();
            for (int start = 1, end = 2; start < end; ) {
                int sum = (start + end) * (end - start + 1) / 2;
                if (sum == target) {
                    int[] res = new int[end - start + 1];
                    for (int i = start; i <= end; ++i) {
                        res[i - start] = i;
                    }
                    vec.add(res);
                    start++;
                } else if (sum < target) {
                    end++;
                } else {
                    start++;
                }
            }
            return vec.toArray(new int[vec.size()][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}