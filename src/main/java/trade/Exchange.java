package trade;

import operations.Buy;
import operations.Sell;

public interface Exchange {


    /**
     * add buy order to exchange
     * if someone already add sell operation to exchange, buys it
     * @param operation contains order to buy
     */
    void buy(Buy operation);

    /**
     * add sell order to exchange
     * if someone already add buy operation to exchange, sell it
     * @param operation contains order to buy
     */

    void sell(Sell operation);
}
