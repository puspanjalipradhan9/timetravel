package com.gamesys.timetravel.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeTravelDetailsValidator {

    public static void main(String[] args){

        String regex = "^[a-zA-Z][a-zA-Z0-9.,$;]{4,9}+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("ABCDEF");
        System.out.println(matcher.matches());
    }
}
