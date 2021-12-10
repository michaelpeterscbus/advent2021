package advent2021.days;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day8 {

    @SneakyThrows
    public int getEasyDigitCount(String filename) {
        var file = new File("src/test/resources/day8/" + filename);
        var bufferedReader = new BufferedReader(new FileReader(file));

        String input;
        int count = 0;
        while ((input = bufferedReader.readLine()) != null) {
            var splitInput = input.split(" \\| ");
            var output = splitInput[1].split(" ");


            for (String segment : output) {
                var length = segment.length();
                if (length == 2 || length == 3 || length == 4 || length == 7) {
                    count++;
                }
            }
        }
        return count;
    }

    @SneakyThrows
    public int getTotalOutput(String filename) {
        var file = new File("src/test/resources/day8/" + filename);
        var bufferedReader = new BufferedReader(new FileReader(file));

        String input;
        int count = 0;
        while ((input = bufferedReader.readLine()) != null) {
            var splitInput = input.split(" \\| ");
            var output = splitInput[1].split(" ");
            var inputSegments = splitInput[0].split(" ");
            var segmentList = new ArrayList<String>();
            String one = "", seven = "", four = "";

            for (String segment : inputSegments) {
                switch (segment.length()) {
                    case 2 -> one = segment;
                    case 3 -> seven = segment;
                    case 4 -> four = segment;
                }
            }
            var map = new HashMap<Character, char[]>();
            map.put('c', one.toCharArray());
            map.put('f', one.toCharArray());
            seven = seven.replace(String.valueOf(one.charAt(0)), "");
            seven = seven.replace(String.valueOf(one.charAt(1)), "");
            map.put('a', new char[]{seven.charAt(0)});
            four = four.replace(String.valueOf(one.charAt(0)), "");
            four = four.replace(String.valueOf(one.charAt(1)), "");
            map.put('b', four.toCharArray());
            map.put('d', four.toCharArray());

            for (String segment : inputSegments) {
                if (isThree(map, segment)) {
                    segmentList.add(segment);
                    var three = segment;
                    three = three.replace(String.valueOf(one.charAt(0)), "");
                    three = three.replace(String.valueOf(one.charAt(1)), "");
                    three = three.replace(String.valueOf(map.get('a')[0]), "");
                    for (int i = 0; i < three.length(); i++){
                        var current = three.charAt(i);
                        if (current != map.get('b')[0] && current != map.get('d')[1]) {
                            map.put('g', new char[]{three.charAt(i)});
                            three = three.replace(String.valueOf(three.charAt(i)), "");
                            break;
                        }
                    }
                    var d = map.get('d');
                    if (three.charAt(0) == d[0]) {
                        map.put('d', new char[]{d[0]});
                        map.put('b', new char[]{d[1]});
                    } else {
                        map.put('d', new char[]{d[1]});
                        map.put('b', new char[]{d[0]});
                    }
                }
            }

            for (String segment : inputSegments) {
                if (isFive(map, segment) && !segmentList.contains(segment)) {
                    segmentList.add(segment);
                    var five = segment;
                    five = five.replace(String.valueOf(map.get('a')[0]), "");
                    five = five.replace(String.valueOf(map.get('b')[0]), "");
                    five = five.replace(String.valueOf(map.get('d')[0]), "");
                    five = five.replace(String.valueOf(map.get('g')[0]), "");
                    map.put('f', new char[]{five.charAt(0)});
                    var c = map.get('c');
                    if(c[0] == five.charAt(0)) {
                        map.put('c', new char[]{c[1]});
                    } else {
                        map.put('c', new char[]{c[0]});
                    }
                }
            }

            for (String segment : inputSegments) {
                if (segment.length() == 7) {
                    var eight = segment;
                    eight = eight.replace(String.valueOf(map.get('a')), "");
                    eight = eight.replace(String.valueOf(map.get('b')), "");
                    eight = eight.replace(String.valueOf(map.get('c')), "");
                    eight = eight.replace(String.valueOf(map.get('d')), "");
                    eight = eight.replace(String.valueOf(map.get('f')), "");
                    eight = eight.replace(String.valueOf(map.get('g')), "");
                    map.put('e', new char[]{eight.charAt(0)});
                }
            }


            var a = String.valueOf(map.get('a')[0]);
            var b = String.valueOf(map.get('b')[0]);
            var c = String.valueOf(map.get('c')[0]);
            var d = String.valueOf(map.get('d')[0]);
            var e = String.valueOf(map.get('e')[0]);
            var f = String.valueOf(map.get('f')[0]);
            var g = String.valueOf(map.get('g')[0]);
            var normalMap = new HashMap<String, String>();
            var zero = (a+b+c+e+f+g).toCharArray();
            Arrays.sort(zero);
            normalMap.put("0", new String(zero));

            var one1 = (c+f).toCharArray();
            Arrays.sort(one1);
            normalMap.put("1", new String(one1));

            var two = (a+c+d+e+g).toCharArray();
            Arrays.sort(two);
            normalMap.put("2", new String(two));

            var three = (a+c+d+f+g).toCharArray();
            Arrays.sort(three);
            normalMap.put("3", new String(three));

            var four4 = (b+c+d+f).toCharArray();
            Arrays.sort(four4);
            normalMap.put("4", new String(four4));

            var five = (a+b+d+f+g).toCharArray();
            Arrays.sort(five);
            normalMap.put("5", new String(five));

            var six = (a+b+d+e+f+g).toCharArray();
            Arrays.sort(six);
            normalMap.put("6", new String(six));

            var seven7 = (a+c+f).toCharArray();
            Arrays.sort(seven7);
            normalMap.put("7", new String(seven7));

            var eight = (a+b+c+d+e+f+g).toCharArray();
            Arrays.sort(eight);
            normalMap.put("8", new String(eight));

            var nine = (a+b+c+d+f+g).toCharArray();
            Arrays.sort(nine);
            normalMap.put("9", new String(nine));

            var outputStr = new StringBuilder();
            for (int i = 0; i < output.length; i++){
                var outputArr = output[i].toCharArray();
                Arrays.sort(outputArr);
                for (Map.Entry<String, String> entry : normalMap.entrySet()) {
                    if (entry.getValue().equals(new String(outputArr))) {
                        outputStr.append(entry.getKey());
                    }
                }
            }
            count += Integer.parseInt(outputStr.toString());
        }
        return count;
    }

    private boolean isThree(HashMap<Character, char[]> map, String segment) {
        return segment.length() == 5 &&
                segment.contains(String.valueOf(map.get('a')[0])) &&
                segment.contains(String.valueOf(map.get('c')[0])) &&
                segment.contains(String.valueOf(map.get('c')[1])) &&
                (segment.contains(String.valueOf(map.get('b')[0])) ^
                        segment.contains(String.valueOf(map.get('b')[1])));
    }

    private boolean isFive(HashMap<Character, char[]> map, String segment) {
        return segment.length() == 5 &&
                segment.contains(String.valueOf(map.get('a')[0])) &&
                segment.contains(String.valueOf(map.get('b')[0])) &&
                segment.contains(String.valueOf(map.get('d')[0])) &&
                (segment.contains(String.valueOf(map.get('c')[0])) ^
                        segment.contains(String.valueOf(map.get('c')[1]))) &&
                segment.contains(String.valueOf(map.get('g')[0]));
    }
}
