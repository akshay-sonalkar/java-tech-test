package com.global.commtech.test.anagramfinder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnagramCommandLineRunner implements CommandLineRunner {

    private final FileReaderService reader;
    private final AnagramGroupingService grouper;
    private final OutputWriter writer;

    // ✅ No-arg constructor for test compatibility
    public AnagramCommandLineRunner() {
        this.reader = new FileReaderService();
        this.grouper = new AnagramGroupingService();
        this.writer = new OutputWriter();
    }

    @Override
    public void run(final String... args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Please ensure that the input file is provided");
        }

        String filePath = args[0];

        reader.processWordsBySize(filePath, words -> {
            List<List<String>> grouped = grouper.groupAnagrams(words);
            writer.write(grouped);
        });
    }
}