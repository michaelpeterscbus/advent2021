package advent2021.days;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day4Test {
    private Day4 subject = new Day4();

    @Test
    void bingoWithTestInput_returns4512() {
        var result = subject.bingo("testInput.txt", "first");

        assertThat(result).isEqualTo(4512);
    }

    @Test
    void bingo_answer() {
        var result = subject.bingo("input.txt", "first");

        System.out.println(result);
    }

    @Test
    void lastBingoWithTestInput_returns1924() {
        var result = subject.bingo("testInput.txt", "last");

        assertThat(result).isEqualTo(1924);
    }

    @Test
    void lastBingo_answer() {
        var result = subject.bingo("input.txt", "last");

        System.out.println(result);
    }
}