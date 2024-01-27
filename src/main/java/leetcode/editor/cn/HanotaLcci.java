//在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只
//能放在更大的盘子上面)。移动圆盘时受到以下限制: 
//(1) 每次只能移动一个盘子; 
//(2) 盘子只能从柱子顶端滑出移到下一根柱子; 
//(3) 盘子只能叠在比它大的盘子上。 
//
// 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。 
//
// 你需要原地修改栈。 
//
// 示例1: 
//
//  输入：A = [2, 1, 0], B = [], C = []
// 输出：C = [2, 1, 0]
// 
//
// 示例2: 
//
//  输入：A = [1, 0], B = [], C = []
// 输出：C = [1, 0]
// 
//
// 提示: 
//
// 
// A中盘子的数目不大于14个。 
// 
// Related Topics 递归 数组 
// 👍 105 👎 0

// 汉诺塔问题
package leetcode.editor.cn;

import java.util.List;

public class HanotaLcci {

    public static void main(String[] args) {
        Solution solution = new HanotaLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
            movePlant(A.size(), A, B, C);
        }

        //size 需要移动的盘子的数量
        //start 起始的柱子
        //auxiliary 辅助柱子
        //target 目标柱子
        public void movePlant(int size, List<Integer> start, List<Integer> auxiliary, List<Integer> target) {
            //当只剩一个盘子时，直接将它从第一个柱子移动到第三个柱子
            if (size == 1) {
                target.add(start.remove(start.size() - 1));
                return;
            }
            //首先将 n-1 个盘子，从第一个柱子移动到第二个柱子
            movePlant(size - 1, start, target, auxiliary);
            //然后将最后一个盘子移动到第三个柱子上
            target.add(start.remove(start.size() - 1));
            //最后将第二个柱子上的 n-1 个盘子，移动到第三个柱子上
            movePlant(size - 1, auxiliary, start, target);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}