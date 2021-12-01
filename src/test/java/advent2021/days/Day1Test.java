package advent2021.days;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

class Day1Test {
    private Day1 subject = new Day1();

    @Test
    void countDepthIncreases_returns7ForTestInput() {
        var count = subject.countDepthIncreases("testInput.txt");

        assertThat(count).isEqualTo(7);
    }

    @Test
    void countDepthIncreases_answer() {
        var count = subject.countDepthIncreases("input.txt");

        System.out.println(count);
    }

    @Test
    void getSlidingWindowCount_returns5ForTestInput() {
        var count = subject.getSlidingWindowCount("testInput.txt");

        assertThat(count).isEqualTo(5);
    }

    @Test
    void getSlidingWindowCount_answer() {
        var count = subject.getSlidingWindowCount("input.txt");

        System.out.println(count);
    }
}