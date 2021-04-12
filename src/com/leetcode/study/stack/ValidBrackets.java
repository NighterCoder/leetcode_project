package com.leetcode.study.stack;

/**
 * 2020/11/11
 * No.20 有效括号
 */
public class ValidBrackets {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s){
        if (s.length()==0){
            return true;
        }
        String rs=s;
        // 递归
        while (rs!=null&&rs.length()>0){
           rs=shortenStr(rs);
        }
        return rs != null;
    }

    public static String shortenStr(String s){

        String str1="([{";
        String str2=")]}";

        for (int i=0;i<s.length()-1;i++){
            if (!str1.contains(s.substring(i,i+1))){
                return null;
            }
            if (str1.indexOf(s.substring(i,i+1))==str2.indexOf(s.substring(i+1,i+2))){
                return s.substring(0, i) + s.substring(i + 2);
            }
        }
        return null;
    }


}
