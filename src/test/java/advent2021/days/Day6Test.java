package advent2021.days;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day6Test {
    private Day6 subject = new Day6();

    @Test
    void getLanternfishCountForTestInput_returns26For18Days() {
        var result = subject.getLaternfishCount("testInput.txt", 18);

        assertThat(result).isEqualTo(26);
    }

    @Test
    void getLanternfishCountForTestInput_returns5934For80Days() {
        var result = subject.getLaternfishCount("testInput.txt", 80);

        assertThat(result).isEqualTo(5934);
    }

    @Test
    void getLanternfishCountForTestInput_256Days() {
        var result = subject.getLaternfishCount("testInput.txt", 256);

        System.out.println(result);
    }

    @Test
    void getLanternfishCount_answer() {
        var result = subject.getLaternfishCount("input.txt", 80);

        System.out.println(result);
    }
}