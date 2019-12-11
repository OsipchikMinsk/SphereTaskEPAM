package exchange_task2.bank.entity;

import exchange_task2.bank.actions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exchange {
    private static  Exchange exchange;
    private static Lock lock = new ReentrantLock();
    private  Set<Operation> states = new HashSet<>();
    private  double amountUSD = 500;
    private  double amountEUR = 1000;
    private  double amountBYN = 10000;
    private  double sellingRateUSD = 2.1; //курс продажи
    private  double sellingRateEUR = 2.2;
    private  double buyingRateUSD = 2.05; //кур покупки
    private  double buyingRateEUR = 2.15;

    public static void processOperation(Operation operation) {
        lock.lock();
        if (!(operation.getClass() == TimeOut.class)) {
            for (Operation availableOperation : exchange.states) {
                if (operation.getClass().equals(availableOperation.getClass())) {
                    operation.process();
                }
            }
        }
        System.out.println("USD LEFT: " + exchange.getAmountUSD());
        System.out.println("EUR LEFT: " + exchange.getAmountEUR());
        System.out.println("BYN LEFT: " + exchange.getAmountBYN());
        lock.unlock();

    }

    public static Exchange getExchange() {
        lock.lock();
        if (exchange ==null){
            exchange = new Exchange();
            exchange.states.add(new BuyDollar(0));
            exchange.states.add(new BuyEuro(0));
            exchange.states.add(new SellDollar(0));
            exchange.states.add(new SellEuro(0));
        }
        lock.unlock();
        return exchange;
    }


    public double getAmountUSD() {
        return amountUSD;
    }

    public void setAmountUSD(double amountUSD) {
        this.amountUSD = amountUSD;
    }

    public double getAmountEUR() {
        return amountEUR;
    }

    public void setAmountEUR(double amountEUR) {
        this.amountEUR = amountEUR;
    }

    public double getAmountBYN() {
        return amountBYN;
    }

    public void setAmountBYN(double amountBYN) {
        this.amountBYN = amountBYN;
    }

    public double getSellingRateUSD() {
        return sellingRateUSD;
    }

    public void setSellingRateUSD(double sellingRateUSD) {
        this.sellingRateUSD = sellingRateUSD;
    }

    public double getSellingRateEUR() {
        return sellingRateEUR;
    }

    public void setSellingRateEUR(double sellingRateEUR) {
        this.sellingRateEUR = sellingRateEUR;
    }

    public double getBuyingRateUSD() {
        return buyingRateUSD;
    }

    public void setBuyingRateUSD(double buyingRateUSD) {
        this.buyingRateUSD = buyingRateUSD;
    }

    public double getBuyingRateEUR() {
        return buyingRateEUR;
    }

    public void setBuyingRateEUR(double buyingRateEUR) {
        this.buyingRateEUR = buyingRateEUR;
    }


    public void setStates(Set<Operation> states) {
        this.states = states;
    }

    public Set<Operation> getStates() {
        return states;
    }
}
