package advent2021.days;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Day3 {

    @SneakyThrows
    public int getPowerConsumption(String filename) {
        var list = getInputList(filename);
        var numLength = list.get(0).length();
        var binaryArr = new int[numLength];

       for (int i = 0; i < list.size(); i++){
           for (int j = 0; j < numLength; j++) {
               var currentBit = list.get(i).charAt(j);
               if (currentBit == '0') {
                   binaryArr[j] = binaryArr[j] - 1;
               } else {
                   binaryArr[j] = binaryArr[j] + 1;
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
        var c02List = new ArrayList<>(oxygenList);

        var oxygen = getRating(oxygenList, "max");
        var c02 = getRating(c02List, "min");


        return parseInt(oxygen, 2) * parseInt(c02, 2);
    }

    private String getRating(List<String> list, String ratingType) {
        var numLength = list.get(0).length();
        for (int i = 0; i < numLength; i++) {
            var zeroes = new ArrayList<String>();
            var ones = new ArrayList<String>();
            populateZeroesAndOnesLists(list, i, zeroes, ones);

            if (ratingType.equals("max")) {
                removeMinValues(list, zeroes, ones);
            }

            if (ratingType.equals("min")) {
                removeMaxValues(list, zeroes, ones);
            }

            if (list.size() == 1) {
                break;
            }
        }
        return list.get(0);
    }

    private void populateZeroesAndOnesLists(List<String> list, int i, ArrayList<String> zeroes, ArrayList<String> ones) {
        for (int j = 0; j < list.size(); j++) {
            var currentNumber = list.get(j);
            if (list.get(j).charAt(i) == '0') {
                zeroes.add(currentNumber);
            } else {
                ones.add(currentNumber);
            }
        }
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

    private void removeMaxValues(List<String> list, ArrayList<String> zeroes, ArrayList<String> ones) {
        if (zeroes.size() > ones.size()) {
            list.removeAll(zeroes);
        } else {
            list.removeAll(ones);
        }
    }

    private void removeMinValues(List<String> list, ArrayList<String> zeroes, ArrayList<String> ones) {
        if (zeroes.size() > ones.size()) {
            list.removeAll(ones);
        } else {
            list.removeAll(zeroes);
        }
    }

}
