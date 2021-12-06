package advent2021.days;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day5Test {

    private Day5 subject = new Day5();

    @Test
    void getOverlapCountWithTestInput_returns5() {
        var result = subject.getOverlapCount("testInput.txt", false);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void getOverlapCount_answer() {
        var result = subject.getOverlapCount("input.txt", false);

        System.out.println(result);
    }

    @Test
    void getOverlapCountWithDiagonal_returns12ForTestInput() {
        var result = subject.getOverlapCount("testInput.txt", true);

        assertThat(result).isEqualTo(12);
    }

    @Test
    void getOverlapCountWithDiagonal_answer() {
        var result = subject.getOverlapCount("input.txt", true);

        System.out.println(result);
    }
}