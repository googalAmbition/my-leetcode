//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// 👍 806 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            backtrack(k, n, 1, new ArrayList<>());
            return res;
        }

        private void backtrack(int k, int n, int start, List<Integer> curr) {
            if (k == 0 && n == 0) {
                // 满足条件，加入结果列表
                res.add(new ArrayList<>(curr));
                return;
            }
            // 剪枝
            for (int i = start; i <= 9; i++) {
                // 从start出发，避免重复，进行回溯
                if (n - i >= 0) {
                    // 剪枝
                    curr.add(i);
                    backtrack(k - 1, n - i, i + 1, curr);
                    curr.remove(curr.size() - 1);
                }
            }

        }
    }

    //leetcode submit region end(Prohibit modification and deletion)


    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum31(int k, int n) {
        dfs(new ArrayList<>(), k, n);
        return ans;
    }

    private void dfs(List<Integer> nums, int k, int n) {
        if (k == nums.size() && n == 0) {
            ArrayList<Integer> re = new ArrayList<>(nums);
            re.sort(Comparator.comparingInt(a -> a));
            ans.add(re);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (nums.size() == k || n < 0 || nums.contains(i)) {
                return;
            }
            nums.add(i);
            n = n - i;
            dfs(nums, k, n);
            n = n + i;
            nums.remove(nums.size() - 1);


        }

    }

} 
