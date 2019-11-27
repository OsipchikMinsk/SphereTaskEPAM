package by.epam.sphere.entity;

import by.epam.sphere.observer.EventManagerImpl;
import by.epam.sphere.observer.Events;
import by.epam.sphere.observer.SphereInterface;

import java.util.List;
import java.util.Objects;



public class Sphere  {//реализация сферы через агрегацию точки HAS A

   private Point center;
   private double radius;
   EventManagerImpl eventManager;
   List<SphereInterface> sphereList;

    public void setEventManager(EventManagerImpl eventManager) {
        this.eventManager = eventManager;
    }

    public Sphere(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        this.eventManager = new EventManagerImpl(sphereList);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
        eventManager.notify(Events.POINT_CHANGE.toString(),this);

        }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        eventManager.notify(Events.RADIUS_CHANGE.toString(), this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.radius, radius) == 0 &&
                Objects.equals(center, sphere.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

    @Override
    public String toString() {
        return "SphereInterface{" +
                "center=" + center +
                ", radius=" + radius +
                '}';


    }
}
