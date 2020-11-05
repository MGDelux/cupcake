package domain.Order;

import java.sql.Timestamp;

/**
 * CREATED BY mathi @ 05-11-2020 - 10:14
 **/
public class GetOrders {
    String orderId;
    double orderPrice;
    Timestamp orderDate;

    public GetOrders(String orderId, double orderPrice, Timestamp orderDate) {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
}
