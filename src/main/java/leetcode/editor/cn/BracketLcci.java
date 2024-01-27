//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。 
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 77 👎 0

// 括号
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BracketLcci {

    public static void main(String[] args) {
        Solution solution = new BracketLcci().new Solution();
        solution.generateParenthesis(3).forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final ArrayList<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n, 0, 0, "");
            return res;
        }

        //DFS模板
        public void dfs(int n, int leftNum, int rightNum, String str) {
            //出口一：判断不满足条件的情况，主要从左右括号数量上判断，三种情况。
            if (leftNum < rightNum || leftNum > n) {
                return;
            }
            //出口二：满足条件，即左右括号数量相等且已经达到最大值。
            if (leftNum == rightNum && rightNum == n) {
                res.add(str);
            }
            //否则
            else {
                //一定要先加左括号，再加右括号；
                //加完左括号后，左括号数量加1,回溯；
                dfs(n, leftNum + 1, rightNum, str + "(");

                //再加右括号，然后dfs，再回溯。
                dfs(n, leftNum, rightNum + 1, str + ")");
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}