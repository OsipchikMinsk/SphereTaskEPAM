package by.epam.sphere.comparator;

import by.epam.sphere.entity.Sphere;

import java.util.Comparator;

public class SphereRadiusComparator implements Comparator<Sphere> {
    @Override
    public int compare(Sphere o1, Sphere o2) {
        double radiusFirstSphere;
        double radiusSecondSphere;
        radiusFirstSphere = o1.getRadius();
        radiusSecondSphere = o2.getRadius();
        return (radiusFirstSphere < radiusFirstSphere) ? 1 :
                (radiusFirstSphere > radiusSecondSphere) ? -1 : 0;
    }
}
