package com.leetcode.study.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 * <p>
 * 滑动窗口算法
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s==null||s.equals("")) return 0;

        int left=0, right = 0;
        Queue<Character> window = new LinkedList<>();

        int ret = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 如果当前窗口包含当前元素,即重复
            if (window.contains(c)) {
                // 先找出窗口的元素个数
                ret = Math.max(ret, window.size());
                // 移动left到重复元素
                while (!window.isEmpty()){
                    // 窗口内的第一个元素不等于重复元素
                    if (window.peek() != c) {
                        window.poll();
                        left++;
                    }else{
                        window.poll();
                        left++;
                        break;
                    }
                }
            }
            window.offer(c);
        }

        return Math.max(ret,window.size());

    }
}
