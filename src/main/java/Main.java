import domain.Customer;
import readers.CustomerReader;
import readers.OrderReader;
import trade.Trade;
import trade.TradeImpl;
import utils.PropertiesUtils;
import writers.CustomerWriter;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

class Main {

    public static void main(String[] args) throws IOException {
        Properties properties = PropertiesUtils.readProperties(Constants.CONFIG_PATH);
        Map<String, Customer> customersList = new CustomerReader(properties.getProperty(Constants.FILE_PATH) + properties.getProperty(Constants.CLIENT_FILE_NAME)).read();
        OrderReader ordersFromFile = new OrderReader(properties.getProperty(Constants.FILE_PATH) + properties.getProperty(Constants.ORDER_FILE_NAME));
        Trade trade = new TradeImpl(customersList);
        ordersFromFile.read(trade);
        new CustomerWriter().writeToFile(properties.getProperty(Constants.FILE_PATH) + properties.getProperty(Constants.TARGET_FILE_NAME), customersList);
    }
}