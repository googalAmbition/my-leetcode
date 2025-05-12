//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1137 👎 0

// 子集
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {

    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[] {1, 2, 3, 4, 5, 6});
        System.out.println(subsets.size());
        System.out.println(
                subsets.stream().map(x -> x.stream().map(y -> y == 6 ? "o" : "r" + y).collect(Collectors.toList()))
                        .collect(Collectors.toList()));
        System.out.println(subsets);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> subsetsv2(int[] nums) {
            int pow = (int) Math.pow(2, nums.length);
            List<List<Integer>> re = new ArrayList<>();
            re.add(new ArrayList<>());
            for (int i = 1; i < pow; i++) {
                List<Integer> list = new ArrayList<>();
                int index = 0;
                int j = i;
                while (j > 0 && index < nums.length) {
                    if ((j & 1) == 1) {
                        list.add(nums[index]);
                    }
                    index++;
                    j >>>= 1;
                }
                re.add(list);
            }
            return re;
        }


        List<List<Integer>> lists = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0) {
                return lists;
            }

            List<Integer> list = new ArrayList<>();
            process(list, nums, 0);
            return lists;

        }

        private void process(List<Integer> list, int[] nums, int start) {

            lists.add(new ArrayList<>(list));
            for (int i = start; i < nums.length; i++) {

                list.add(nums[i]);
                process(list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }


        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets1(int[] nums) {
            dfs(0, nums);
            return ans;
        }

        public void dfs(int cur, int[] nums) {
            if (cur == nums.length) {
                ans.add(new ArrayList<Integer>(t));
                return;
            }
            t.add(nums[cur]);
            dfs(cur + 1, nums);
            t.remove(t.size() - 1);
            dfs(cur + 1, nums);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 递归解法
     */
    class SolutionV2 {

        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            for (int mask = 0; mask < (1 << n); ++mask) {
                t.clear();
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        t.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<Integer>(t));
            }
            return ans;
        }

    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsets1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        process(list, nums, 0);
        return lists;

    }

    private void process(List<Integer> list, int[] nums, int start) {

        lists.add(new ArrayList(list));
        for (int i = start; i < nums.length; i++) {

            list.add(nums[i]);
            process(list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

}