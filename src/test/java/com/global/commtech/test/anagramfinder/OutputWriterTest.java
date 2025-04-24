package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputWriterTest {

    @Test
    void shouldPrintEachGroupOnNewLine() {
        List<List<String>> grouped = List.of(
                Arrays.asList("abc", "bac"),
                Arrays.asList("fun", "unf"),
                List.of("hello")
        );

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        OutputWriter writer = new OutputWriter();
        writer.write(grouped);

        String output = outContent.toString().trim();
        assertThat(output).contains("abc,bac");
        assertThat(output).contains("fun,unf");
        assertThat(output).contains("hello");
    }
}

