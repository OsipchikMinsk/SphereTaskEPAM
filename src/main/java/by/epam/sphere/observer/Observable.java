package by.epam.sphere.observer;

import by.epam.sphere.entity.Sphere;

public interface Observable<T, S> {

    void subscribe(T eventType, S listener);

    void unsubscribe(T eventType, S listener);

    void notify(T eventType, S listeners);
}
