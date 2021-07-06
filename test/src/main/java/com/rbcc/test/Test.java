package com.rbcc.test;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        String str = "abbcccdeeeefffff";

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        Set<Integer> unique = new HashSet<>();
        int res = 0;
        int temp;
        for (Character c : map.keySet()) {
            temp = 0;
            int fre = map.get(c);

            while (unique.contains(fre)) {
                temp++;
                fre--;
            }

            if (fre > 0) {
                unique.add(fre);
            }

            res += temp;

        }

        System.out.println(res);
    }
}
