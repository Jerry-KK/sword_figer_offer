package chapter12_sort;

/**
 * 计数排序
 * @author lethe
 * @date 2021/11/29 19:27
 */
public class CountSort {

    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num:nums) {
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        int[] counts = new int[max-min+1];
        for (int num:nums) {
            ++counts[num-min];
        }
        int idx = 0;
        for (int i = min; i <= max; i++) {
            while (counts[i-min] > 0) {
                nums[idx++] = i;
                --counts[i-min];
            }
        }
        return nums;
    }
}
