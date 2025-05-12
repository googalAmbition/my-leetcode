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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Subsets {

    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[] {1, 2, 3, 4, 5, 6});
        List<List<String>> all =
                subsets.stream().map(x -> x.stream().map(y -> y == 6 ? "all" : "r" + y).collect(Collectors.toList()))
                        .collect(Collectors.toList());

        Map<String, Integer> index = Map.of("r1", 1, "r2", 2, "r3", 3, "r4", 4, "r5", 5, "all", 0);

        List<String> ans = new ArrayList<>();
        for (List<String> l : all) {
            for (List<String> r : all) {
                Optional<Integer> max = l.stream().map(index::get).max(Comparator.comparingInt(x -> x));
                Optional<Integer> min = r.stream().map(index::get).min(Comparator.comparingInt(x -> x));
                if (max.isEmpty() || min.isEmpty()) {
                    continue;
                }
                if (max.get() < min.get()) {
                    // 维度
                    String ls = l.stream().map(x -> "all".equals(x) ? "CHANCE" : x.toUpperCase()).collect(Collectors.joining(","));
                    String rs = r.stream().filter(x->!"all".equals(x)).map(String::toUpperCase).collect(Collectors.joining(","));
                    // 本品
                    String lo = l.stream().map(x -> "all".equals(x) ? "((!l_all)&s)" : "l_" + x).collect(Collectors.joining("|"));
                    String ro = r.stream().filter(x->!"all".equals(x)).map(x ->  "r_" + x).collect(Collectors.joining("|"));
                    String o = "(" + lo + ")&(" + ro + ")";


                    //竞品
                    String clo = l.stream().map(x -> "all".equals(x) ? "((!cl_all)&cr_all)" : "cl_" + x).collect(Collectors.joining("|"));
                    String cro = r.stream().filter(x->!"all".equals(x)).map(x ->  "cr_" + x).collect(Collectors.joining("|"));

                    String co = "(" + clo + ")&(" + cro + ")";
                    String format =
                            String.format(
                                    " ('%s', '%s', coBitmapBlockCount('%s')(tag, high_32bits, block_offset, bitmap),"
                                            + "coBitmapBlockCount('%s')(tag, high_32bits, block_offset, bitmap),"
                                            + "coBitmapBlockCount('%s')(tag, high_32bits, block_offset,bitmap),"
                                            + "coBitmapBlockCount('%s')(tag, high_32bits, block_offset, bitmap))",
                                    ls, rs, o, lo, co, clo);

                    ans.add(format);
                }
            }
        }

        System.out.println(ans.subList(0, 25));
        System.out.println(ans.subList(25, 50));
        System.out.println(ans.subList(50, 75));
        System.out.println(ans.subList(75, 100));
        System.out.println(ans.subList(100, 129));

        //
        //
        // System.out.println(subsets.size());
        // System.out.println(
        //         subsets.stream().map(x -> x.stream().map(y -> y == 6 ? "o" : "r" + y).collect(Collectors.toList()))
        //                 .collect(Collectors.toList()));
        // System.out.println(subsets);
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

        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> subsets(int[] nums) {
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
}