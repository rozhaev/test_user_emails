package com.rozhaev;

import com.rozhaev.manager.Analyzer;
import com.rozhaev.manager.AnalyzerImpl;

import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args){
        Analyzer analyzer = new AnalyzerImpl();
        Map<String, Set<String>> userEmails = analyzer.run();

        System.out.println("Result:");
        userEmails.forEach((userName, emails) -> System.out.println(userName + String.join(", ", emails)));
    }
}
