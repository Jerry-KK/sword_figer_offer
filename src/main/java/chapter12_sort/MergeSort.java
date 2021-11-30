package chapter12_sort;

import java.util.Arrays;

/**
 * @author lethe
 * @date 2021/11/30 20:41
 */
public class MergeSort {

    public int[] sortArray2(int[] nums) {
        int length = nums.length;
        int[] src = nums;
        int[] dst = new int[length];
        for (int seg = 1; seg < length; seg+=seg) {
            for (int start = 0; start < length; start += seg * 2) {
                int mid = Math.min(start+seg,length);
                int end = Math.min(start+seg*2,length);
                int i = start, j = mid, k = start;
                while (i < mid || j < end) {
                    if(j == end || (i < mid && src[i] < src[j])) {
                        dst[k++] = src[i++];
                    } else {
                        dst[k++] = src[j++];
                    }
                }
            }
            int[] temp = src;
            src  = dst;
            dst = temp;
        }
        return src;
    }

    public int[] sortArray(int[] nums) {
        int[] dst = new int[nums.length];
        dst = Arrays.copyOf(nums,nums.length);
        mergeSort(nums,dst,0,nums.length);
        return dst;
    }

    private void mergeSort(int[] src, int[] dst, int start, int end) {
        if(start + 1 >= end)
            return;
        int mid = (start + end ) / 2;
        mergeSort(src,dst,start,mid);
        mergeSort(src,dst,mid,end);
        int i = start, j = mid, k = start;
        while (i <mid || j< end ) {
            if(j == end || (i < mid && src[i] < src[j])) {
                dst[k++] = src[i];
            }else {
                dst[k++] = src[j];
            }
        }
    }

}
