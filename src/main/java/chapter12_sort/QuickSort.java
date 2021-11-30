package chapter12_sort;

import java.util.Random;

/**
 * 快速排序
 * @author lethe
 * @date 2021/11/30 20:10
 */
public class QuickSort {

    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
           int pivot = partition(nums,start,end);
           quickSort(nums,start,pivot-1);
           quickSort(nums,pivot+1,end);
        }
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
