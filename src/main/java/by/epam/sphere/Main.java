package by.epam.sphere;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.observer.EventManagerImpl;
import by.epam.sphere.observer.Events;
import by.epam.sphere.observer.SphereInterface;
import by.epam.sphere.observer.SphereWrapper;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Sphere s1 = new Sphere(new Point(2,3,4),10);
        Sphere s2 = new Sphere(new Point(2,3,4),15);
        Sphere s3 = new Sphere(new Point(2,3,4),20);
        SphereWrapper sw1 = new SphereWrapper(s1);
        SphereWrapper sw2 = new SphereWrapper(s1);
        SphereWrapper sw3 = new SphereWrapper(s1);
        List<SphereInterface> sphereList = new ArrayList<>();
        sphereList.add(sw1);
        sphereList.add(sw2);
        sphereList.add(sw3);
        EventManagerImpl eventManager = new EventManagerImpl(sphereList);
        eventManager.subscribe(Events.RADIUS_CHANGE.toString(),sw1);
        eventManager.subscribe(Events.RADIUS_CHANGE.toString(),sw2);
        eventManager.subscribe(Events.RADIUS_CHANGE.toString(),sw3);
        eventManager.subscribe(Events.POINT_CHANGE.toString(),sw1);
        eventManager.subscribe(Events.POINT_CHANGE.toString(),sw2);
        eventManager.subscribe(Events.POINT_CHANGE.toString(),sw3);
       s1.setEventManager(eventManager);
       s2.setEventManager(eventManager);
       s3.setEventManager(eventManager);
       s1.setRadius(100);
       s1.setCenter(new Point(0,0,0));







    }
}
