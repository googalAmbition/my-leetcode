//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。 
//
// 示例1: 
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
// 
//
// 示例2: 
//
//  输入：S = "ab"
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
// 👍 41 👎 0

// 有重复字符串的排列组合
package leetcode.editor.cn;

import java.util.HashSet;

public class PermutationIiLcci {

    public static void main(String[] args) {
        Solution solution = new PermutationIiLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String[] permutation(String S) {
            HashSet<String> arrayList = new HashSet<String>();
            dfs(S, arrayList, 0, "", new boolean[S.length()]);
            return arrayList.toArray(new String[0]);
        }

        private void dfs(String s, HashSet<String> list, int step, String curS, boolean[] visit) {
            if (step == s.length()) {
                list.add(curS);
                return;
            }
            for (int i = 0, n = s.length(); i < n; i++) {
                if (visit[i]) {
                    continue;
                }
                visit[i] = true;
                dfs(s, list, step + 1, curS + s.charAt(i), visit);
                visit[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}