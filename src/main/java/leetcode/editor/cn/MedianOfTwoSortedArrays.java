//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治算法 
// 👍 3966 👎 0

// 寻找两个正序数组的中位数
package leetcode.editor.cn;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length, length2 = nums2.length;
            int totalLength = length1 + length2;
            return (find1(nums1, nums2, (totalLength + 1) / 2) + find1(nums1, nums2, totalLength / 2 + 1)) / 2.0;
            // if (totalLength % 2 == 1) {
            //     int midIndex = totalLength / 2;
            //     return find1(nums1, nums2, midIndex + 1);
            // } else {
            //     int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            //     return (find1(nums1, nums2, midIndex1 + 1) + find1(nums1, nums2, midIndex2 + 1)) / 2.0;
            // }
        }

        private int find1(int[] nums1, int[] nums2, int k) {
            int index1 = 0, index2 = 0;
            int len1 = nums1.length, len2 = nums2.length;
            while (k > 0) {
                if (index1 == len1) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == len2) {
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }

                if (nums1[index1] > nums2[index2]) {
                    index2++;
                } else {
                    index1++;
                }
                k--;
            }
            return 0;
        }

        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            int len1 = nums1.length, len2 = nums2.length, total = len1 + len2;

            return (find(nums1, nums2, (total + 1) / 2) + find(nums1, nums2, (total + 2) / 2)) / 2.0;

        }

        private int find(int[] nums1, int[] nums2, int k) {
            int index1 = 0, index2 = 0;
            int length1 = nums1.length, length2 = nums2.length;
            while (true) {
                // 边界情况
                if (index1 == length1) {
                    return nums2[index2 + k - 1];
                }
                if (index2 == length2) {
                    return nums1[index1 + k - 1];
                }
                if (k == 1) {
                    return Math.min(nums1[index1], nums2[index2]);
                }

                // 正常情况
                // int half = k / 2;
                // int newIndex1 = Math.min(index1 + half, length1) - 1;
                // int newIndex2 = Math.min(index2 + half, length2) - 1;
                // int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
                // if (pivot1 <= pivot2) {
                //     k -= (newIndex1 - index1 + 1);
                //     index1 = newIndex1 + 1;
                // } else {
                //     k -= (newIndex2 - index2 + 1);
                //     index2 = newIndex2 + 1;
                // }

                int pivot1 = nums1[index1], pivot2 = nums2[index2];
                if (pivot1 < pivot2) {
                    index1++;
                } else {
                    index2++;
                }
                k--;


            }
        }


    }


    //leetcode submit region end(Prohibit modification and deletion)

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            return getKthElement(nums1, nums2, midIndex + 1);
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            return (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public double findMedianSortedArrays5(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, total = len1 + len2;

        return (dfs(nums1, 0, nums2, 0, (total + 1) / 2) + dfs(nums1, 0, nums2, 0, (total + 2) / 2)) / 2.0;

    }


    private int dfs(int[] nums1, int index1, int[] nums2, int index2, int k) {
        if (index1 >= nums1.length) {
            return nums2[index2 + k - 1];
        }
        if (index2 >= nums2.length) {
            return nums1[index1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }

        int mid1 = index1 + k / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[index1 + k / 2 - 1];
        int mid2 = index2 + k / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[index2 + k / 2 - 1];
        if (mid1 < mid2) {
            return dfs(nums1, index1 + k / 2, nums2, index2, k - k / 2);
        }
        return dfs(nums1, index1, nums2, index2 + k / 2, k - k / 2);

    }


    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        return (findK2(nums1, 0, nums2, 0, left) + findK2(nums1, 0, nums2, 0, right)) / 2.0;

    }

    //找到两个数组中第k小的元素
    public int findK2(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        //计算出每次要比较的两个数的值，来决定 "删除"" 哪边的元素
        int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        //通过递归的方式，来模拟删除掉前K/2个元素
        if (mid1 < mid2) {
            return findK2(nums1, i + k / 2, nums2, j, k - k / 2);
        }
        return findK2(nums1, i, nums2, j + k / 2, k - k / 2);
    }

    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays4(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // if (nums1.length > nums2.length) {//保证num1长度小，如果不小我交换一下
        //
        //     int team[] = nums2.clone();
        //     nums2 = nums1;
        //     nums1 = team;
        // }

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int k = (nums1.length + nums2.length + 1) / 2;//理论中位数满足的位置
        int left = 0, right = nums1.length;//二分查找短的

        while (left < right) {//找到对应位置
            int m1 = (left + right) / 2;//在短的位置
            int m2 = k - m1;//在长的第几个
            //System.out.println(m1+" "+m2);
            if (nums1[m1] < nums2[m2 - 1])//left右移
            {
                left = m1 + 1;
            } else {//right左移
                right = m1;
            }
        }
        //System.out.println(left+" "+k);
        //左侧最大和右侧最小那个先算出来再说，根据奇偶再使用
        double leftbig =
                Math.max(left == 0 ? Integer.MIN_VALUE : nums1[left - 1], k - left == 0 ? Integer.MIN_VALUE : nums2[k - left - 1]);
        double rightsmall = Math.min(left == nums1.length ? Integer.MAX_VALUE : nums1[left],
                k - left == nums2.length ? Integer.MAX_VALUE : nums2[k - left]);
        //System.out.println(rightsmall);
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (leftbig + rightsmall) / 2;
        } else {
            return leftbig;
        }
    }


}