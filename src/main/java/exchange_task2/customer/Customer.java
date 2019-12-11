package exchange_task2.customer;

import exchange_task2.bank.actions.*;
import exchange_task2.bank.entity.Exchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Runnable {
    private double amountUSD;
    private double amountEUR;
    private double amountBYN;
    Set<Operation> operations = new HashSet<>();
    private Exchange exchange = Exchange.getExchange();
    private static final Logger LOGGER = LogManager.getLogger(Customer.class);

    public Customer(double amountUSD, double amountEUR, double amountBYN) {
        this.amountUSD = amountUSD;
        this.amountEUR = amountEUR;
        this.amountBYN = amountBYN;

    }

    @Override
    public void run() {
        System.out.println("Before $ " + amountUSD + " EUR " + amountEUR + " BUN " + amountBYN);
        operations.forEach(operation -> {
            System.out.println(Thread.currentThread().getName() + "=> " + operation.getClass() + " ");
            if (mayCustomerSellingDollar(operation)) {// isMay?
                Exchange.processOperation(operation);
                updateCustomerAfterSellingDollar(operation);
                LOGGER.info("Пользователь сдал " + operation.getValueOfOperation() + "$");
                System.out.println("after $ " + amountUSD + " EUR " + amountEUR + " BUN " + amountBYN);
            } /*else {
                LOGGER.info("Пользователь хочет сдать " + operation.getValueOfOperation() +
                        "$ но у него имеется только " + getAmountUSD());
                LOGGER.error("Пользователь хочет сдать долларов больше, чем у него есть");
                //todo как отсюда выйти?
            }*/
            if(mayCustomerSellingEuro(operation)){
                Exchange.processOperation(operation);
                updateCustomerAfterSellingEuro(operation);
                LOGGER.info("Пользователь сдал " + operation.getValueOfOperation() + " EUR");
                System.out.println("after $ " + amountUSD + " EUR " + amountEUR + " BUN " + amountBYN);
            } /*else {
                LOGGER.info("Пользователь хочет сдать " + operation.getValueOfOperation() +
                        " EUR но у него имеется только " + getAmountEUR() + "EUR");
                LOGGER.error("Пользователь хочет сдать евро больше, чем у него есть");
                //todo add exit
            }*/
            if(mayCustomerBuyingDollar(operation)){
                Exchange.processOperation(operation);
                updateCustomerAfterBuyingDollar(operation);
                LOGGER.info("Пользователь купил " + operation.getValueOfOperation()+ " $");
                System.out.println("after $ " + amountUSD + " EUR " + amountEUR + " BUN " + amountBYN);
            } /*else {
                LOGGER.info("Пользователь хочет купить " + operation.getValueOfOperation() + "$ но у него " +
                        "не достаточно беларуских денег");
                LOGGER.error("Пользователь хочеть купить доллары, но у него не достаточно беларуских денег");
                // todo exit
            }*/
            if (mayCustomerBuyingEuro(operation)){
                Exchange.processOperation(operation);
                updateCustomerAfterBuyingEuro(operation);
                LOGGER.info("Пльзователь купил " + operation.getValueOfOperation()+ " EUR");
                System.out.println("after $ " + amountUSD + " EUR " + amountEUR + " BUN " + amountBYN);
            }/*else {
                LOGGER.info("Пользователь хочет купить " + operation.getValueOfOperation()+ " EYR но у него не " +
                        "достаточно беларуских денег");
                //todo exit
            }*/

        });


    }
    public void updateCustomerAfterSellingDollar (Operation operation){
        setAmountUSD(getAmountUSD()-operation.getValueOfOperation());
        setAmountBYN(getAmountBYN()+(exchange.getBuyingRateUSD()*operation.getValueOfOperation()));
    }
    public void updateCustomerAfterSellingEuro (Operation operation){
        setAmountEUR(getAmountEUR()-operation.getValueOfOperation());
        setAmountBYN(getAmountBYN()+(exchange.getSellingRateEUR()*operation.getValueOfOperation()));
    }
    public void updateCustomerAfterBuyingDollar (Operation operation) {
        setAmountUSD(getAmountUSD() + operation.getValueOfOperation());
        setAmountBYN(getAmountBYN() - (exchange.getBuyingRateUSD() * operation.getValueOfOperation()));
    }
    public void updateCustomerAfterBuyingEuro (Operation operation){
        setAmountEUR(getAmountEUR()+operation.getValueOfOperation());
        setAmountBYN(getAmountBYN()-(exchange.getSellingRateEUR()*operation.getValueOfOperation()));
    }
    public boolean mayCustomerBuyingDollar (Operation operation){
        return operation.getClass()==SellDollar.class&&this.amountBYN>=
                operation.getValueOfOperation()*exchange.getBuyingRateUSD();
    }
    public boolean mayCustomerBuyingEuro (Operation operation){
        return operation.getClass()==SellEuro.class&&this.amountBYN>=
                operation.getValueOfOperation()*exchange.getBuyingRateUSD();
    }


    public boolean mayCustomerSellingDollar (Operation operation){
        return operation.getClass()==BuyDollar.class&&this.amountUSD>=operation.getValueOfOperation();
    }
    public boolean mayCustomerSellingEuro (Operation operation){
        return operation.getClass()==BuyEuro.class&&this.amountEUR>=operation.getValueOfOperation();
    }



    public double getAmountUSD() {
        return amountUSD;
    }

    public double getAmountEUR() {
        return amountEUR;
    }

    public double getAmountBYN() {
        return amountBYN;
    }

    public void setAmountUSD(double amountUSD) {
        this.amountUSD = amountUSD;
    }

    public void setAmountEUR(double amountEUR) {
        this.amountEUR = amountEUR;
    }

    public void setAmountBYN(double amountBYN) {
        this.amountBYN = amountBYN;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
