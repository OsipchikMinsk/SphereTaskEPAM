package by.epam.sphere.repository;

import by.epam.sphere.entity.Figure;
import by.epam.sphere.entity.Sphere;
import by.epam.sphere.observer.spereObserverImpl.SphereParameter;
import by.epam.sphere.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SphereRepository {
    public static final Logger LOGGER = LogManager.getLogger(SphereRepository.class);

    private List<Figure> sphereList;
    private Map<Integer, SphereParameter> sphereMap;

    public SphereRepository() {
        this.sphereList = new ArrayList<>();
        this.sphereMap = new HashMap<>();
    }
    public void addFigure (Figure figure){
        sphereList.add(figure);
        LOGGER.info("Добавлена фигура" + figure.toString());
        if(figure.getClass()== Sphere.class){
            Sphere sphere = (Sphere) figure;
            SphereParameter sphereWrapper = new SphereParameter(sphere);
            sphereMap.put(sphere.getId(),sphereWrapper);
       }
    }
    public void deleteFigure (Figure figure){
        sphereList.remove(figure);
        sphereMap.remove(figure.getId());
        LOGGER.info("Удалена фигура" + figure.toString());
      }

    public List<Figure> query(Specification specification) {
        List<Figure> resultQuery = new ArrayList<>();
        for (Figure figure : sphereList) {
            if (specification.specify(figure)) {
                resultQuery.add(figure);
            }
        }
        return resultQuery;
    }

    public List<Figure> getSphereList() {
        return sphereList;
    }



    public Map<Integer, SphereParameter> getSphereMap() {
        return sphereMap;
    }


}
