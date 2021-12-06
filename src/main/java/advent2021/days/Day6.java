package advent2021.days;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Day6 {

    @SneakyThrows
    public int getLaternfishCount(String filename, int days) {
        var file = new File("src/test/resources/day6/" + filename);
        var fishList = Arrays.stream(Files.readString(file.toPath()).split(",")).map(Integer::parseInt).collect(toList());

        for (int i = 0; i < days; i++){
            int fishCount = fishList.size();
            for (int j = 0; j < fishCount; j++) {
                int fish = fishList.get(j);
                if (fish == 0) {
                    fishList.set(j, 6);
                    fishList.add(8);
                } else {
                    fishList.set(j, fish - 1);
                }
            }
        }
        return fishList.size();
    }
}
