package advent2021.days.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    int x;
    int y;

    public boolean makesHorizontalLineWith(Point point) {
        return this.getY() == point.getY();
    }

    public boolean makesVerticalLineWith(Point point) {
        return this.getX() == point.getX();
    }

    public boolean makesPositiveDiagonalWith(Point point) {
        return (point.getY() - this.getY()) == (point.getX() - this.getX());
    }

    public boolean makesNegativeDiagonalWith(Point point) {
        return (point.getY() - this.getY()) == (this.getX() - point.getX());
    }
}
