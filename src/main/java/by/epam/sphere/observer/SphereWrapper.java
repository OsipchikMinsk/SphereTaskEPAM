package by.epam.sphere.observer;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.logic.SphereLogic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SphereWrapper implements SphereInterface {

    private Sphere sphere;
    private Point center;
    private double areaOfSphere;
    private double volumeOfSphere;
    public static SphereLogic sphereLogic = SphereLogic.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(SphereLogic.class);


    public SphereWrapper(Sphere sphere) {
        this.center = sphere.getCenter();
        this.sphere = sphere;
        this.areaOfSphere = getAreaOfSphere();
        this.volumeOfSphere = getVolumeOfSphere();

    }

    public Sphere getSphere() {
        return sphere;
    }

    public double getAreaOfSphere() {
        return sphereLogic.calculateSphereArea(sphere);
    }

    public double getVolumeOfSphere() {
        return sphereLogic.calcSphereVolume(sphere);
    }

    @Override
    public void update(String eventType, Sphere sphere) {
         switch (eventType) {
                case ("POINT_CHANGE"):
                    System.out.println("Is sphere crosses axis " +sphereLogic.isSphereCrossesAxis(sphere));
                    System.out.println( "Coefficient volume ratio " + sphereLogic.calcVolumeRatio(sphere)); ;
                    LOGGER.info("Изменился центр у сферы " + sphere.toString());
                    break;
                case ("RADIUS_CHANGE"):
                    System.out.println("New Sphere Volume : " + this.volumeOfSphere);
                    System.out.println("New Sphere Area : " + sphereLogic.calculateSphereArea(sphere)); ;
                    System.out.println("Is this object sphere : " + sphereLogic.isSphere(sphere));
                    LOGGER.info("Изменился радиус у сферы " + sphere.toString());
                    break;

        }
    }

}
