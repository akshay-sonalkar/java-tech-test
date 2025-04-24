package com.global.commtech.test.anagramfinder;

import java.util.List;

public class OutputWriter {

    // Time complexity: O(m) where m is the number of groups
    // Space complexity: O(1) since we are not using any additional data structures
    public void write(List<List<String>> groupedWords) {
        for (List<String> group : groupedWords) {
            System.out.println(String.join(",", group));
        }
    }
}
