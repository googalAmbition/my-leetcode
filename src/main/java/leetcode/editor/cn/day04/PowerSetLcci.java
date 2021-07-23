//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// 
// Related Topics 位运算 数组 回溯 
// 👍 67 👎 0

// 幂集
package leetcode.editor.cn.day04;

import java.util.ArrayList;
import java.util.List;

public class PowerSetLcci {

    public static void main(String[] args) {
        Solution solution = new PowerSetLcci().new Solution();
        int[] nums = {1, 2, 3};
        solution.subsets(nums).forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            int len = (int) Math.pow(2, nums.length);
            List<List<Integer>> re = new ArrayList<>();
            re.add(new ArrayList<>());
            for (int i = 1; i < len; i++) {
                int size = nums.length - 1;
                int index = i;
                List<Integer> element = new ArrayList<>();
                while (size >= 0) {
                    if ((index & 1) == 1) {
                        element.add(nums[size]);
                    }
                    index = index >>> 1;
                    size--;
                }
                re.add(element);
            }
            return re;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}