package by.epam.sphere.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validator {


    static final Logger LOGGER = LogManager.getLogger(Validator.class.getName());

    public static boolean validateLineForCreatingSphere(String input) {
        String[] data = input.split(" ");
        if (data == null || data.length != 4) {
            LOGGER.error("Некоректые строка при валидации");
            return false;
        }
        double radius= Double.parseDouble(data[3]);
        if (radius<0){
            LOGGER.error("Отрицательный радиус или равен 0");
        }
        return radius>0;
    }



}


