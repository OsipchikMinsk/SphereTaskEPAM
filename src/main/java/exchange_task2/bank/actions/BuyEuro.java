package exchange_task2.bank.actions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BuyEuro implements Operation {
    private double buyAmountEUR;
    private static final Logger LOGGER = LogManager.getLogger(BuyEuro.class);

    public BuyEuro(double buyAmountEUR) {
        this.buyAmountEUR = buyAmountEUR;
    }

    @Override
    public void process() {
        if (exchange.getAmountBYN()>=exchange.getSellingRateEUR()* buyAmountEUR){
            LOGGER.info("Биржа купила " + buyAmountEUR + " EUR");
            exchange.setAmountEUR(exchange.getAmountEUR() + buyAmountEUR);
            exchange.setAmountBYN(exchange.getAmountBYN()-(exchange.getSellingRateEUR()* buyAmountEUR));
        } else {
            LOGGER.error("На бирже недостаточно рублей!!!");
        }
    }

    @Override
    public double getValueOfOperation() {
        return buyAmountEUR;
    }
}
