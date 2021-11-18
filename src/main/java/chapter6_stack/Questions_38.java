package chapter6_stack;

import java.util.Stack;

/**
 * @author lethe
 * @date 2021/11/18 21:13
 */

/**
 * 题目：输入一个数组，它的每个数字是某天的温度。请计算每天需要等几天才会出现更高的温度。
 * 例如，如果输入数组[35,31,33,36,34],那么输出为[3,1,1,0,0]
 */
public class Questions_38 {

    public static void main(String[] args) {
        Questions_38 body = new Questions_38();
        int[] arr = {35,31,33,36,34};
        int[] test = body.test(arr);
        System.out.println(test);
    }

    public int[] test(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int[] res = new int[arr.length];
        for (int i = arr.length-2; i >= 0 ; --i) {
            while (!stack.isEmpty()) {
                if(arr[i] <= stack.peek()) {
                    res[i] = indexStack.peek()-i;
                    break;
                }else {
                    stack.pop();
                    indexStack.pop();
                }
            }
            stack.push(arr[i]);
            indexStack.push(i);
        }
        return res;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()){
                Integer prev = stack.pop();
                result[prev] = i-prev;
            }
            stack.push(i);
        }
        return result;
    }
}
