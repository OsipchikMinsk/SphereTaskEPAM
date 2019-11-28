package by.epam.sphere.repository.specification.specificationImpl;

import by.epam.sphere.entity.Figure;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.logic.SphereLogic;
import by.epam.sphere.repository.specification.Specification;

public class SphereAreaSpecification implements Specification {

    private double minValue;
    private double maxValue;

    public SphereAreaSpecification(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean specify(Figure figure) {
        Sphere sphere = (Sphere) figure;
        SphereLogic sphereLogic = SphereLogic.getInstance();
        double sphereArea;
        sphereArea = sphereLogic.calculateSphereArea(sphere);
        return this.minValue<=sphereArea&&this.maxValue>=sphereArea;
    }
}
