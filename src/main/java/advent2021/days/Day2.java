package advent2021.days;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static java.lang.Integer.parseInt;

public class Day2 {

    @SneakyThrows
    public int getHorizontalPositionAndDepth(String filename) {
        var file = new File("src/test/resources/day2/" + filename);
        var bufferedReader = new BufferedReader(new FileReader(file));
        String input;
        int horizontalPosition = 0;
        int depth = 0;
        while ((input = bufferedReader.readLine()) != null) {
            var lineArr = input.split(" ");
            switch (lineArr[0]) {
                case "forward" -> horizontalPosition += parseInt(lineArr[1]);
                case "down" -> depth += parseInt(lineArr[1]);
                case "up" -> depth -= parseInt(lineArr[1]);
            }
        }
        return horizontalPosition * depth;
    }

    @SneakyThrows
    public int getHorizontalPositionAndDepthWithAim(String filename) {
        var file = new File("src/test/resources/day2/" + filename);
        var bufferedReader = new BufferedReader(new FileReader(file));
        String input;
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        while ((input = bufferedReader.readLine()) != null) {
            var lineArr = input.split(" ");
            switch (lineArr[0]) {
                case "forward" -> {
                    horizontalPosition += parseInt(lineArr[1]);
                    depth += (aim * parseInt(lineArr[1]));
                }
                case "down" -> aim += parseInt(lineArr[1]);
                case "up" -> aim -= parseInt(lineArr[1]);
            }
        }
        return horizontalPosition * depth;
    }
}
