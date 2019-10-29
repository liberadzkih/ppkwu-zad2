package com.restservice.RestApp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.*;

@RestController
public class CheckString {

    @RequestMapping("checkString/String/{s}")
    public String checkString_returnString(@PathVariable String s){
        char ch;
        int upperCaseCounter = 0;
        int lowerCaseCounter = 0;
        int lettersCounter = 0;
        int digitCounter = 0;
        int spaceCounter = 0;
        int specialSignsCounter = 0;
        for(int i=0; i<s.length(); i++){
            ch = s.charAt(i);
            if (isLowerCase(ch)) lowerCaseCounter++;
            if (isUpperCase(ch)) upperCaseCounter++;
            if (isLetter(ch)) lettersCounter++;
            if (isDigit(ch)) digitCounter++;
            if(isWhitespace(ch)) spaceCounter++;
            if (!isLetter(ch) && !isDigit(ch) && !isWhitespace(ch)) specialSignsCounter++;
        }
        return "Lower case:" + lowerCaseCounter + "  Upper case:" + upperCaseCounter + "  Letters:" + lettersCounter +
                "  Digits:" + digitCounter + "  Spaces:" + spaceCounter +  "  Signs:" + specialSignsCounter;
    }

    @RequestMapping("checkString/JSON/{s}")
    public Map<String, Integer> checkString_returnJSON(@PathVariable String s){
        Map<String, Integer> pairsMap = new HashMap<>();
        char ch;
        int upperCaseCounter = 0;
        int lowerCaseCounter = 0;
        int lettersCounter = 0;
        int digitCounter = 0;
        int spaceCounter = 0;
        int specialSignsCounter = 0;
        for(int i=0; i<s.length(); i++){
            ch = s.charAt(i);
            if (isLowerCase(ch)) lowerCaseCounter++;
            if (isUpperCase(ch)) upperCaseCounter++;
            if (isLetter(ch)) lettersCounter++;
            if (isDigit(ch)) digitCounter++;
            if(isWhitespace(ch)) spaceCounter++;
            if (!isLetter(ch) && !isDigit(ch) && !isWhitespace(ch)) specialSignsCounter++;
        }
        pairsMap.put("lowerCase", lowerCaseCounter);
        pairsMap.put("upperCase", upperCaseCounter);
        pairsMap.put("letters", lettersCounter);
        pairsMap.put("digits", digitCounter);
        pairsMap.put("spaces", spaceCounter);
        pairsMap.put("specialSigns", specialSignsCounter);

        return pairsMap;
    }
}
