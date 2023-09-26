import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();
    
    public void saveOrder(Order order) {
        orders.add(order);
    }
    
    public List<Order> getAllOrders() {
        return orders;
    }
    
    public Order getOrderById(String orderId) {
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }
    
    public void updateOrder(Order updatedOrder) {
        Order existingOrder = getOrderById(updatedOrder.getId());
        if (existingOrder != null) {
            existingOrder.setName(updatedOrder.getName());
            existingOrder.setPrice(updatedOrder.getPrice());
        }
    }
    
    public void deleteOrder(String orderId) {
        Order orderToDelete = getOrderById(orderId);
        if (orderToDelete != null) {
            orders.remove(orderToDelete);
        }
    }
}