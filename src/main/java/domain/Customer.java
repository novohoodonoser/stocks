package domain;

import utils.StockConstants;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private int balance = 0;
    private String name;
    private Map<StockName, Integer> stocksMap = new HashMap<>();

    public Customer(String name, int balance, int aQuantity, int bQuantity, int cQuantity, int dQuantity) {
        this.name = name;
        this.balance = balance;
        this.stocksMap.put(StockName.A, aQuantity);
        this.stocksMap.put(StockName.B, bQuantity);
        this.stocksMap.put(StockName.C, cQuantity);
        this.stocksMap.put(StockName.D, dQuantity);
    }

    public Customer(String[] s) {
        this(s[0], Integer.valueOf(s[1]), Integer.valueOf(s[2]), Integer.valueOf(s[3]), Integer.valueOf(s[4]), Integer.valueOf(s[5]));
    }


    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public Map<StockName, Integer> getStocksMap() {
        return stocksMap;
    }


    public void sell(Order order) {
        stocksMap.put(order.getStockName(), stocksMap.get(order.getStockName()) - order.getQuantity());
        this.balance += order.getQuantity() * order.getPrice();
    }

    public void buy(Order order) {
        stocksMap.put(order.getStockName(), stocksMap.get(order.getStockName()) + order.getQuantity());
        this.balance -= order.getQuantity() * order.getPrice();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + StockConstants.DELIMITER + balance + StockConstants.DELIMITER);
        for (StockName stockName : StockName.values()) {
            stringBuilder.append(stocksMap.get(stockName));
            stringBuilder.append(StockConstants.DELIMITER);
        }
        return stringBuilder.toString();
    }
}



