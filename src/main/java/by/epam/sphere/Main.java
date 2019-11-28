package by.epam.sphere;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.observer.sphereObsevableImpl.EventManagerImpl;
import by.epam.sphere.observer.Observer;
import by.epam.sphere.observer.spereObserverImpl.SphereWrapper;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Sphere s1 = new Sphere(new Point(2,3,4),10);
        Sphere s2 = new Sphere(new Point(2,3,4),15);
        Sphere s3 = new Sphere(new Point(2,3,4),20);
        SphereWrapper sw1 = new SphereWrapper(s1);
        SphereWrapper sw2 = new SphereWrapper(s2);
        SphereWrapper sw3 = new SphereWrapper(s3);
        List<Observer> sphereList = new ArrayList<>();
        sphereList.add(sw1);
        sphereList.add(sw2);
        sphereList.add(sw3);
        EventManagerImpl eventManager = new EventManagerImpl(sphereList);
        eventManager.subscribe(EventManagerImpl.Events.RADIUS_CHANGE,sw1);
        eventManager.subscribe(EventManagerImpl.Events.RADIUS_CHANGE,sw2);
        eventManager.subscribe(EventManagerImpl.Events.RADIUS_CHANGE,sw3);
        eventManager.subscribe(EventManagerImpl.Events.POINT_CHANGE,sw1);
        eventManager.subscribe(EventManagerImpl.Events.POINT_CHANGE,sw2);
        eventManager.subscribe(EventManagerImpl.Events.POINT_CHANGE,sw3);
       s1.setEventManager(eventManager);
       s2.setEventManager(eventManager);
       s3.setEventManager(eventManager);
       eventManager.unsubscribe(EventManagerImpl.Events.RADIUS_CHANGE,sw1);
       eventManager.unsubscribe(EventManagerImpl.Events.RADIUS_CHANGE,sw1);
        //s1.setCenter(new Point(0,0,0));
        s1.setRadius(100);





    }
}
