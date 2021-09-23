//给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 
//输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","
//L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 
//输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 38 👎 0

//  字母与数字
package leetcode.editor.cn.day06;

import java.util.ArrayList;
import java.util.HashMap;

public class FindLongestSubarrayLcci {

    public static void main(String[] args) {
        Solution solution = new FindLongestSubarrayLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String[] findLongestSubarray(String[] array) {
            HashMap<Integer, Integer> left = new HashMap<>();
            HashMap<Integer, Integer> right = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;
            left.put(count, -1);
            list.add(0);
            for (int i = 0; i < array.length; i++) {
                char ch = array[i].charAt(0);
                if (ch >= '0' && ch <= '9') {
                    count++;
                } else {
                    count--;
                }
                if (left.containsKey(count)) {
                    right.put(count, i);
                } else {
                    left.put(count, i);
                    list.add(count);
                }
            }
            int maxLength = 0, start = 0, end = 0;
            for (Integer i: list) {
                if (!right.containsKey(i)) {
                    continue;
                }
                int s = left.get(i), e = right.get(i);
                if (e - s > maxLength) {
                    maxLength = e - s;
                    start = s + 1;
                    end = e;
                }
            }
            if (maxLength == 0) {
                return new String[0];
            }
            String[] ret = new String[maxLength];
            for (int i = start, j = 0; i <= end; i++, j++) {
                ret[j] = array[i];
            }
            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}