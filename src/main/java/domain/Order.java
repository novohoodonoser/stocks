package domain;


public class Order {
    private StockName stockName;
    private Integer price;
    private Integer quantity;

    public Order(StockName stockName, Integer price, Integer quantity) {
        this.stockName = stockName;
        this.price = price;
        this.quantity = quantity;
    }

    public StockName getStockName() {
        return stockName;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return new StringBuilder().
                append("stockName = ").append(stockName).
                append("price = ").append(price).
                append("quantity = ").append(quantity).
                toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        if (price != order.price) return false;
        if (quantity != order.quantity) return false;
        return stockName == order.stockName;
    }

    @Override
    public int hashCode() {
        int result = stockName.hashCode();
        result = 31 * result + price;
        result = 31 * result + quantity;
        return result;
    }
}
