package controller;

        import contract.IUserOrder;

/**
 * @author VIncent Alayrac vincent.alayrac@viacesi.fr
 *         Made on 16/06/2017
 */

/**
 * This class allows to move the player
 */
public class UserOrder implements IUserOrder {

    /**
     * @see Order
     */
    private Order order ;

    /**
     * Builder of UserOrder
     * @param order
     */
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
                this.order = null ;
                break ;
        }
    }

    /**
     * This method allows return the order.toString
     * @return order.toString()
     */
    public String getOrder(){
        return this.order.toString();
    }
}
