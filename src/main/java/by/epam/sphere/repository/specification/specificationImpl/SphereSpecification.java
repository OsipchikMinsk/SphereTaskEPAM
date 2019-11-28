package by.epam.sphere.repository.specification.specificationImpl;

import by.epam.sphere.entity.Figure;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.repository.specification.Specification;

public class SphereSpecification implements Specification {


    @Override
    public boolean specify(Figure figure) {
        return figure.getClass()==Sphere.class;
    }
}
