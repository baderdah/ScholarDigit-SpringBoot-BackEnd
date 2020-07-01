package com.ensas.miniprojet.demo.util;

import java.util.regex.Pattern;

public class StringUtil {
    public final static String EMPTY = " ";


    public static boolean isEmptyOrNullOrAWhiteSpace(String str){
        return ObjectUtil.isNull(str) || str.isEmpty() || str.equals(" ");
    }

    public static Pattern regExCompile(String regex){
        return Pattern.compile(regex);
    }
    public static boolean isEmailValid(String email){
        String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
        return isEmptyOrNullOrAWhiteSpace(email) || regExCompile(regex).matcher(email).find();
    }
}
