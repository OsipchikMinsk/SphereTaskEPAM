package by.epam.sphere.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    static final Logger LOGGER = LogManager.getLogger(Parser.class.getName());

    public static List<Double> parseData(String input) {
        List<Double> resultData = new ArrayList<>();
        String[] data = input.split(" ");
        if (Validator.validateLineForCreatingSphere(input)) {
            for (String num : data) {
                try {
                    resultData.add(Double.valueOf(num));
                } catch (NumberFormatException e){
                    LOGGER.error("Ошибкаа при парсинге данных");
                }
            }
        }
        return resultData;
    }
}

