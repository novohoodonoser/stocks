package operations;

import domain.Customer;
import domain.Order;
import trade.Exchange;

import java.util.Map;

public interface Operation {


    /**
     * apply buy/sell operation with customer's actives
     * @param customers map of customer name to customer instance
     */
    void apply(Map<String, Customer> customers);

    /**
     * add operation to exchange
     * @param exchange instance of exchange where customer want buy/sell stock
     */
    void addToQueue(Exchange exchange);

    /**
     * get order of current operation
     * @return Order of current operation
     */
    Order getOrder();
}
