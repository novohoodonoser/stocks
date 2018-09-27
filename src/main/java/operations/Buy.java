package operations;

import domain.Customer;
import domain.StockName;
import trade.Trade;

import java.util.Map;

public class Buy extends AbstractOperation implements Operation {

    public Buy(String customerName, StockName stockName, int price, int quantity) {
        super(customerName, stockName, price, quantity);
    }

    @Override
    public void apply(Map<String, Customer> customers) {
        customers.get(this.customerName).buy(order);
    }

    @Override
    public void addToQueue(Trade trade) {
        trade.buy(this);
    }
}
