package readers;

import trade.Exchange;
import operations.OperationFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class OrderReader {

    private OperationFactory operationFactory = new OperationFactory();
    private final String ordersFileName;

    public OrderReader(String fileName) {
        ordersFileName = fileName;
    }

    public void read(Exchange exchange) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(ordersFileName))) {
            stream.forEach(data -> operationFactory.get(data).addToQueue(exchange));
        }
    }
}
