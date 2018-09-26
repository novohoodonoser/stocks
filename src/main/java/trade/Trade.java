package trade;

import operations.Buy;
import operations.Sell;

public interface Trade {

    void buy(Buy operation);
    void sell(Sell operation);
}
