package trade;

import domain.Customer;
import domain.OrderQueue;
import operations.Buy;
import operations.Sell;

import java.util.Map;

public class TradeImpl implements Trade {

    private final Map<String, Customer> customers;
    private OrderQueue sellQueue = new OrderQueue();
    private OrderQueue buyQueue = new OrderQueue();

    public TradeImpl(Map<String, Customer> customers) {
        this.customers = customers;
    }

    @Override
    public void buy(Buy operation) {
        if (sellQueue.checkOrder(operation.getOrder())) {
            operation.apply(customers);
            sellQueue.pullOrder(operation.getOrder()).apply(customers);
        } else {
            buyQueue.addOrder(operation);
        }
    }

    @Override
    public void sell(Sell operation) {
        if (buyQueue.checkOrder(operation.getOrder())) {
            operation.apply(customers);
            buyQueue.pullOrder(operation.getOrder()).apply(customers);
        } else {
            sellQueue.addOrder(operation);
        }
    }
}
