import domain.Customer;
import domain.Order;
import domain.StockName;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestModel {

    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("C1", 1000, 130, 240, 760, 320);
    }

    @Test
    public void testCustomerFromString() {
        String line = "C1\t1000\t130\t240\t760\t320";
        Customer customer = new Customer(line.split("\t"));
        assertEquals("C1", customer.getName());
        assertEquals(1000, customer.getBalance());
        assertEquals(130, customer.getStocksMap().get(StockName.A).intValue());
        assertEquals(240, customer.getStocksMap().get(StockName.B).intValue());
        assertEquals(760, customer.getStocksMap().get(StockName.C).intValue());
        assertEquals(320, customer.getStocksMap().get(StockName.D).intValue());
    }

    @Test
    public void testBuy() {
        customer.buy(new Order(StockName.A, 100, 5));
        assertEquals(1000 - 100 * 5, customer.getBalance());
        assertEquals(130 + 5, customer.getStocksMap().get(StockName.A).intValue());
    }

    @Test
    public void testSell() {
        customer.sell(new Order(StockName.A, 100, 10));
        assertEquals(1000 + 100 * 10, customer.getBalance());
        assertEquals(130 - 10, customer.getStocksMap().get(StockName.A).intValue());

    }
}
