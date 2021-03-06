package controller;

        import contract.IUserOrder;

/**
 * @author Vincent Alayrac vincent.alayrac@viacesi.fr
 *         Made on 16/06/2017.
 */

public class UserOrder implements IUserOrder {
    private Order order ;

    /**
     * Instantiate a new UserOrder object whose order is the one in parameter
     * @param order
     */
    public UserOrder (String order) {
        this.setOrder(order);
    }

    /**
     * Set the order of the instance to an Order state
     * @param order
     * @see Order
     */
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
            case "START_RELEASED":
                this.order = Order.START_RELEASED ;
                break ;
            default :
                this.order = Order.NONE ;
                break ;
        }
    }

    /**
     * Get the order of the instance
     * @return the order and cast it into a string
     */
    public String getOrder(){
        return this.order.toString();
    }
}
