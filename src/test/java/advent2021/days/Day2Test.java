package advent2021.days;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Day2Test {
    private Day2 subject = new Day2();

    @Test
    void getHorizontalPositionAndDepth_returns150ForTestInput() {
        var result = subject.getHorizontalPositionAndDepth("testInput.txt");

        assertThat(result).isEqualTo(150);
    }

    @Test
    void getHorizontalPositionAndDepth_answer() {
        var result = subject.getHorizontalPositionAndDepth("input.txt");

        System.out.println(result);
    }

    @Test
    void getHorizontalPositionAndDepthWithAim_returns900ForTestInput() {
        var result = subject.getHorizontalPositionAndDepthWithAim("testInput.txt");

        assertThat(result).isEqualTo(900);
    }

    @Test
    void getHorizontalPositionAndDepthWithAim_answer() {
        var result = subject.getHorizontalPositionAndDepthWithAim("input.txt");

        System.out.println(result);
    }
}