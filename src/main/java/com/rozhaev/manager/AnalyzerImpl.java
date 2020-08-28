package com.rozhaev.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AnalyzerImpl implements Analyzer{

    private static final String REGEX = ",";

    private final BufferedReader bufferedReader;
    private final Map<String, Set<String>> userEmails;

    public AnalyzerImpl() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        userEmails = new HashMap<>();
    }

    @Override
    public Map<String, Set<String>> run() {

        try {
            System.out.println("Enter a number of users: ");
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 1; i <= n; i++){
                String username = String.format("user%d -> ", i);
                Set<String> emails = readEmails(username);
                String foundUser = findUser(emails);
                if (foundUser != null) {
                    userEmails.get(foundUser).addAll(emails);
                } else {
                    userEmails.put(username, emails);
                }
            }
        } catch (IOException e) {
            System.out.println("Data error");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return userEmails;
    }

    private Set<String> readEmails(String userName) throws IOException {
        System.out.print(userName);
        return Arrays.stream(bufferedReader.readLine().split(REGEX)).map(String::trim).collect(Collectors.toSet());
    }

    private String findUser(Set<String> emails){
        for (Map.Entry<String, Set<String>> emailList : userEmails.entrySet()) {
            for (String em: emailList.getValue()){
                for (String email: emails) {
                    if (Objects.equals(em, email)) {
                        return emailList.getKey();
                    }
                }
            }
        }
        return null;
    }
}
