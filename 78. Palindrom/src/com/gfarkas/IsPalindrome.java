package com.gfarkas;

import org.apache.log4j.Logger;



public class IsPalindrome {

    public IsPalindrome() {


    }

    public boolean isPalindrome(String text) {

        Logger logger = Logger.getLogger(IsPalindrome.class.getName());
        
        
        text = text.replaceAll("[,! ]","");
        boolean isPalindrome = true;


        for (int i = 0; i < text.length() / 2 ; i++) {

            logger.debug("[" + i + "] " + text.charAt(i) + " ?= " + 
                    text.charAt(text.length() - i - 1) + 
                    "[" + (text.length() - i - 1) + "]");
            
            if (!(text.charAt(i) == text.charAt(text.length() - i - 1))) {
                
                isPalindrome = false;
                break;

            }

        }
        logger.info("checking text: " + text + (isPalindrome ?
                " is Palindrome" : " is not Palindrome"));
        return isPalindrome;

    }

}
