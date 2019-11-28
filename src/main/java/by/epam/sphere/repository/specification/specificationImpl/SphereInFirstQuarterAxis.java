package by.epam.sphere.repository.specification.specificationImpl;

import by.epam.sphere.entity.Figure;
import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.repository.specification.Specification;

public class SphereInFirstQuarterAxis implements Specification {


    @Override
    public boolean specify(Figure figure) {
        Sphere sphere = (Sphere) figure;
        Point center = sphere.getCenter();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();
        return x>=0&&y>=0&&z>=0;
    }
}
