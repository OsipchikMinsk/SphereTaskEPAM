package by.epam.sphere.observer;

import by.epam.sphere.entity.Figure;
import by.epam.sphere.entity.Sphere;

public interface Observer<E, F extends Figure>{
    void update(E eventType, F figure);

}
