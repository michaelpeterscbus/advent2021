package advent2021.days;

import lombok.SneakyThrows;
import org.checkerframework.checker.units.qual.A;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Day3 {

    @SneakyThrows
    public int getPowerConsumption(String filename) {
        var file = new File("src/test/resources/day3/" + filename);
        var bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.mark(1);
        var input = bufferedReader.readLine();
        var binaryArr = new int[input.length()];

        bufferedReader.reset();
        while((input = bufferedReader.readLine()) != null) {
            var inputArr = input.split("");
            for (int i = 0; i < inputArr.length; i++){
                if (inputArr[i].equals("1")) {
                    binaryArr[i] = binaryArr[i] + 1;
                } else {
                    binaryArr[i] = binaryArr[i] - 1;
                }
            }
        }
        var gammaRate = new StringBuilder();
        var epsilonRate = new StringBuilder();
        for (int i = 0; i < binaryArr.length; i++) {
            if (binaryArr[i] > 0) {
                gammaRate.append(1);
                epsilonRate.append(0);
            } else {
                gammaRate.append(0);
                epsilonRate.append(1);
            }
        }


        return parseInt(gammaRate.toString(), 2) * parseInt(epsilonRate.toString(), 2);
    }

    @SneakyThrows
    public int getLifeSupportRating(String filename) {
        var oxygenList = getInputList(filename);
        var c02List = getInputList(filename);

        var oxygen = getOxygenGeneratorRating(oxygenList);
        var c02 = getC02ScrubberRating(c02List);


        return parseInt(oxygen, 2) * parseInt(c02, 2);
    }

    private String getOxygenGeneratorRating(List<String> list) throws IOException {
        var numLength = list.get(0).length();
        for (int i = 0; i < numLength; i++) {
            var zeroes = new ArrayList<String>();
            var ones = new ArrayList<String>();
            for (int j = 0; j < list.size(); j++) {
                var currentNumber = list.get(j);
                if (list.get(j).charAt(i) == '0') {
                    zeroes.add(currentNumber);
                } else {
                    ones.add(currentNumber);
                }
            }

            if (zeroes.size() > ones.size()) {
                list.removeAll(ones);
            } else {
                list.removeAll(zeroes);
            }
            if (list.size() == 1) {
                break;
            }
        }
        return list.get(0);
    }

    private String getC02ScrubberRating(List<String> list) throws IOException {
        var numLength = list.get(0).length();
        for (int i = 0; i < numLength; i++) {
            var zeroes = new ArrayList<String>();
            var ones = new ArrayList<String>();
            for (int j = 0; j < list.size(); j++) {
                var currentNumber = list.get(j);
                if (list.get(j).charAt(i) == '0') {
                    zeroes.add(currentNumber);
                } else {
                    ones.add(currentNumber);
                }
            }

            if (zeroes.size() > ones.size()) {
                list.removeAll(zeroes);
            } else {
                list.removeAll(ones);
            }
            if (list.size() == 1) {
                break;
            }
        }
        return list.get(0);
    }

    private List<String> getInputList(String filename) throws IOException {
        var file = new File("src/test/resources/day3/" + filename);
        var bufferedReader = new BufferedReader(new FileReader(file));
        String input;
        var list = new ArrayList<String>();
        while((input = bufferedReader.readLine()) != null) {
            list.add(input);
        }
        return list;
    }

}
