package operations;

import domain.Customer;
import domain.StockName;
import trade.Exchange;

import java.util.Map;

public class Sell extends AbstractOperation implements Operation {

    public Sell(String customerName, StockName stockName, int price, int quantity) {
        super(customerName, stockName, price, quantity);
    }

    @Override
    public void apply(Map<String, Customer> customers) {
        customers.get(this.customerName).sell(order);
    }

    @Override
    public void addToQueue(Exchange exchange) {
        exchange.sell(this);
    }

}
