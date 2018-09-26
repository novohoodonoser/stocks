package readers;

import domain.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CustomerReader {

    private final String customersFileName;

    public CustomerReader(String customersFileName) {
        this.customersFileName = customersFileName;
    }

    public Map<String, Customer> read() throws IOException {
        Map<String, Customer> customers = new HashMap<>();
        try (Stream<String> stream = Files.lines(Paths.get(customersFileName))) {
            stream.forEach(data -> {
                String[] parsedData = data.split("\t");
                customers.put(parsedData[0], new Customer(parsedData[0], Integer.valueOf(parsedData[1]), Integer.valueOf(parsedData[2]),
                        Integer.valueOf(parsedData[3]), Integer.valueOf(parsedData[4]), Integer.valueOf(parsedData[5])));
            });
        }
        return customers;
    }
}
