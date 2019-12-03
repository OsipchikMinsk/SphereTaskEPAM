package by.epam.sphere.observer;

public interface Observable<T, S> {

    void subscribe(T eventType, S listener);

    void unsubscribe(T eventType, S listener);

    void notify(T eventType, S listeners);
}
