package com.global.commtech.test.anagramfinder;

import java.io.*;
import java.util.*;

public class FileReaderService {

    // Time complexity: O(n) where n is the number of lines in the file
    // Space complexity: O(n) where n is the number of lines in the file
    public List<String> readWordsFromFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path + " Does not exist");
        }

        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }
        return words;
    }
}
