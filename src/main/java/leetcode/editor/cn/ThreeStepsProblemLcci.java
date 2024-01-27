//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 59 👎 0

// 三步问题
package leetcode.editor.cn;

public class ThreeStepsProblemLcci {

    public static void main(String[] args) {
        Solution solution = new ThreeStepsProblemLcci().new Solution();
        System.out.println(solution.waysToStep(3));
        System.out.println(solution.waysToStep(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int waysToStep(int n) {
            if (n < 3) {
                return n;
            }
            int[] re = new int[n];
            re[0] = 1;
            re[1] = 2;
            re[2] = 4;
            for (int i = 3; i < n; i++) {
                re[i] = (re[i - 1] + re[i - 2]) % 1000000007 + re[i - 3];
                re[i] %= 1000000007;
            }
            return re[n - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}