package chapter12_sort;

/**
 * @author lethe
 * @date 2021/11/29 19:35
 */

/**
 * 题目:输入两个数组arr1和arr2,其中数组arr2中的每个数字都唯一，并且都是数组arr1中的数字。请将数组arr1中的数字按照数组arr2中的数字的相对顺序排序。
 * 如果数组arr1中的数字在数组arr2中没有出现，那么将这些数字按递增的顺序排在后面。假设数组中的所有数字都在0到1000的范围内。
 * 例如，输入的数组arr1和arr2分别是[2,3,3,7,3,9,2,1,7,2]和[3,2,1],则数组arr排序之后为[3,3,3,2,2,2,1,7,7,9]。
 */
public class Questions_75 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num:arr1) {
            ++counts[num];
        }
        int idx = 0;
        for (int num:arr2) {
            while (counts[num] > 0) {
                arr1[idx++] = num;
                --counts[num];
            }
        }
        for (int num = 0; num < counts.length; num++) {
            while (counts[num] > 0) {
                arr1[idx++] = num;
                --counts[num];
            }
        }
        return arr1;
    }

}
