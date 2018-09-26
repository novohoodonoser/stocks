package operations;

import domain.Customer;
import domain.Order;
import trade.Trade;

import java.util.Map;

public interface Operation {

    void apply (Map<String, Customer> customers);
    void addToQueue(Trade trade);
    Order getOrder();
}
