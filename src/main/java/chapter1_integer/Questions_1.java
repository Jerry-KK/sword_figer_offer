package chapter1_integer;

/**
 * @author koujn
 * @date 2021/11/15 10:44
 */

/**
 * 题目：输入2个int型整数，它们进行除法计算并返回商，要求不得使用乘号'*'、除号'/'以及求余符号'%'。
 * 当发生溢出时，返回最大的整数值。
 * 假设除数不为0。
 * 例如，输入15和2，输出15/2的结果，即7.
 */
public class Questions_1 {
    public static void main(String[] args) {
        Questions_1 body = new Questions_1();
        int res = body.divide2(15, 2);
        System.out.println(res);
    }

    /**
     *
     * @param dividend  被除数
     * @param divisor   除数
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(divisor == 1)
            return dividend;
        if(divisor == -1)
            return -dividend;
        boolean flag = false;
        if(dividend < 0 ) {
            flag = true;
            dividend = -dividend;
        }
        if(divisor < 0 ) {
            flag = !flag;
            divisor = -divisor;
        }
        int res = 0;
        while (dividend >= divisor) {
            ++res;
            dividend -= divisor;
        }
        if(flag)
            res = -res;
        return res;
    }

    public int divide2(int dividend, int divisor) {
        if(dividend == 0x80000000 && divisor == -1)
            return Integer.MAX_VALUE;
        int negative = 2;
        if(dividend < 0) {
            --negative;
            dividend  = -dividend;
        }
        if(divisor < 0) {
            --negative;
            divisor  = -divisor;
        }
        int result = 0;
        while (dividend >= divisor) {
            int value = divisor;
            int quotient = 1;
            while (dividend >= value + value) {
                quotient+=quotient;
                value+=value;
            }
            result += quotient;
            dividend -= value;
        }
        return negative == 1 ? -result : result;
    }

}
