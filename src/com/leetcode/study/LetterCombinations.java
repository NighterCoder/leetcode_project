package com.leetcode.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * 未做出 "所有组合" = 回溯
 */
public class LetterCombinations {

    private static final HashMap<Character,List<String>> digitsMap = new HashMap<>();

    static {
        digitsMap.put('2', Arrays.asList("a","b","c"));
        digitsMap.put('3', Arrays.asList("d","e","f"));
        digitsMap.put('4', Arrays.asList("g","h","i"));
        digitsMap.put('5', Arrays.asList("j","k","l"));
        digitsMap.put('6', Arrays.asList("m","n","o"));
        digitsMap.put('7', Arrays.asList("p","q","r","s"));
        digitsMap.put('8', Arrays.asList("t","u","v"));
        digitsMap.put('9', Arrays.asList("x","y","z"));
    }


    public static void main(String[] args) {

    }

    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        List<List<String>> res = new ArrayList<>();
        for (char ele : chars) {
            res.add(digitsMap.get(ele));
        }
        for (int i = 0; i < res.size(); i++) {

        }

        return null ;
    }

}
