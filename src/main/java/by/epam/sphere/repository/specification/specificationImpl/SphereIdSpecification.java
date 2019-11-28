package by.epam.sphere.repository.specification.specificationImpl;

import by.epam.sphere.entity.Figure;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.repository.specification.Specification;

public class SphereIdSpecification implements Specification {
    private int minValue;
    private int maxValue;

    public SphereIdSpecification(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean specify(Figure figure) {
        if(figure.getClass()==Sphere.class){
            int id = figure.getId();
            return id>=this.minValue&&id<=this.maxValue;
        }
        return false;
    }
}

