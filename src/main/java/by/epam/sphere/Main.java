package by.epam.sphere;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.logic.SphereLogic;
import by.epam.sphere.util.SphereCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {

        Point p1 = new Point(100,0,0);
        SphereLogic sphereLogic = new SphereLogic();
        Sphere sphere= new Sphere(p1,20);
        //System.out.println(sphereLogic.isSphereCrossesAxis(sphere));
        System.out.println(sphereLogic.isSphere(sphere));
        System.out.println(sphereLogic.calcVolumeRatio(sphere));
        SphereCreator sphereCreator = new SphereCreator();
        sphereCreator.createSphereFromFile();
        System.out.println(sphereLogic.calcSphereVolume(sphere));
        System.out.println(sphereLogic.calculateSphereArea(sphere));
        LOGGER.info("Работа завершена");

        }
}
