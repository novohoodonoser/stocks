package writers;

import domain.Customer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class CustomerWriter {

    public void writeToFile(String FileName, Map<String, Customer> customers) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(FileName)) {
            byte[] buffer = collectCustomers(customers).toString().getBytes();
            fos.write(buffer, 0, buffer.length);
        }
    }

    private StringBuffer collectCustomers(Map<String, Customer> customers) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, Customer> customer : customers.entrySet()) {
            stringBuffer.append(customer.getValue().toString());
            stringBuffer.append("\r\n");
        }
        return stringBuffer;
    }
}
