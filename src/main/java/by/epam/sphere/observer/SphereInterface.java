package by.epam.sphere.observer;

import by.epam.sphere.entity.Sphere;

public interface SphereInterface <T> {
    void update(String eventType, Sphere sphere);

}
