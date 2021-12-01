package chapter13_backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author koujn
 * @date 2021/12/1 14:42
 */

/**
 * 题目:输入n和k,请输出从1到n中选取k个数字组成的所有组合。
 * 例如，如果n等于3，k等于2，将组成3个组合，分别是[1,2],[1,3],[2,3]。
 */
public class Questions_80 {

    public static void main(String[] args) {
        Questions_80 body = new Questions_80();
        List<List<Integer>> lists = body.myTest(3, 2);
        System.out.println(1);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        helper(n,k,1,combination,result);
        return result;
    }

    private void helper(int n, int k, int i, LinkedList<Integer> combination, List<List<Integer>> result) {
        if(combination.size() == k) {
            result.add(new LinkedList<>(combination));
        }else if(i > n) {
            helper(n,k,i+1,combination,result);
            combination.add(i);
            helper(n,k,i+1,combination,result);
            combination.removeLast();
        }
    }

    public List<List<Integer>> myTest(int n,int k) {
        List<List<Integer>> result = new LinkedList<>();
        myHelp(1,new LinkedList<Integer>(),result,n,k);
        return result;
    }

    public void myHelp(int i,LinkedList<Integer> list,List<List<Integer>> result,int n,int k) {
        if(i > n) {
            if(list.size() == k)
                result.add(new LinkedList<>(list));
        } else {
            myHelp(i+1,list,result,n,k);
            list.add(i);
            myHelp(i+1,list,result,n,k);
            list.removeLast();
        }
    }
}
