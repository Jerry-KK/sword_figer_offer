package chapter12_sort;

/**
 * @author lethe
 * @date 2021/11/30 20:32
 */

import java.util.Random;

/**
 * 题目:请从一个乱序数组中找出第k大的数字。
 * 例如：数组[3,1,2,4,5,5,6]中第3大的数字是5。
 */
public class Questions_76 {

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length -1;
        int index = partition(nums,start,end);
        while (index != target) {
            if(index < target) {
                start = index + 1;
            }else {
                end = index-1;
            }
            index = partition(nums,start,end);
        }
        return nums[index];
    }

    private int partition(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums,random,end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if(nums[i] < nums[end]) {
                swap(nums,++small,i);
            }
        }
        swap(nums,++small,end);
        return small;
    }

    private void swap(int[] nums, int index1, int index2) {
        if(index1 != index2) {
            int temp = nums[index2];
            nums[index2] = nums[index1];
            nums[index1] = temp;
        }
    }

}
