//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 338 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int length1 = nums1.length, length2 = nums2.length;
            int[] intersection = new int[length1 + length2];
            int index = 0, index1 = 0, index2 = 0;
            while (index1 < length1 && index2 < length2) {
                int num1 = nums1[index1], num2 = nums2[index2];
                if (num1 == num2) {
                    // 保证加入元素的唯一性
                    if (index == 0 || num1 != intersection[index - 1]) {
                        intersection[index++] = num1;
                    }
                    index1++;
                    index2++;
                } else if (num1 < num2) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> result = new HashSet<>();

        int n1L = nums1.length;
        int n2L = nums2.length;
        int index1 = 0, index2 = 0;
        while (index1 < n1L && index2 < n2L) {
            if (nums1[index1] == nums2[index2]) {
                result.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        int[] re = new int[result.size()];
        Iterator<Integer> iterator = result.iterator();
        for (int i = 0; i < result.size(); i++) {
            re[i] = iterator.next();
        }

        return re;
    }
}