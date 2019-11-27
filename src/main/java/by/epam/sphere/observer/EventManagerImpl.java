package by.epam.sphere.observer;

import by.epam.sphere.entity.Sphere;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class EventManagerImpl implements EventManager {
    Map<String, List<SphereInterface>> listeners = new HashMap<>();

    public EventManagerImpl(List<SphereInterface> listenerList) {
        Stream.of(Events.values()).forEach(event -> {
            listeners.put(event.name(), listenerList);
        });
    }


    @Override
    public void subscribe(String eventType, SphereInterface listener) {
        List<SphereInterface> spheres = listeners.get(eventType);
        if (!spheres.contains(listener)) {
            spheres.add(listener);
        }
    }

    @Override
    public void unsubscribe(String eventType, SphereInterface listener) {
        List<SphereInterface> spheres = listeners.get(eventType);
        spheres.remove(listener);
    }

    @Override
    public void notify(String eventType, Sphere sphere) {
        List<SphereInterface> spheres = listeners.get(eventType);
        spheres.forEach(sp -> sp.update(eventType, sphere));
    }
}
