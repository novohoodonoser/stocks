package operations;


import domain.StockName;
import utils.StockConstants;

public class OperationFactory {
    public Operation get(String input) {

        String[] s = input.split(StockConstants.DELIMITER);

        switch (s[1]) {
            case "s":
                return new Sell(s[0], StockName.getStockName(s[2]), Integer.valueOf(s[3]), Integer.valueOf(s[4]));
            case "b":
                return new Buy(s[0], StockName.getStockName(s[2]), Integer.valueOf(s[3]), Integer.valueOf(s[4]));
            default:
                throw new IllegalArgumentException();
        }
    }
}
