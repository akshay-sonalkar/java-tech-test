package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderServiceTest {

    @Test
    void shouldReadWordsFromFile() throws IOException {
        Path tempFile = Files.createTempFile("anagram-test", ".txt");
        Files.write(tempFile, List.of("abc", "bac", "cba"));

        FileReaderService service = new FileReaderService();
        List<String> words = service.readWordsFromFile(tempFile.toString());

        assertThat(words).containsExactly("abc", "bac", "cba");

        Files.deleteIfExists(tempFile);
    }

    @Test
    void shouldThrowExceptionWhenFileNotFound() {
        FileReaderService service = new FileReaderService();
        Exception exception = assertThrows(IOException.class, () -> service.readWordsFromFile("notExists.txt"));
        assertThat(exception.getMessage()).isEqualTo("notExists.txt Does not exist");
    }
}
