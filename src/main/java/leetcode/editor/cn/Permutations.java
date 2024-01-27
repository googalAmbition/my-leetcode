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
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.permute(nums).forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final List<List<Integer>> re = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums.length == 0) {
                return new ArrayList<>();
            }
            List<Integer> output = new ArrayList<Integer>();
            for (int num: nums) {
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

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num: nums) {
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