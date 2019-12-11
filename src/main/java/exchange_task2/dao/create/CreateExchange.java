package exchange_task2.dao.create;

import exchange_task2.bank.entity.Exchange;
import exchange_task2.dao.FileDataReader;
import exchange_task2.exeption.DaoException;
import exchange_task2.utill.IParser;
import exchange_task2.utill.impl.ExchangeParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class CreateExchange {
    private final static Logger LOGGER = LogManager.getLogger(CreateExchange.class);
    private static CreateExchange instance;
    private static Lock lock = new ReentrantLock();
    public static final int POSITION_OF_AMOUNT_USD = 0;
    public static final int POSITION_OF_AMOUNT_EUR = 1;
    public static final int POSITION_OF_AMOUNT_BYN = 2;
    public static final int POSITION_OF_SELLING_RATE_USD = 3;
    public static final int POSITION_OF_SELLING_RATE_EUR = 4;
    public static final int POSITION_OF_BUYING_RATE_USD = 5;
    public static final int POSITION_OF_BUYING_RATE_EUR = 6;

    public CreateExchange() {
    }

    public static CreateExchange getInstance() {
        if (instance == null) {
            lock.lock();
            instance = new CreateExchange();
            lock.unlock();
        }
        return instance;
    }

    public Exchange createExchangeFromFile(File file) {
        Exchange exchange = Exchange.getExchange();
        List<String> dataForExchange = new ArrayList<>();
        try {
            FileDataReader fileDataReader = FileDataReader.getFileDataReader();
            dataForExchange = fileDataReader.getAllFile(file);
        } catch (DaoException e) {
            LOGGER.error(e.getMessage(), e);
        }
        IParser<List<String>, String> parser = new ExchangeParser();
        for (String s : dataForExchange) {
            List<String> resultList = parser.parse(s);
            double amountUSD = Double.parseDouble(resultList.get(POSITION_OF_AMOUNT_USD));
            double amountEUR = Double.valueOf(resultList.get(POSITION_OF_AMOUNT_EUR));
            double amountBYN = Double.valueOf(resultList.get(POSITION_OF_AMOUNT_BYN));
            double sellingRateUSD = Double.valueOf(resultList.get(POSITION_OF_SELLING_RATE_USD));
            double sellingRateEUR = Double.valueOf(resultList.get(POSITION_OF_SELLING_RATE_EUR));
            double buyingRateUSD = Double.valueOf(resultList.get(POSITION_OF_BUYING_RATE_USD));
            double buyingRateEUR = Double.valueOf(resultList.get(POSITION_OF_BUYING_RATE_EUR));
            exchange.setAmountBYN(amountBYN);
            exchange.setAmountUSD(amountUSD);
            exchange.setAmountEUR(amountEUR);
            exchange.setSellingRateEUR(sellingRateEUR);
            exchange.setBuyingRateUSD(sellingRateUSD);
            exchange.setBuyingRateEUR(buyingRateEUR);
            exchange.setBuyingRateUSD(buyingRateUSD);

        }
        return exchange;

    }

}
