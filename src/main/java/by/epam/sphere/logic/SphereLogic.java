package by.epam.sphere.logic;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.exception.NotSphereException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SphereLogic {



    public static final double PI = 3.14;
    public static final int COMMON_SPHERE_COEFFICIENT = 4;
    /*
    коэфициент ииспользуется при определении является ли данная фигура шаром
    получается путем нахождения объема шара и его площади
    коэфициент = радиус/(объем шара/площадь шара)
    */
    private static final SphereLogic INSTANCE = new SphereLogic();

    private static final Logger LOGGER = LogManager.getLogger(SphereLogic.class);

    public boolean isRadiusNumber(Sphere sphere) { //положительный ли радиус
        try {
           // logger.info("Check radius");
            if (sphere.getRadius() <= 0) {
            throw new NotSphereException("radius of sphere can't be <=0");
            }
        } catch (NotSphereException e) {
            e.printStackTrace();
            LOGGER.warn(e);
            return false;
        }
        return true;
    }

    public double calculateSphereArea(Sphere sphere) {  //считаем площадь сферы
        if (isRadiusNumber(sphere)){
            return (4*PI*Math.pow(sphere.getRadius(),2));
        }
        LOGGER.warn("ошибка при подсчете площади сферы");
        return 0;
    }

    public double calcSphereVolume(Sphere sphere) { //ситаем объем сферы
        if(isRadiusNumber(sphere)){
            return (4/3*PI*Math.pow(sphere.getRadius(),3));
        }
        LOGGER.warn("ошибка при подсчете объема сферы");
        return 0;
    }
   public boolean isSphere (Sphere sphere){
       double res = sphere.getRadius()/(calcSphereVolume(sphere)/calculateSphereArea(sphere))+0.1;
       double r = (int) res;
       return r==COMMON_SPHERE_COEFFICIENT;
   }

    public boolean isSphereCrossesAxis(Sphere sphere) { //проверка на персечение оси координат
        if (isRadiusNumber(sphere)) {
            double radius = sphere.getRadius();
            Point point = sphere.getCenter();
            return (Math.abs(point.getY()) - radius < 0) ||
                    (Math.abs(point.getX()) - radius < 0) ||
                    (Math.abs(point.getZ()) - radius < 0);
        }
        LOGGER.warn("радиус равен 0 или отрицательный");
        return false;
    }

    // соотношения объемов получаемых в результате рассечения шара координатной плоскостью;
    public double calcVolumeRatio(Sphere sphere) {
        if (isSphereCrossesAxis(sphere)) {
            Point point = sphere.getCenter();
            double radius = sphere.getRadius();
            double hX = Math.abs(point.getY()) - radius;
            double hY = Math.abs(point.getX()) - radius;
            double hZ = Math.abs(point.getZ()) - radius;
            if (hX < 0) {
                return calculateVolumeHemisphere(sphere, hX);
            }
            if (hY < 0) {
                return calculateVolumeHemisphere(sphere, hY);
            }
            if (hZ < 0) {
                return calculateVolumeHemisphere(sphere, hZ);
            }
        }
        LOGGER.info("Cфера не пересекает плоскость");
        return 0;
    }

    public double calculateVolumeHemisphere(Sphere sphere, double h) {
        double sphereVolume = calcSphereVolume(sphere);
        double radius = sphere.getRadius();
        h = Math.abs(h);
        double sphereVolumeHX = PI * Math.pow(h, 2) * (radius - 1 / 3 * h);//рассчет объема полусферы
        sphereVolume = sphereVolume - sphereVolumeHX; //рассчет объема второй полусферы
        return sphereVolume / sphereVolumeHX;
    }
    public static SphereLogic getInstance(){
        return INSTANCE;
    }



}









