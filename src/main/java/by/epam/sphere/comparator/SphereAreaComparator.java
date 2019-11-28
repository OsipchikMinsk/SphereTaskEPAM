package by.epam.sphere.comparator;

import by.epam.sphere.entity.Sphere;
import by.epam.sphere.logic.SphereLogic;

import java.util.Comparator;

public class SphereAreaComparator implements Comparator<Sphere> {
    private SphereLogic sphereLogic = SphereLogic.getInstance();


    @Override
    public int compare(Sphere o1, Sphere o2) {
        double areaOfFirstSphere;
        double areaOfSecondSphere;
        areaOfFirstSphere = sphereLogic.calculateSphereArea(o1);
        areaOfSecondSphere = sphereLogic.calculateSphereArea(o2);
        return (areaOfFirstSphere < areaOfSecondSphere) ? 1 :
                (areaOfFirstSphere > areaOfSecondSphere) ? -1 : 0;
    }
}
