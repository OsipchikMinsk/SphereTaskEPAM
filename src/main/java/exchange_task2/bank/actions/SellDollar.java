package exchange_task2.bank.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SellDollar implements Operation {
    private double sellAmountUSD;
    private static final Logger LOGGER = LogManager.getLogger(SellDollar.class);

    public SellDollar(double sellAmountUSD) {
        this.sellAmountUSD = sellAmountUSD;
    }

    @Override
    public void process() {
        if (exchange.getAmountUSD()>=sellAmountUSD){
            LOGGER.info("Биржа продала " + sellAmountUSD + " $");
            exchange.setAmountUSD(exchange.getAmountUSD() - sellAmountUSD);
            exchange.setAmountBYN(exchange.getAmountBYN()+(exchange.getSellingRateUSD()* sellAmountUSD));
        } else {
            LOGGER.error(" На бирже недостаточно долларов!!!");
        }
    }

    @Override
    public double getValueOfOperation() {
        return sellAmountUSD;
    }
}
