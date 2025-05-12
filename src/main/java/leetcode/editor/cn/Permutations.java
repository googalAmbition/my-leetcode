//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1294 👎 0

// 全排列
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] nums = new int[] {1, 2, 3, 4};
        Permutations permutations = new Permutations();
        permutations.permutev2(nums).forEach(System.out::println);

        // solution.permute(nums).forEach(System.out::println);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> re = new ArrayList<>();


        public List<List<Integer>> permute2(int[] nums) {
            dfs1(nums, new ArrayList<>(), 0);
            return re;
        }

        private void dfs1(int[] nums, List<Integer> set, int index) {
            if (set.size() == nums.length) {
                re.add(new ArrayList<>(set));
                return;
            }
            for (int i = index; i < nums.length; i++) {
                set.add(nums[i]);
                dfs1(nums, set, i + 1);
                set.remove(set.size() - 1);

            }

        }


        List<Integer> nums;
        List<List<Integer>> res;

        void swap(int a, int b) {
            int tmp = nums.get(a);
            nums.set(a, nums.get(b));
            nums.set(b, tmp);
        }

        void dfs(int x) {
            if (x == nums.size() - 1) {
                res.add(new ArrayList<>(nums));  // 添加排列方案
                return;
            }
            for (int i = x; i < nums.size(); i++) {
                swap(i, x);              // 交换，将 nums[i] 固定在第 x 位
                dfs(x + 1);              // 开启固定第 x + 1 位元素
                swap(i, x);              // 恢复交换
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            this.res = new ArrayList<>();
            this.nums = new ArrayList<>();
            for (int num : nums) {
                this.nums.add(num);
            }
            dfs(0);
            return res;
        }


        public List<List<Integer>> permute1(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }
            List<Integer> output = new ArrayList<Integer>();
            for (int num : nums) {
                output.add(num);
            }
            dfs(nums, 0, output);
            return re;
        }

        private void dfs(int[] nums, int first, List<Integer> element) {
            if (first == nums.length) {
                re.add(new ArrayList<>(element));
                return;
            }
            for (int i = first; i < nums.length; i++) {
                Collections.swap(element, i, first);
                dfs(nums, first + 1, element);
                Collections.swap(element, i, first);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permutev2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        dfs(list, 0);
        return res;
    }

    public void dfs(List<Integer> nums, int index) {

        if (index == nums.size()) {
            res.add(new ArrayList<>(nums));
        }
        for (int i = index; i < nums.size(); i++) {
            Collections.swap(nums, i, index);
            dfs(nums, index + 1);
            Collections.swap(nums, i, index);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int length, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == length) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < length; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(length, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}