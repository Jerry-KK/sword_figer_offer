package chapter11_binary_search;

/**
 * @author koujn
 * @date 2021/11/26 13:49
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = ((right - left)>>1) + left;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[left] == target ? left : -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = ((right - left)>>1) + left;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
