package com.global.commtech.test.anagramfinder;

import java.util.List;

public class OutputWriter {

    public void write(List<List<String>> groupedWords) {
        for (List<String> group : groupedWords) {
            System.out.println(String.join(",", group));
        }
    }
}