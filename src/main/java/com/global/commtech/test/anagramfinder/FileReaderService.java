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

    public void processWordsBySize(String path, WordProcessor processor) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException(path + " Does not exist");
        }

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            List<String> currentGroup = new ArrayList<>();
            int currentSize = -1;

            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim();
                if (!word.isEmpty()) {
                    if (currentSize == -1 || word.length() == currentSize) {
                        currentGroup.add(word);
                        currentSize = word.length();
                    } else {
                        processor.process(currentGroup);
                        currentGroup.clear();
                        currentGroup.add(word);
                        currentSize = word.length();
                    }
                }
            }

            if (!currentGroup.isEmpty()) {
                processor.process(currentGroup);
            }
        }
    }

    @FunctionalInterface
    public interface WordProcessor {
        void process(List<String> words) throws IOException;
    }
}
