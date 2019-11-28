package by.epam.sphere.comparator;

import by.epam.sphere.entity.Sphere;
import by.epam.sphere.logic.SphereLogic;

import java.util.Comparator;

public class VolumeSphereComparator implements Comparator<Sphere> {
    private SphereLogic sphereLogic = SphereLogic.getInstance();
    @Override
    public int compare(Sphere o1, Sphere o2) {
        double volumeOfFirstSphere;
        double volumeOfSecondSphere;
        volumeOfFirstSphere = sphereLogic.calcSphereVolume(o1);
        volumeOfSecondSphere = sphereLogic.calcSphereVolume(o2);
        return (volumeOfFirstSphere < volumeOfSecondSphere) ? 1 :
                (volumeOfFirstSphere > volumeOfSecondSphere) ? -1 : 0;
    }
}
