package advent2021.days;

import advent2021.days.util.Point;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class Day5 {

    @SneakyThrows
    public long getOverlapCount(String filename, boolean shouldCheckForDiagonal) {
        var br = getBufferedReader(filename);
        String input;
        var pointMap = new HashMap<Point, Integer>();
        while ((input = br.readLine()) != null) {
            var points = getPoints(input);

            if (points[0].makesHorizontalLineWith(points[1])) {
                addPointsInHorizontalLine(pointMap, points);
            } else if (points[0].makesVerticalLineWith(points[1])) {
                addPointsInVerticalLine(pointMap, points);
            } else if (shouldCheckForDiagonal && points[0].makesPositiveDiagonalWith(points[1])) {
                addPointsInPositiveDiagonal(pointMap, points);
            } else if (shouldCheckForDiagonal && points[0].makesNegativeDiagonalWith(points[1])) {
                addPointsInNegativeDiagonal(pointMap, points);
            }
        }
        return getOverlapCount(pointMap);
    }

    private Point[] getPoints(String input) {
        var points = input.split("->");
        var pointArray = new Point[2];

        for (int i = 0; i < points.length; i++) {
            var coordinates = points[i].split(",");
            var point = new Point();
            point.setX(parseInt(coordinates[0].trim()));
            point.setY(parseInt(coordinates[1].trim()));
            pointArray[i] = point;
        }
        return pointArray;
    }

    private void addPointsInHorizontalLine(HashMap<Point, Integer> pointMap, Point[] points) {
        int min = Math.min(points[0].getX(), points[1].getX());
        int max = Math.max(points[0].getX(), points[1].getX());
        for (int i = min; i <= max; i++) {
            Point point = new Point(i, points[0].getY());
            pointMap.put(point, 1 + pointMap.getOrDefault(point, 0));
        }
    }

    private void addPointsInVerticalLine(HashMap<Point, Integer> pointMap, Point[] points) {
        int min = Math.min(points[0].getY(), points[1].getY());
        int max = Math.max(points[0].getY(), points[1].getY());
        for (int i = min; i <= max; i++) {
            Point point = new Point(points[0].getX(), i);
            pointMap.put(point, 1 + pointMap.getOrDefault(point, 0));
        }
    }

    private void addPointsInPositiveDiagonal(HashMap<Point, Integer> pointMap, Point[] points) {
        int minX = Math.min(points[0].getX(), points[1].getX());
        int maxX = Math.max(points[0].getX(), points[1].getX());

        int yCoord = Math.min(points[0].getY(), points[1].getY());
        for (int i = minX; i <= maxX; i++) {
            Point point = new Point(i, yCoord);
            pointMap.put(point, 1 + pointMap.getOrDefault(point, 0));
            yCoord++;
        }
    }

    private void addPointsInNegativeDiagonal(HashMap<Point, Integer> pointMap, Point[] points) {
        int minX = Math.min(points[0].getX(), points[1].getX());
        int maxX = Math.max(points[0].getX(), points[1].getX());

        int yCoord = Math.max(points[0].getY(), points[1].getY());
        for (int i = minX; i <= maxX; i++) {
            Point point = new Point(i, yCoord);
            pointMap.put(point, 1 + pointMap.getOrDefault(point, 0));
            yCoord--;
        }
    }

    private int getOverlapCount(HashMap<Point, Integer> pointMap) {
        return (int) pointMap.entrySet().stream()
                .filter(point -> point.getValue() >= 2)
                .count();
    }

    @SneakyThrows
    private BufferedReader getBufferedReader(String filename) {
        var file = new File("src/test/resources/day5/" + filename);
        return new BufferedReader(new FileReader(file));
    }
}
