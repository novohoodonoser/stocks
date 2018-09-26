package operations;

import domain.Order;
import domain.StockName;


public abstract class AbstractOperation {

    protected final String customerName;
    protected final Order order;

    AbstractOperation(String customerName, StockName stockName, int price, int quantity) {
        this.customerName = customerName;
        order = new Order(stockName, price, quantity);
    }

    public Order getOrder() {
        return order;
    }
}
