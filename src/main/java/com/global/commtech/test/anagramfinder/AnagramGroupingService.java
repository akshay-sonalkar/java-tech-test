package com.global.commtech.test.anagramfinder;

import java.util.*;

public class AnagramGroupingService {

    public List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagramMap = new LinkedHashMap<>();
        for (String word : words) {
            String sorted = sortChars(word);
            anagramMap.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(anagramMap.values());
    }

    private String sortChars(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}