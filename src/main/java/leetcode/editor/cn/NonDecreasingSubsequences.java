//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// 👍 773 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NonDecreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new NonDecreasingSubsequences().new Solution();
        // int[] nums = {4, 4, 3, 2, 1};
        int[] nums = {9,10,1,1,1,1,1};
        // int[] nums = {4, 6, 7, 7, 7};
        System.out.println(solution.findSubsequences(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // List<List<Integer>> ans = new ArrayList<>();
        //
        // public List<List<Integer>> findSubsequences(int[] nums) {
        //
        //     dfs(nums, 0, new ArrayList<>());
        //     return ans;
        // }
        //
        // void dfs(int[] nums, int index, List<Integer> list) {
        //     if (list.size() > 1) {
        //         ans.add(new ArrayList<>(list));
        //     }
        //     int[] used = new int[201];
        //     for (int i = index; i < nums.length; i++) {
        //         if ((used[nums[i] + 100] == 1 )||( list.size() > 0 && list.get(list.size() - 1) > nums[i])) {
        //             continue;
        //         }
        //         used[nums[i] + 100] = 1;
        //         list.add(nums[i]);
        //         dfs(nums, i + 1, list);
        //         list.remove(list.size() - 1);
        //
        //     }
        // }


        private List<Integer> path = new ArrayList<>();
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backtracking(nums, 0);
            return res;
        }

        private void backtracking(int[] nums, int start) {
            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }

            int[] used = new int[201];
            for (int i = start; i < nums.length; i++) {
                if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1)) || (used[nums[i] + 100] == 1)) {
                    continue;
                }
                used[nums[i] + 100] = 1;
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)


} 
