package by.epam.sphere.comparator;

import by.epam.sphere.entity.Point;

import java.util.Comparator;

public class PointYComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double coordinateYFirstPoint;
        double coordinateYSecondPoint;
        coordinateYFirstPoint = o1.getX();
        coordinateYSecondPoint = o2.getX();
        return (coordinateYFirstPoint < coordinateYSecondPoint) ? 1 :
                (coordinateYFirstPoint > coordinateYSecondPoint) ? -1 : 0;
    }
}
