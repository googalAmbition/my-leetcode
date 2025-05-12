//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3229 👎 0

// 三数之和
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> threeSum2(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            // 枚举 a
            for (int first = 0; first < n; ++first) {
                // 需要和上一次枚举的数不相同
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                // c 对应的指针初始指向数组的最右端
                int third = n - 1;
                int target = -nums[first];
                // 枚举 b
                for (int second = first + 1; second < n; ++second) {
                    // 需要和上一次枚举的数不相同
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (second < third && nums[second] + nums[third] > target) {
                        --third;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length == 0) {
                return res;
            }
            // 先排序，让相同的元素靠在一起
            Arrays.sort(nums);
            backtrack(nums, 0, 0);
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        // 记录回溯的路径
        List<Integer> track = new ArrayList<>();
        // 记录 track 中的元素之和
        int trackSum = 0;


        // 回溯算法主函数
        void backtrack(int[] nums, int start, int target) {
            // base case，达到目标和，找到符合条件的组合
            if (trackSum == target && track.size() == 3) {
                res.add(new LinkedList<>(track));
                return;
            }
            // base case，超过目标和，直接结束
            if (track.size() > 3) {
                return;
            }

            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {
                // 剪枝逻辑，值相同的树枝，只遍历第一条
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                trackSum += nums[i];
                // 递归遍历下一层回溯树
                backtrack(nums, i + 1, target);
                // 撤销选择
                track.remove(track.size() - 1);
                trackSum -= nums[i];
            }
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)
}