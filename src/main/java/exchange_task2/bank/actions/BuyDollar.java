package exchange_task2.bank.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class BuyDollar implements Operation { //покупка доллара биржей

    private double buyAmountUSD;
    private static final Logger LOGGER = LogManager.getLogger(BuyDollar.class);

    @Override
    public void process() {
        if (exchange.getAmountBYN()>=exchange.getSellingRateUSD()* buyAmountUSD){
            LOGGER.info("Биржа купила " + buyAmountUSD + " $");
            exchange.setAmountUSD(exchange.getAmountUSD() + buyAmountUSD);
            exchange.setAmountBYN(exchange.getAmountBYN()-(exchange.getSellingRateUSD()* buyAmountUSD));
        } else {
            LOGGER.error("На бирже недостаточно рублей!!!");
        }
    }

    @Override
    public double getValueOfOperation() {
        return buyAmountUSD;
    }

    public BuyDollar(double buyAmountUSD) {
        this.buyAmountUSD = buyAmountUSD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyDollar buyDollar = (BuyDollar) o;
        return Double.compare(buyDollar.buyAmountUSD, buyAmountUSD) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyAmountUSD);
    }
}