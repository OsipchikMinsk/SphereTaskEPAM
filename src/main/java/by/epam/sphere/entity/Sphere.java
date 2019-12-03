package by.epam.sphere.entity;

import by.epam.sphere.observer.spereObserverImpl.SphereParameter;
import by.epam.sphere.observer.sphereObsevableImpl.EventManagerImpl;
import java.util.Objects;


public class Sphere implements Figure {

    private Point center;
    private double radius;
    EventManagerImpl eventManager;
    private int id;
    private static int idGenerator = 0;
    SphereParameter sphereParameter;

    {
        idGenerator++;
    }

    public void setEventManager(EventManagerImpl eventManager) {
        this.eventManager = eventManager;
    }

    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        this.id = idGenerator;
        this.sphereParameter = new SphereParameter(this);
        }


    public int getId() {
        return id;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
        eventManager.notify(EventManagerImpl.Events.POINT_CHANGE, sphereParameter);

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        eventManager.notify(EventManagerImpl.Events.RADIUS_CHANGE, sphereParameter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                id == sphere.id &&
                Objects.equals(center, sphere.center) &&
                Objects.equals(eventManager, sphere.eventManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, eventManager, id);
    }

    @Override
    public String toString() {
        return "Observer{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }


}
