package exchange_task2.bank.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SellEuro implements Operation {
    private double sellAmountEUR;
    private static final Logger LOGGER = LogManager.getLogger(SellEuro.class);

    public SellEuro(double sellAmountEUR) {
        this.sellAmountEUR = sellAmountEUR;
    }

    @Override
    public void process() {
        if (exchange.getAmountEUR() >= sellAmountEUR) {
            LOGGER.info("Биржа продала " + sellAmountEUR + " EUR");
            exchange.setAmountEUR(exchange.getAmountEUR() - sellAmountEUR);
            exchange.setAmountBYN(exchange.getAmountBYN() + (exchange.getSellingRateEUR() * sellAmountEUR));
        } else {
            LOGGER.error(" На бирже недостаточно евро!!!");
        }
    }

    @Override
    public double getValueOfOperation() {
        return sellAmountEUR;
    }
}