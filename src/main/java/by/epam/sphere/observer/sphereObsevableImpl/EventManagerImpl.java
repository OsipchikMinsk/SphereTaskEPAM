package by.epam.sphere.observer.sphereObsevableImpl;

import by.epam.sphere.observer.Observable;
import by.epam.sphere.observer.Observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class EventManagerImpl implements Observable<EventManagerImpl.Events, Observer> {

    Map<String, List<Observer>> listeners = new HashMap<>();

    public enum Events{
        POINT_CHANGE,
        RADIUS_CHANGE
    }

    public EventManagerImpl(List<Observer> listenerList) {
        Stream.of(EventManagerImpl.Events.values()).forEach(event -> {
            listeners.put(event.name(), listenerList);
        });
    }

    @Override
    public void subscribe(EventManagerImpl.Events eventType, Observer listener) {
        List<Observer> spheres = listeners.get(eventType);
        if (!spheres.contains(listener)) {
            spheres.add(listener);
        }
    }

    @Override
    public void unsubscribe(EventManagerImpl.Events eventType, Observer listener) {
        List<Observer> spheres = listeners.get(eventType);
        spheres.remove(listener);
    }

    @Override
    public void notify(EventManagerImpl.Events eventType, Observer listener) {
        List<Observer> spheres = listeners.get(eventType);
        spheres.forEach(sp -> sp.update(eventType,listener));
    }
}
