package com.global.commtech.test.anagramfinder;

import java.io.*;
import java.util.*;

public class FileReaderService {

    private final BufferedReader reader;

    public FileReaderService(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException(filePath + " Does not exist");
        }
        this.reader = new BufferedReader(new FileReader(filePath));
    }

    public List<String> readWordsOfSameLength() throws IOException {
        List<String> words = new ArrayList<>();
        String line;
        int currentLength = -1;

        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            if (currentLength == -1) {
                currentLength = line.length();
            }

            if (line.length() != currentLength) {
                // Push back
                reader.reset();
                break;
            }
            reader.mark(1000);
            words.add(line);
        }

        return words.isEmpty() ? null : words;
    }

    public void close() throws IOException {
        reader.close();
    }
}