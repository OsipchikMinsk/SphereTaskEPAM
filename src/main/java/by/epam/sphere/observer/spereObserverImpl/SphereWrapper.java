package by.epam.sphere.observer.spereObserverImpl;

import by.epam.sphere.entity.Figure;
import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.logic.SphereLogic;
import by.epam.sphere.observer.sphereObsevableImpl.EventManagerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SphereWrapper implements SphereWrapperInerface<EventManagerImpl.Events,Figure> {

    private Point center;
    private double areaOfSphere;
    private double volumeOfSphere;
    private boolean crossesAxis;
    private double coefficientVolumeRatio;
    private boolean isSphere;
    public static SphereLogic sphereLogic = SphereLogic.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(SphereWrapper.class);


    public SphereWrapper(Sphere sphere) {
        this.center = sphere.getCenter();
        this.areaOfSphere = sphereLogic.calculateSphereArea(sphere);
        this.volumeOfSphere = sphereLogic.calcSphereVolume(sphere);
        this.crossesAxis = sphereLogic.isSphereCrossesAxis(sphere);
        this.coefficientVolumeRatio = sphereLogic.calcVolumeRatio(sphere);
        this.isSphere = sphereLogic.isSphere(sphere);
    }

    public double getAreaOfSphere() {
        return areaOfSphere;
    }

    public double getVolumeOfSphere() {
        return volumeOfSphere;
    }

    @Override
    public void update(EventManagerImpl.Events eventType, Figure figure) {
        Sphere sphere = null;
        if (figure.getClass() == Sphere.class) {
            sphere = (Sphere) figure;
        }
        switch (eventType.toString()) {
            case ("POINT_CHANGE"):
                this.crossesAxis = sphereLogic.isSphereCrossesAxis(sphere);
                this.coefficientVolumeRatio = sphereLogic.calcVolumeRatio(sphere);
                LOGGER.info("Изменился центр у сферы " + sphere.toString());
                break;
            case ("RADIUS_CHANGE"):
                this.volumeOfSphere = sphereLogic.calcSphereVolume(sphere);
                this.areaOfSphere = sphereLogic.calculateSphereArea(sphere);
                this.isSphere = sphereLogic.isSphere(sphere);
                LOGGER.info("Изменился радиус у сферы " + sphere.toString());
                break;
        }
    }


}