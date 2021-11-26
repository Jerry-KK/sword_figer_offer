package chapter11_binary_search;

/**
 * @author koujn
 * @date 2021/11/26 15:52
 */

/**
 * 题目：在一个长度大于或等于3的数组中，任意相邻的两个数字都不相等。该数组的前若干数字是递增的，之后的数字是递减的，因此它的值看起来像一座山峰。
 * 请找出山峰的顶部，即数组中最大值的位置。
 * 例如，在数组[1,3,5,4,2]中，最大值是5，输出它的数组中的下标2.
 */
public class Questions_69 {

    public int peakIndexInMountainArray(int[] nums) {
        int left = 1;
        int right = nums.length - 2;
        while (left <= right ) {
            int mid = ((right-left)>>1) + left;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            if(nums[mid] > nums[mid - 1] )
                left = mid + 1;
            else
                right = mid -1;
        }
        return -1;
    }
}
