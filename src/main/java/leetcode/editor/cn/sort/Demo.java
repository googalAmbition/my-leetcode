package leetcode.editor.cn.sort;

/**
 * @date 2023/11/8.
 */
public class Demo {
    //  4，-2，7，-9，8，-3，1

    public static int maxSum(int[] nums){

        if(nums== null||nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,-2,7,-9,8,-3,1};

        System.out.println(maxSum(nums));
    }
}

