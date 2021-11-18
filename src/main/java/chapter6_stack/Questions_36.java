package chapter6_stack;

import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/18 17:09
 */

/**
 * 题目：后缀表达式是一种算术表达式，它的操作符子在操作数的后面。输入一个字符串数组表示的后缀表达式，请输出该后缀表达式的计算结果。
 * 假设输入的一定是有效的后缀表达式。
 * 例如，后缀表达式["2","1","3","*","+"]对应的算术表达式是"2+1*3"，因此输出它的计算结果5。0
 */
public class Questions_36 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token:tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    stack.push(calculate(num1,num2,token));
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+" :
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
