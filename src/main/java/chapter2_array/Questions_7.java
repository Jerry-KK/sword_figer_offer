package chapter2_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author koujn
 * @date 2021/11/15 16:50
 */

/**
 * 题目：输入一个数组，如何找出数组中所有和为0的三个数字的三元组？
 * 需要注意的是，返回值中不得包含重复的三元组。例如，在数组[-1, 0 , 1, 2, -1, -4]中有两个三元组的和为0，分别是[-1,0,1]和[-1,-1,2]
 */
public class Questions_7 {

    public List getTest(int[] numbers, int target) {
        Arrays.sort(numbers);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < numbers.length-2; i++) {
            int v = target - numbers[i];
            int a = i+1;
            int b = numbers.length-1;
            while (a < b) {
                if(numbers[a] + numbers[b] > v) {
                    --b;
                }else if(numbers[a] + numbers[b] < v ) {
                    ++a;
                }else {
                    res.add(new int[] {i,a,b});
                    break;
                }
            }
        }
        return res;
    }

}
