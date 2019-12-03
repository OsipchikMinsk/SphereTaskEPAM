package exchange_task2;

import exchange_task2.bank.actions.*;
import exchange_task2.bank.entity.Exchange;
import exchange_task2.customer.Customer;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Exchange exchange = Exchange.getINSTANCE();
        Operation buyDollar = new BuyDollar(0);
        Operation sellDollar = new SellDollar(0);
        Operation buyEuro = new BuyEuro(0);
        Operation sellEuro = new SellEuro(0);
        //опреации которые может совершать биржа
        exchange.getStates().add(buyDollar);
        exchange.getStates().add(sellDollar);
        exchange.getStates().add(buyEuro);
        exchange.getStates().add(sellEuro);


        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Customer customer = new Customer(2000, 1000, 10000);
        //Customer customer2 = new Customer(2000, 1000, 10000);
        //Customer customer3 = new Customer(2000, 1000, 10000);
        //Customer customer4 = new Customer(2000, 1000, 10000);

        Set<Operation> operationsForCustomer1 = new HashSet<>();
        //Set<Operation> operationsForCustomer2 = new HashSet<>();
        //Set<Operation> operationsForCustomer3 = new HashSet<>();
        //Set<Operation> operationsForCustomer4 = new HashSet<>();
        //customer.run();
        //operationsForCustomer1.add(new BuyEuro(200));//для пользователя это продажа, для биржы покупка
        operationsForCustomer1.add(new BuyDollar(10000));
       // operationsForCustomer1.add(new SellEuro(1000));
        customer.setOperations(operationsForCustomer1);
        executorService.execute(customer);


       // Operation sellDollarForCus2 = new BuyDollar(500);
        //operationsForCustomer2.add(sellDollarForCus2);


        //customer2.setOperations(operationsForCustomer2);
        //customer3.setOperations(operationsForCustomer3);
        //customer4.setOperations(operationsForCustomer4);

        //executorService.execute(customer2);
        Thread.sleep(1000);
       // executorService.execute(customer3);
       // executorService.execute(customer4);
       // exchange.getStates().remove(buyDollar);

    }

}
