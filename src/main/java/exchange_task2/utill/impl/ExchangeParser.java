package exchange_task2.utill.impl;

import exchange_task2.utill.IParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExchangeParser implements IParser<List<String>, String> {
    private static final Logger LOGGER = LogManager.getLogger(ExchangeParser.class);
    private final Pattern pattern = Pattern.compile("^(0|[1-9]\\d*)([.,]\\d+)? (0|[1-9]\\d*)([.,]\\d+)? " +
            "(0|[1-9]\\d*)([.,]\\d+)? (0|[1-9]\\d*)([.,]\\d+)? (0|[1-9]\\d*)([.,]\\d+)? (0|[1-9]\\d*)([.,]\\d+)?" +
            "(0|[1-9]\\d*)([.,]\\d+)?");  //паттерн на поиск только положительных чисел, можно и вещественных

    @Override
    public List<String> parse(String stringInput) {
        List<String> resultData = new ArrayList<>();
        Matcher matcher = pattern.matcher(stringInput);
        if (matcher.matches()){
            String splitter = " ";
            String [] dataForExchange = stringInput.split(splitter);
            resultData.addAll(Arrays.asList(dataForExchange));
        }else {
            LOGGER.warn("Не корректые данные в строке (" +stringInput+")" );
        }
        return resultData ;
    }
}
