package com.global.commtech.test.anagramfinder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnagramCommandLineRunner implements CommandLineRunner {

    private final AnagramGroupingService groupingService = new AnagramGroupingService();
    private final OutputWriter outputWriter = new OutputWriter();

    @Override
    public void run(String... args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Please ensure that the input file is provided");
        }
        String filePath = args[0];
        FileReaderService readerService = new FileReaderService(filePath);

        List<String> words;
        while ((words = readerService.readWordsOfSameLength()) != null) {
            List<List<String>> grouped = groupingService.groupAnagrams(words);
            outputWriter.write(grouped);
        }

        readerService.close();
    }
}