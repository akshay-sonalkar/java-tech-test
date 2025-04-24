package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramGroupingServiceTest {

    @Test
    void shouldGroupWordsByAnagram() {
        AnagramGroupingService service = new AnagramGroupingService();

        List<String> input = Arrays.asList("abc", "bca", "cab", "fun", "unf", "hello");
        List<List<String>> grouped = service.groupAnagrams(input);

        assertThat(grouped).hasSize(3);
        assertThat(grouped).anySatisfy(group -> assertThat(group).containsExactlyInAnyOrder("abc", "bca", "cab"));
        assertThat(grouped).anySatisfy(group -> assertThat(group).containsExactlyInAnyOrder("fun", "unf"));
        assertThat(grouped).anySatisfy(group -> assertThat(group).containsExactly("hello"));
    }

    @Test
    void shouldHandleEdgeCases() {
        AnagramGroupingService service = new AnagramGroupingService();

        List<String> input = Arrays.asList("", "a", "A", "abc", "cab", "123", "231", "!", "!");
        List<List<String>> grouped = service.groupAnagrams(input);

        assertThat(grouped).hasSize(6);
        assertThat(grouped).anySatisfy(group -> assertThat(group).containsExactly(""));
        assertThat(grouped).anySatisfy(group -> assertThat(group).containsExactly("a"));
        assertThat(grouped).anySatisfy(group -> assertThat(group).containsExactly("A"));
        assertThat(grouped).anySatisfy(group -> assertThat(group).containsExactlyInAnyOrder("abc", "cab"));
        assertThat(grouped).anySatisfy(group -> assertThat(group).containsExactlyInAnyOrder("123", "231"));
        assertThat(grouped).anySatisfy(group -> assertThat(group).containsExactly("!", "!"));
    }
}
