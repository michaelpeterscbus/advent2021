package advent2021.days;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Day7 {

    @SneakyThrows
    public int getLeastFuelCount(String filename) {
        var nums = getListOfNumbers(filename);

        int count = 0;
        int median = nums.get(nums.size()/2);

        for (int num : nums) {
            count += Math.abs(num - median);
        }

        return count;
    }

    @SneakyThrows
    public int getTriangularFuelCount(String filename) {
        var nums = getListOfNumbers(filename);

        int position = nums.get(0);
        int min = Integer.MAX_VALUE;
        while (position <= nums.get(nums.size() - 1)) {
            int count = 0;
            for (int num : nums) {
                var distance = Math.abs(num - position);
                count += (distance * ( distance + 1)) / 2;
            }
            min = Math.min(count, min);
            position++;
        }
        return min;
    }

    private List<Integer> getListOfNumbers(String filename) throws IOException {
        var file = new File("src/test/resources/day7/" + filename);
        var nums = Arrays.stream(Files.readString(file.toPath()).split(",")).map(Integer::parseInt).sorted().collect(toList());
        return nums;
    }
}
