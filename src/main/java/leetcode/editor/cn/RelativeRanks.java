//给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。 
//
// 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况： 
//
// 
// 名次第 1 的运动员获金牌 "Gold Medal" 。 
// 名次第 2 的运动员获银牌 "Silver Medal" 。 
// 名次第 3 的运动员获铜牌 "Bronze Medal" 。 
// 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。 
// 
//
// 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：score = [5,4,3,2,1]
//输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
//解释：名次为 [1ˢᵗ, 2ⁿᵈ, 3ʳᵈ, 4ᵗʰ, 5ᵗʰ] 。 
//
// 示例 2： 
//
// 
//输入：score = [10,3,8,9,4]
//输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
//解释：名次为 [1ˢᵗ, 5ᵗʰ, 3ʳᵈ, 2ⁿᵈ, 4ᵗʰ] 。
// 
//
// 
//
// 提示： 
//
// 
// n == score.length 
// 1 <= n <= 10⁴ 
// 0 <= score[i] <= 10⁶ 
// score 中的所有值 互不相同 
// 
//
// Related Topics 数组 排序 堆（优先队列） 👍 182 👎 0

// 相对名次
package leetcode.editor.cn;

import java.util.Arrays;

public class RelativeRanks {

    public static void main(String[] args) {
        Solution solution = new RelativeRanks().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String[] findRelativeRanks(int[] score) {
            int n = score.length;
            String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
            int[][] arr = new int[n][2];

            for (int i = 0; i < n; ++i) {
                arr[i][0] = score[i];
                arr[i][1] = i;
            }
            Arrays.sort(arr, (a, b) -> b[0] - a[0]);
            String[] ans = new String[n];
            for (int i = 0; i < n; ++i) {
                if (i >= 3) {
                    ans[arr[i][1]] = Integer.toString(i + 1);
                } else {
                    ans[arr[i][1]] = desc[i];
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}