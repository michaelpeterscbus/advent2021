package advent2021.days;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class Day6 {

    @SneakyThrows
    public long getLaternfishCount(String filename, int days) {
        var file = new File("src/test/resources/day6/" + filename);
        var fishList = Arrays.stream(Files.readString(file.toPath()).split(",")).map(Integer::parseInt).collect(toList());

        var counts = new long[9];
        for (int fish : fishList) {
            counts[fish]++;
        }

        for (int i = 0; i < days; i++){
            long zeroCount = counts[0];

            for (int j = 0; j < counts.length - 1; j++) {
                counts[j] = counts[j + 1];
            }
            counts[6] += zeroCount;
            counts[8] = zeroCount;
        }
        return Arrays.stream(counts).sum();
    }
}
