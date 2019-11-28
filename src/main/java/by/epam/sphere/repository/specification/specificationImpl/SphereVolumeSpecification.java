package by.epam.sphere.repository.specification.specificationImpl;

import by.epam.sphere.entity.Figure;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.logic.SphereLogic;
import by.epam.sphere.repository.specification.Specification;

public class SphereVolumeSpecification implements Specification {

    private double minValue;
    private double maxValue;

    public SphereVolumeSpecification(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean specify(Figure figure) {
        Sphere sphere = (Sphere) figure;
        SphereLogic sphereLogic = SphereLogic.getInstance();
        double sphereVolume;
        sphereVolume = sphereLogic.calcSphereVolume(sphere);
        return this.minValue<=sphereVolume&&this.maxValue>=sphereVolume;
    }
}
