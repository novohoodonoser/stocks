package domain;

import operations.Buy;
import operations.Operation;
import operations.Sell;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class QueueTest {

    Operation sell;
    Operation buy;
    Order order1;
    Order order2;

    @Before
    public void setUp() {
        sell = new Sell("C1", StockName.A, 10, 5);
        buy = new Buy("C1", StockName.A, 10, 5);
        order1 = new Order(StockName.A, 10, 5);
        order2 = new Order(StockName.B, 50, 2);
    }

    @Test
    public void testEmptyQueue() {
        OrderQueue queue = new OrderQueue();
        assertFalse(queue.checkOrder(order1));
    }

    @Test
    public void testAddElementAndExistsQueue() {
        OrderQueue queue = new OrderQueue();
        queue.addOrder(sell);
        assertTrue(queue.checkOrder(order1));
    }

    @Test
    public void testDeleteDoubleElementsQueue() {

        OrderQueue queue = new OrderQueue();

        queue.addOrder(buy);
        queue.addOrder(buy);

        queue.pullOrder(order1);
        assertTrue(queue.checkOrder(order1));

        queue.pullOrder(order1);
        assertFalse(queue.checkOrder(order1));
    }

    @Test
    public void testDeleteDifferentElementsQueue() {

        OrderQueue queue = new OrderQueue();
        Operation sell = new Sell("C2", StockName.B, 50, 2);

        queue.addOrder(buy);
        queue.addOrder(sell);

        queue.pullOrder(order2);
        assertFalse(queue.checkOrder(order2));
        assertTrue(queue.checkOrder(order1));

        queue.pullOrder(order1);
        assertFalse(queue.checkOrder(order1));
    }
}
