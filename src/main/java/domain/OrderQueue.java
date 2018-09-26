package domain;

import operations.Operation;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class OrderQueue {
    private Map<Order, Queue<Operation>> ordersMap = new LinkedHashMap<>();

    public void addOrder(Operation operation) {
        Order order = operation.getOrder();
        if (checkOrder(order)) {
            Queue<Operation> list = ordersMap.get(order);
            list.add(operation);
        } else {
            Queue<Operation> list = new LinkedList<>();
            list.add(operation);
            ordersMap.put(order, list);
        }
    }

    public boolean checkOrder(Order order) {
        return ordersMap.containsKey(order);
    }

    public Operation pullOrder(Order order) {
        Queue<Operation> list = ordersMap.get(order);
        Operation result = list.remove();
        if (list.isEmpty()) {
            ordersMap.remove(order);
        }
        return result;
    }
}
