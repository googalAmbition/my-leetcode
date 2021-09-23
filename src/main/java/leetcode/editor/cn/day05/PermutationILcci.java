//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。 
//
// 示例1: 
//
// 
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
// 
//
// 示例2: 
//
// 
// 输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 字符串 回溯 
// 👍 49 👎 0

// 无重复字符串的排列组合
package leetcode.editor.cn.day05;

import java.util.ArrayList;
import java.util.List;

public class PermutationILcci {

    public static void main(String[] args) {
        Solution solution = new PermutationILcci().new Solution();
        solution.permutation("abcd");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final List<String> re = new ArrayList<>();
        private String s;

        public String[] permutation(String S) {
            s = S;
            dfs(0, new boolean[S.length()], "");
            return re.toArray(new String[0]);
        }

        private void dfs(int step, boolean[] visit, String cur) {
            if (step == s.length()) {
                re.add(cur);
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if (visit[i]) {
                    continue;
                }
                visit[i] = true;
                dfs(step + 1, visit, cur + s.charAt(i));
                visit[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}