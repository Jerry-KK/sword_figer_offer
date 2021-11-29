package chapter12_sort;

/**
 * @author lethe
 * @date 2021/11/29 18:39
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目:输入一个区间的集合，请将重叠的区间合并。每个区间用两个数字比较，分别表示区间的起始位置和结束位置。
 * 例如，输入区间[[1,3],[4,5],[8,10],[2,6],[9,12],[15,18]],合并重叠的区间之后得到[[1,6],[8,12],[15,18]]
 */
public class Questions_74 {

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {4,5},{8,10},{2,6},{9,12},{15,18}};
        Questions_74 body = new Questions_74();
        int[][] merge = body.merge(intervals);
        System.out.println();
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp= intervals[i].clone();
            int j = i + 1;
            while (j < intervals.length && temp[1] >= intervals[j][0]) {
                temp[1] = Math.max(temp[1], intervals[j++][1]);
            }
            merged.add(temp);
            i = j;
        }
        return merged.toArray(new int[0][0]);
    }

}
