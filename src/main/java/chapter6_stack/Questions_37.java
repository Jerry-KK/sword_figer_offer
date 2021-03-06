package chapter6_stack;

import java.util.Stack;

/**
 * @author koujn
 * @date 2021/11/18 17:27
 */

/**
 * 题目:输入一个表示小行星的数组,数组中每个数字的绝对值表示小行星的大小,数字的正负号表示小行星运动的方向，正号表示向右飞行，负号表示向左飞行。
 * 如果两颗小行星相撞,那么体积较小的小行星将会爆炸最终消失,体积较大的小行星不受影响。如果相撞的两颗小行星大小相同，那么它们都会爆炸消失。飞行方向相同
 * 的小行星永远不会相撞。求最终剩下的小行星。例如，有6颗小行星[4,5,-6,4,8,-5],它们相撞之后最终剩下3颗小行星[-6,4,8]
 */
public class Questions_37 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int as : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -as) {
                stack.pop();
            }
            if(!stack.isEmpty() && as < 0 && stack.peek() == -as) {
                stack.pop();
            }else if(as > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(as);
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }

}
