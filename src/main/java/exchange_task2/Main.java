package exchange_task2;

import exchange_task2.bank.actions.*;
import exchange_task2.bank.entity.Exchange;
import exchange_task2.customer.Customer;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Exchange exchange = Exchange.getExchange();
        exchange.setAmountBYN(100000);



        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Customer customer = new Customer(2000, 1000, 10000);
        Customer customer2 = new Customer(100, 200, 1000);
        Customer customer3 = new Customer(100, 100, 100);
        Customer customer4 = new Customer(1234, 4321, 15);

        Set<Operation> operationsForCustomer1 = new HashSet<>();
        Set<Operation> operationsForCustomer2 = new HashSet<>();
        Set<Operation> operationsForCustomer3 = new HashSet<>();
        Set<Operation> operationsForCustomer4 = new HashSet<>();
        //customer.run();
        //operationsForCustomer1.add(new BuyEuro(200));//для пользователя это продажа, для биржы покупка
        operationsForCustomer1.add(new BuyDollar(10));
        operationsForCustomer1.add(new SellEuro(1000));
        customer.setOperations(operationsForCustomer1);

        operationsForCustomer2.add(new SellDollar(110));
        customer2.setOperations(operationsForCustomer2);

        operationsForCustomer3.add(new  SellEuro(50));
        customer3.setOperations(operationsForCustomer3);

        operationsForCustomer4.add(new BuyEuro(1000));
        operationsForCustomer4.add(new BuyEuro(1000));
        customer4.setOperations(operationsForCustomer4);
        executorService.execute(customer);


        executorService.execute(customer2);
        executorService.execute(customer3);
        executorService.execute(customer4);


        // Operation sellDollarForCus2 = new BuyDollar(500);
        //operationsForCustomer2.add(sellDollarForCus2);


        //customer2.setOperations(operationsForCustomer2);
        //customer3.setOperations(operationsForCustomer3);
        //customer4.setOperations(operationsForCustomer4);

        //executorService.execute(customer2);
        TimeUnit.MICROSECONDS.sleep(2000);

        // executorService.execute(customer3);
        // executorService.execute(customer4);
        // exchange.getStates().remove(buyDollar);
        executorService.shutdown();

    }

}
