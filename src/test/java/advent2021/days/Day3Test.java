package advent2021.days;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {
    
    private Day3 subject = new Day3();

    @Test
    void getPowerConsumptionForTestInput_returns198() {
        var result = subject.getPowerConsumption("testInput.txt");

        assertThat(result).isEqualTo(198);
    }

    @Test
    void getPowerConsumption_answer() {
        var result = subject.getPowerConsumption("input.txt");

        System.out.println(result);
    }

    @Test
    void getLifeSupportRating_returns230ForTestInput() {
        var result = subject.getLifeSupportRating("testInput.txt");

        assertThat(result).isEqualTo(230);
    }

    @Test
    void getLifeSupportRating_answer() {
        var result = subject.getLifeSupportRating("input.txt");

        System.out.println(result);
    }
}