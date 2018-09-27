import domain.Customer;
import readers.CustomerReader;
import readers.OrderReader;
import trade.Trade;
import trade.TradeImpl;
import utils.PropertiesUtils;
import utils.StockConstants;
import writers.CustomerWriter;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

class Main {

    public static void main(String[] args) throws IOException {
        Properties properties = PropertiesUtils.readProperties(StockConstants.CONFIG_PATH);
        Map<String, Customer> customersList = new CustomerReader(properties.getProperty(StockConstants.FILE_PATH) + properties.getProperty(StockConstants.CLIENT_FILE_NAME)).read();
        OrderReader ordersFromFile = new OrderReader(properties.getProperty(StockConstants.FILE_PATH) + properties.getProperty(StockConstants.ORDER_FILE_NAME));
        Trade trade = new TradeImpl(customersList);
        ordersFromFile.read(trade);
        new CustomerWriter().writeToFile(properties.getProperty(StockConstants.FILE_PATH) + properties.getProperty(StockConstants.TARGET_FILE_NAME), customersList);
    }
}