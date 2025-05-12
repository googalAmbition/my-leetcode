package leetcode.editor.cn.sort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2023/11/10.
 */
public class Demo01 {

    public static Integer findNum(int[] nums, int n){
        return findN(nums, 0 , nums.length-1, n);
    }

    private static Integer findN(int[] nums, int start, int end, int n) {
        if(start > end){
            return null;
        }
        int midNum = nums[(start+end)/2];
        if (midNum == n){
            return (start+end)/2;
        }
        Integer left = findN(nums, start, (start+end)/2-1 , n);
        Integer right = findN(nums, (start+end)/2+1, end, n);
        return  left == null? right :left;
    }

    public static void main(String[] args) {
        int n =3;
        int[] nums = new int[]{1,2,2,3,3,3,5,6,7};
        System.out.println(findNum(nums, n));
    }
}


