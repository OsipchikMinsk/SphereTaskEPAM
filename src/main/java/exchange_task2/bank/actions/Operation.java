package exchange_task2.bank.actions;

import exchange_task2.bank.entity.Exchange;

public interface Operation {

    Exchange exchange = Exchange.getExchange();
    void process ();
    double getValueOfOperation();
}
