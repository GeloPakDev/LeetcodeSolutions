package com.company.leetcodesolutions.util;

import java.util.LinkedList;

public class Strings {
    public static boolean checkForPalindrome(String input) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder builder = new StringBuilder(input.length());
        String lowerCase = input.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char ch = lowerCase.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                builder.append(ch);
                stack.push(ch);
            }
        }

        StringBuilder reversed = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString().equals(builder.toString());
    }
}
