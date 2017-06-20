package controller;

        import contract.IUserOrder;

/**
 * Created by Vincent on 16/06/2017.
 */

public class UserOrder implements IUserOrder {
    private Order order ;

    public UserOrder (Order order) {
        this.order = order ;
    }

    public String getOrder(){
        return this.order.toString();
    }
}
