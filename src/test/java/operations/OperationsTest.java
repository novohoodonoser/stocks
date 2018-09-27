package operations;

import domain.Customer;
import domain.StockName;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class OperationsTest {
    Map<String, Customer> customers = new HashMap<>();
    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("C1", 1000, 130, 240, 760, 320);
        customers.put(customer.getName(), customer);
    }

    @Test
    public void testBuyOperation() {
        Operation buy = new Buy("C1", StockName.A, 10, 5);
        buy.apply(customers);
        assertEquals(1000 - 10 * 5, customer.getBalance());
        assertEquals(130 + 5, customer.getStocksMap().get(StockName.A).intValue());
    }

    @Test
    public void testSellOperation() {
        Operation sell = new Sell("C1", StockName.A, 10, 5);
        sell.apply(customers);
        assertEquals(1000 + 10 * 5, customer.getBalance());
        assertEquals(130 - 5, customer.getStocksMap().get(StockName.A).intValue());
    }
}
