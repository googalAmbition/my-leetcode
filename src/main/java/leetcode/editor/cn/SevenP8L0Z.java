//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
//
// Related Topics 数组 回溯 👍 35 👎 0

// 含有重复元素集合的全排列
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SevenP8L0Z {

    public static void main(String[] args) {
        Solution solution = new SevenP8L0Z().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[] vis;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        public List<List<Integer>> permuteUnique(int[] nums) {

            List<Integer> perm = new ArrayList<>();
            vis = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums, 0, perm);
            return ans;
        }

        public void backtrack(int[] nums, int idx, List<Integer> perm) {
            if (idx == nums.length) {
                ans.add(new ArrayList<Integer>(perm));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                    continue;
                }
                perm.add(nums[i]);
                vis[i] = true;
                backtrack(nums, idx + 1, perm);
                vis[i] = false;
                perm.remove(idx);
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}