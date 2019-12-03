package by.epam.sphere.util;

import by.epam.sphere.entity.Point;
import by.epam.sphere.entity.Sphere;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class SphereCreator {

    public static final int POSITION_OF_X = 0;
    public static final int POSITION_OF_y = 1;
    public static final int POSITION_OF_Z = 2;
    public static final int POSITION_OF_RADIUS = 3;
    public static final String DATA_PATH = "src\\main\\resources\\data.txt";
    static final Logger LOGGER = LogManager.getLogger(SphereCreator.class.getName());

    public Sphere createSphereFromFile (){
        File file = new File(DATA_PATH);
        UtilFileReader fileReader = new UtilFileReader(file);
        String dataFromFile = fileReader.readFirstLine();
        List<Double> dataForSphere = ParserDataForSphere.parseData(dataFromFile);
        double x = dataForSphere.get(POSITION_OF_X);
        double y = dataForSphere.get(POSITION_OF_y);
        double z = dataForSphere.get(POSITION_OF_Z);
        double radius = dataForSphere.get(POSITION_OF_RADIUS);
        Point point = new Point(x,y,z);
        Sphere sphere = new Sphere(point, radius);
        LOGGER.info("Сфера создана успешно");
        return sphere;

    }
}
