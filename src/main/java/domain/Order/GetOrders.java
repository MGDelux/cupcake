package domain.Order;

import java.sql.Timestamp;

/**
 * CREATED BY mathi @ 05-11-2020 - 10:14
 **/
public class GetOrders {
    String orderId;
    int userId;
    double orderPrice;
    Timestamp orderDate;

    public GetOrders(String orderId, int userId, double orderPrice, Timestamp orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}
