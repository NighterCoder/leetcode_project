package com.leetcode.study.slidingwindow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * 替换后的最长重复字符
 *
 * 滑动窗口问题
 *
 * 不会
 *
 */
public class CharacterReplacement {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }

    public static int characterReplacement(String s, int k) {
        int left =0;
        int right = 0;

        int count = k;
        Queue<Character> window = new LinkedList<>();
        int ret= 0 ;
        char diffChar='0';
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            // 窗口不是为空,元素不一样
            if (!window.isEmpty() && !window.contains(c)){
                count--;
                diffChar = c;
            }
            // 添加元素到末尾
            window.offer(c);
            if (count==0){
                ret = Math.max(ret,window.size());
                left++;
                // 将第一个元素删除
                window.poll();
                // 重新赋值
                count = k;
                Set<Character> set = new HashSet<>(window);
                count -= (set.size()-1);
            }

        }

        return Math.max(ret,window.size());
    }

}
