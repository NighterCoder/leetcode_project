package com.leetcode.study.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * No.20 有效括号 官方解答
 * 使用【栈】
 * (后遇到的左括号先闭合,所以将后遇到的左括号放入栈顶,后进先出)
 *
 * peek:返回栈顶元素但是不移除
 * pop:返回栈顶元素并且移除
 * push:入栈
 *
 */
public class ValidBracketsOfficial {
    public boolean isValid(String s){
        int n=s.length();
        if (n%2==1){
            return false;
        }
        Map<Character,Character> pairs=new HashMap<Character, Character>(){
            {
                put(')','(');
                put(']','[');
                put('}','{');
            }
        };
        Deque<Character> stack=new LinkedList<>();
        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            // 是右括号
            if (pairs.containsKey(ch)){
                // 栈是空的或者栈顶的左括号不对应
                if (stack.isEmpty()||stack.peek()!=pairs.get(ch)){
                    return false;
                }
                // 移除栈顶元素
                stack.pop();
            }else {
                // 左括号先入栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
