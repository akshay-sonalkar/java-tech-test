package com.global.commtech.test.anagramfinder;

import java.util.*;

public class AnagramGroupingService {

    // Time complexity: O(n * k log k) where n is the number of words and k is the length of the longest word
    // Space complexity: O(n * k) where n is the number of words and k is the length of the longest word
    public List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String key = word.chars() // Use original case
                    .sorted()
                    .collect(StringBuilder::new,
                            StringBuilder::appendCodePoint,
                            StringBuilder::append)
                    .toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        List<List<String>> grouped = new ArrayList<>(map.values());
        for (List<String> group : grouped) {
            Collections.sort(group);
        }

        grouped.sort(Comparator.comparing(g -> g.get(0), String.CASE_INSENSITIVE_ORDER)); // Sort groups case-insensitively
        return grouped;
    }
}
