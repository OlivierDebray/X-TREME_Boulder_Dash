package controller;

        import contract.IUserOrder;

/**
 * Created by Vincent on 16/06/2017.
 */

public class UserOrder implements IUserOrder {
    private Order order ;

    public UserOrder (String order) {
        this.setOrder(order);
    }

    public void setOrder(String order) {
        switch (order) {
            case "UP":
                this.order = Order.UP ;
                break ;
            case "RIGHT":
                this.order = Order.RIGHT ;
                break ;
            case "DOWN":
                this.order = Order.DOWN ;
                break ;
            case "LEFT":
                this.order = Order.LEFT ;
                break ;
            case "A":
                this.order = Order.A ;
                break ;
            case "B":
                this.order = Order.B ;
                break ;
            case "START":
                this.order = Order.START ;
                break ;
            default :
                this.order = Order.NONE ;
                break ;
        }
    }

    public String getOrder(){
        return this.order.toString();
    }
}
