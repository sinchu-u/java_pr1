import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory(){
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders); // Повертаємо копію списку, щоб запобігти змінам ззовні
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order: orders) {
            sb.append(order.toString()).append("\n");
        }
        return sb.toString();
    }
}
