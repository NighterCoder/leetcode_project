package com.leetcode.study.math;

import java.util.*;

/**
 * 2020/11/12
 * Roman数字转整数
 */
public class Roman2Num {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));

    }

    public static int romanToInt(String s){
        int sum=0;
        Map<Character,Integer> map=new HashMap<Character, Integer>(){{
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }};

        Map<String,Integer> map1=new HashMap<String, Integer>(){{
            put("IV",4);
            put("IX",9);
            put("XL",40);
            put("XC",90);
            put("CD",400);
            put("CM",900);
        }};
        List<Character> keyList=new ArrayList<Character>(){{
            add('I');
            add('V');
            add('X');
            add('L');
            add('C');
            add('D');
            add('M');
        }
        };

        for (int i=0;i<s.length();i++){
            char ele1=s.charAt(i);
            if (i+1==s.length()){
                sum+= map.get(ele1);
            }else {
                char ele2 = s.charAt(i + 1);
                int num1 = keyList.indexOf(ele1);
                int num2 = keyList.indexOf(ele2);
                if (num1 >= num2) {
                    sum += map.get(ele1);
                } else {
                    if ((num1 == 0 || num1 == 2 || num1 == 4) && num2 - num1 <= 2) {
                        String str1 = String.valueOf(ele1);
                        String str2 = String.valueOf(ele2);
                        String rs = str1.concat(str2);
                        sum += map1.get(rs);
                        i = i + 1;
                    }
                }
            }
        }
        return sum;
    }
}
