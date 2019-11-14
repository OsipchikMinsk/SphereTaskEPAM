package by.epam.sphere.logic;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.*;

public class SphereLogicTest {
    private Point point = new Point(5,5,5);
    private Sphere  sphere;
    private SphereLogic sphereLogic = new SphereLogic();
    @Before
    public void initSphere(){
       sphere = new Sphere(point,10);

    }


    @org.junit.Test
    public void isRadiusNumber() throws Exception {
        double actual = sphere.getRadius();
        double expected = 10;
        Assert.assertEquals(expected,actual,0);
    }

    @org.junit.Test
    public void calculateSphereArea() throws Exception {
        double actual = sphereLogic.calculateSphereArea(sphere);
        double expected = 1256;
        Assert.assertEquals(expected,actual,0);
    }

    @org.junit.Test
    public void calcSphereVolume() throws Exception {
        double actual = sphereLogic.calcSphereVolume(sphere);
        double expected = 3140;
        Assert.assertEquals(expected,actual,0);
    }

    @org.junit.Test
    public void isSphere() throws Exception {
        boolean actual = sphereLogic.isSphere(sphere);
        Assert.assertTrue(actual);
    }

    @org.junit.Test
    public void isSphereCrossesAxis() throws Exception {
        boolean actual = sphereLogic.isSphereCrossesAxis(sphere);
        Assert.assertTrue( actual);
    }

    @org.junit.Test
    public void calcVolumeRatio() throws Exception {
        double actual = sphereLogic.calcVolumeRatio(sphere);
        double expected = 3;
        Assert.assertEquals(expected,actual,0);
    }



}