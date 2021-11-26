package chapter11_binary_search;

/**
 * @author koujn
 * @date 2021/11/26 16:04
 */

/**
 * 题目：在一个排序的数组中，除一个数字只出现一次之外，其他数字都出现了两次，请找出这个唯一只出现一次的数字。
 * 例如，在数组[1,1,2,2,3,4,4,5,5]中，数字3只出现了一次.
 */
public class Questions_70 {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length/2;
        while (left <= right) {
            int mid = ((right-left)>>1) + left;
            int i = mid * 2;
            if(i < nums.length-1 && nums[i] != nums[i+1]) {
                if(mid == 0 || nums[i-1] == nums[i-2])
                    return nums[i];
                else
                    right = mid - 1;
            }else {
                left = mid + 1;
            }

        }
        return nums[nums.length-1];
    }
}
