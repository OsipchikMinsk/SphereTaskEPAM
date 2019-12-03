package by.epam.sphere.observer.sphereObsevableImpl;

import by.epam.sphere.observer.Observable;
import by.epam.sphere.observer.Observer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManagerImpl implements Observable<EventManagerImpl.Events, Observer> {

    Map<String, List<Observer>> listeners = new HashMap<>();

    public enum Events{
        POINT_CHANGE,
        RADIUS_CHANGE
    }

    public EventManagerImpl(List<Observer> listenerList) {
        listeners.put(Events.POINT_CHANGE.toString(),listenerList);
        listeners.put(Events.RADIUS_CHANGE.toString(),listenerList);


    }

    @Override
    public void subscribe(Events eventType, Observer listener) {
        List<Observer> spheres;
        spheres = listeners.get(eventType.toString());
        if (!spheres.contains(listener)) {
            spheres.add(listener);
        }
    }

    @Override
    public void unsubscribe(Events eventType, Observer listener) {
        List<Observer> spheres = listeners.get(eventType.toString());
        spheres.remove(listener);
    }


    @Override
    public void notify(Events eventType, Observer listener) {
        List<Observer> spheres = listeners.get(eventType.toString());
        spheres.forEach(sp -> sp.update(eventType,listener));
    }
}
