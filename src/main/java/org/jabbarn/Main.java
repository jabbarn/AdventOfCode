package org.jabbarn;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;


public class Main {
    public static void main(String... args) {
        System.out.println("Advent of Code 2023!");
        System.out.println("Day 1: ");
        try {
            ArrayList<Integer> calValueList = new ArrayList<>();
            String line;
            URL resource = Objects.requireNonNull(Main.class.getClassLoader().getResource("day01/input.txt"));
            BufferedReader br = new BufferedReader(new FileReader(new File(resource.toURI())));
            while ((line = br.readLine()) != null) {
                // original
                System.out.println(line);
                // remove alphanumeric characters.
                String result = removeAlphaNumeric(line);
                System.out.println(result);

                // check if the line consists of one char's length, if so append it to itself and return.
                int number = Integer.parseInt(createCalValue(result));
                calValueList.add(number);
                System.out.println(createCalValue(result));
                System.out.println("=========================");
            }
            // sum up the list of integers.
            Integer sum = calValueList.stream()
                    .reduce(0, Integer::sum);
            System.out.println(sum);
            br.close();


        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    private static String createCalValue(String str) {
        // check if the str is 1 char long, if so quantify with itself and return. if it's longer, take the first and last and quantify.
        return (
            str.length() > 1 ? ("" + str.charAt(0) + str.charAt(str.length() -1))
            : (str + str)
        );
    }

    public static String removeAlphaNumeric(String str) {
        return str.replaceAll("[a-zA-Z]", "");
    }

}
