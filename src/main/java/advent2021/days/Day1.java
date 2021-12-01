package advent2021.days;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;

import static java.lang.Integer.*;

public class Day1 {

    public int countDepthIncreases(String filename) {
       var input = getInputArray(filename);
       int count = 0;
       int prev = input[0];

       for (int i = 1; i < input.length; i++) {
           int current = input[i];
           if (current > prev) {
               count++;
           }
           prev = current;
       }
       return count;
    }

    public int getSlidingWindowCount(String filename) {
        var input = getInputArray(filename);

        int prev = input[0] + input[1] + input[2];
        int count = 0;

        for (int i = 3; i < input.length; i++){
            int current = prev - input[i - 3] + input[i];
            if (current > prev) {
                count++;
            }
            prev = current;
        }

        return count;
    }

    @SneakyThrows
    private int[] getInputArray(String filename) {
        File file = new File("src/test/resources/day1/" + filename);
        var inputStringArr = Files.readString(file.toPath()).split("\n");
        var input = new int[inputStringArr.length];
        for (int i = 0; i < input.length; i++) {
            input[i] = parseInt(inputStringArr[i]);
        }
        return input;
    }
}
