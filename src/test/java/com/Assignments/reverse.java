package com.Assignments;


public class reverse {
    public static void main(String[] args) {
        String input = "i am selenium";
        String reversed = reverseString(input);
        System.out.println(reversed);
    }

    public static String reverseString(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }
}