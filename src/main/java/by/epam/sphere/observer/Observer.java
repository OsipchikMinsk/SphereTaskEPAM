package by.epam.sphere.observer;

import by.epam.sphere.entity.Figure;
import by.epam.sphere.observer.spereObserverImpl.SphereParameter;

public interface Observer<E, F extends Figure> {
    void update(Object eventType, Observer figure);

}
