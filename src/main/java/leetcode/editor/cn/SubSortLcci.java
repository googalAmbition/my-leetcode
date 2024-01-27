//给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短
//序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。 
// 示例： 
// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//输出： [3,9]
// 
// 提示： 
// 
// 0 <= len(array) <= 1000000 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 74 👎 0

// 部分排序
package leetcode.editor.cn;

public class SubSortLcci {

    public static void main(String[] args) {
        Solution solution = new SubSortLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] subSort(int[] array) {
            int m = -1;
            int n = -1;
            int[] res = new int[2];
            int length = array.length;
            if (length > 1) {
                //从左向右遍历，如果当前元素比它之前的最大的元素小，说明不是升序的，更新n为当前元素索引，继续遍历直到末尾
                //从右向左遍历，如果当前元素比它之后的最小的元素大，说明不是降序的，更新m为当前元素索引，继续遍历直到开始
                int max = array[0];
                int min = array[length - 1];
                for (int begin = 0; begin < length; begin++) {
                    int end = length - 1 - begin;
                    if (array[begin] < max) {
                        n = begin;
                    } else {
                        max = array[begin];
                    }
                    if (array[end] > min) {
                        m = end;
                    } else {
                        min = array[end];
                    }
                }
            }
            res[0] = m;
            res[1] = n;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}