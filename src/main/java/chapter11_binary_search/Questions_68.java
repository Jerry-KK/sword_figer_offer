package chapter11_binary_search;

/**
 * @author koujn
 * @date 2021/11/26 14:36
 */

/**
 * 题目：输入一个排序的整数数组nums和一个目标值t，如果数组nums中包含t，则返回t在数组中的小标；如果数组nums中不包含t，则返回将t按顺序插入数组nums
 * 中的下标。假设数组中没有相同的数字。
 * 例如，输入数组nums为[1,3,6,8],如果目标值为3，则输出1；如果t为5，则返回2.
 */
public class Questions_68 {

    public static void main(String[] args) {
        int[] nums = {1,3,6,8};
        System.out.println(new Questions_68().searchInsert(nums,8));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left)>>1) + left;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left)>>1) + left;
            if(nums[mid] >= target) {
                if(mid == 0 || nums[mid - 1] < target) {
                    return mid;
                }
                right = mid -1 ;
            }else {
                left = mid + 1;
            }
        }
        return nums.length;
    }

}
