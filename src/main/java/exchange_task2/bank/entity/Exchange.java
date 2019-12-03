package exchange_task2.bank.entity;

import exchange_task2.bank.actions.Operation;
import exchange_task2.bank.actions.TimeOut;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Exchange {

    private static final Exchange INSTANCE = new Exchange();
    private static Lock lock = new ReentrantLock();
    private static Set<Operation> states = new HashSet<>();
    private static double amountUSD = 500;
    private static double amountEUR = 1000;
    private static double amountBYN = 10000;
    private static double sellingRateUSD = 2.1; //курс продажи
    private static double sellingRateEUR = 2.2;
    private static double buyingRateUSD = 2.05; //кур покупки
    private static double buyingRateEUR = 2.15;

    public static void processOperation(Operation operation) {
        lock.lock();
        if (!(operation.getClass()== TimeOut.class)){
            for (Operation availableOperation : states) {
                if (operation.getClass().equals(availableOperation.getClass())) {
                    operation.process();
                }
            }
        }
        System.out.println("USD LEFT: " + amountUSD);
        System.out.println("EUR LEFT: " + amountEUR) ;
        System.out.println("BYN LEFT: " + amountBYN);
        lock.unlock();

    }

    public static Exchange getINSTANCE() {
        return INSTANCE;
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

    public static Set<Operation> getStates() {
        return states;
    }

    public static void setStates(Set<Operation> states) {

        Exchange.states = states;
    }


}
