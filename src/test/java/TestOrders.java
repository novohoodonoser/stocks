import domain.Customer;
import domain.StockName;
import operations.Buy;
import operations.Operation;
import operations.Sell;
import org.junit.Before;
import org.junit.Test;
import trade.Trade;
import trade.TradeImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestOrders {

    Map<String, Customer> customers = new HashMap<>();
    Buy buy;

    @Before
    public void setUp() {
        Customer customer1 = new Customer("C1", 1000, 100, 100, 100, 100);
        Customer customer2 = new Customer("C2", 1000, 100, 100, 100, 100);
        customers.put(customer1.getName(), customer1);
        customers.put(customer2.getName(), customer2);
        buy = new Buy("C1", StockName.A, 100, 5);
    }

    @Test
    public void testSuccessOrder() {
        Trade trade = new TradeImpl(customers);
        trade.buy(buy);
        trade.sell(new Sell("C2", StockName.A, 100, 5));
        assertEquals(1000 - 100 * 5, customers.get("C1").getBalance());
        assertEquals(1000 + 100 * 5, customers.get("C2").getBalance());
        assertEquals(100 + 5, customers.get("C1").getStocksMap().get(StockName.A).intValue());
        assertEquals(100 - 5, customers.get("C2").getStocksMap().get(StockName.A).intValue());
    }

    @Test
    public void testUnsuccessOrder() {
        Trade exchange = new TradeImpl(customers);
        exchange.buy(buy);
        exchange.sell(new Sell("C2", StockName.B, 100, 5));
        assertEquals(1000, customers.get("C1").getBalance());
        assertEquals(1000, customers.get("C2").getBalance());
        assertEquals(100, customers.get("C1").getStocksMap().get(StockName.A).intValue());
        assertEquals(100, customers.get("C2").getStocksMap().get(StockName.A).intValue());

    }
}
