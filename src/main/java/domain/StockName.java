package domain;

public enum StockName {
    A,
    B,
    C,
    D;

    public static StockName getStockName(String part) {
        StockName type = null;
        switch (part) {
            case "A":
                type = StockName.A;
                break;
            case "B":
                type = StockName.B;
                break;
            case "C":
                type = StockName.C;
                break;
            case "D":
                type = StockName.D;
                break;
        }
        return type;
    }
}
