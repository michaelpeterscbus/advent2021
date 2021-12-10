package advent2021.days;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day8Test {
    private Day8 subject = new Day8();

    @Test
    void getEasyDigitCount_returns26ForTestInput() {
        var result = subject.getEasyDigitCount("testInput.txt");

        assertThat(result).isEqualTo(26);
    }

    @Test
    void getEasyDigitCount_answer() {
        var result = subject.getEasyDigitCount("input.txt");

        System.out.println(result);
    }

    @Test
    void getTotalOutput_returns61229ForTestInput() {
        var result = subject.getTotalOutput("testInput.txt");

        assertThat(result).isEqualTo(61229);
    }

    @Test
    void getTotalOutput_answer() {
        var result = subject.getTotalOutput("input.txt");

        System.out.println(result);
    }
}