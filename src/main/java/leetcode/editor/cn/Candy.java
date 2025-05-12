//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。 
//
// 你需要按照以下要求，给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻两个孩子评分更高的孩子会获得更多的糖果。 
// 
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。 
//
// 
//
// 提示： 
//
// 
// n == ratings.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= ratings[i] <= 2 * 10⁴ 
// 
//
// 👍 1484 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
        System.out.println(solution.candy(new int[] {1, 2, 2}));// 4
        System.out.println(solution.candy(new int[] {1, 0, 1})); //5
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         从左往右遍历更新右边分数(i + 1)比左边分数大的糖果为 (i) + 1，
         再反向遍历，让左边分数(i - 1)大于右边并且左边糖果小于右边糖果的情况下，更新为(i) + 1.
         */
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candys = new int[n];

            Arrays.fill(candys, 1);  //初始化为 1，因为至少有一个糖果

            for(int i = 0; i < n - 1; i++){
                if(ratings[i + 1] > ratings[i]) {
                    candys[i + 1] = candys[i] + 1;
                }
            }

            for(int i = n - 1; i >= 1; i--){
                //注意是小于等于，需要保证分数更高是更多糖果的
                if(ratings[i - 1] > ratings[i] && candys[i - 1] <= candys[i]){
                    candys[i - 1] = candys[i] + 1;
                }
            }

            int sum = 0;
            for(int index : candys){
                sum += index;
            }
            return sum;
        }

    //    1,3,2,2,1
    //    1,2,1,1,0

    }
    //leetcode submit region end(Prohibit modification and deletion)
}
