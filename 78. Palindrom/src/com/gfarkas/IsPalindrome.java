package com.gfarkas;

public class IsPalindrome {

    public boolean IsPalindrome(String text) {

        text = text.replaceAll("[,! ]","");
        boolean isPalindrome = true;


        for (int i = 0; i < text.length() / 2 ; i++) {

            if (!(text.charAt(i) == text.charAt(text.length() - i - 1))) {
                System.out.println(text.charAt(i) + " " + text.charAt(text.length() - i - 1));
                isPalindrome = false;

            }

        }

        return isPalindrome;

    }

}
