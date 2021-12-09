package advent2021.days;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day7Test {
    private Day7 subject = new Day7();

    @Test
    void getLeastFuelCount_returns37ForTestInput() {
        var result = subject.getLeastFuelCount("testInput.txt");

        assertThat(result).isEqualTo(37);
    }

    @Test
    void getLeastFuelCount_answer() {
        var result = subject.getLeastFuelCount("input.txt");

        System.out.println(result);
    }

    @Test
    void getTriangularFuelCount_returns168ForTestInput() {
        var result = subject.getTriangularFuelCount("testInput.txt");

        assertThat(result).isEqualTo(168);
    }

    @Test
    void getTriangularFuelCount_answer() {
        var result = subject.getTriangularFuelCount("input.txt");

        System.out.println(result);
    }
}