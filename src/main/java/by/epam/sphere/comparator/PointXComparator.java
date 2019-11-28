package by.epam.sphere.comparator;

import by.epam.sphere.entity.Point;

import java.util.Comparator;

public class PointXComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        double coordinateXFirstPoint;
        double coordinateXSecondPoint;
        coordinateXFirstPoint = o1.getX();
        coordinateXSecondPoint = o2.getX();
        return (coordinateXFirstPoint < coordinateXSecondPoint) ? 1 :
                (coordinateXFirstPoint > coordinateXSecondPoint) ? -1 : 0;
    }
}
