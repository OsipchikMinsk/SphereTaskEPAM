package by.epam.sphere.observer;

import by.epam.sphere.entity.Sphere;

public interface EventManager <T> {

    void subscribe(String eventType, SphereInterface listener);

    void unsubscribe(String eventType, SphereInterface listener);

    void notify(String eventType, Sphere sphere);
}
