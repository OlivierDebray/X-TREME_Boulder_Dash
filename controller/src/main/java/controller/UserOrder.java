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
<<<<<<< HEAD
<<<<<<< HEAD
     * Builder of UserOrder
=======
     * Instantiate a new UserOrder object whose order is the one in parameter
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
     * Instantiate a new UserOrder object whose order is the one in parameter
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
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
            default :
                this.order = Order.NONE ;
                break ;
        }
    }

    /**
<<<<<<< HEAD
<<<<<<< HEAD
     * This method allows return the order.toString
     * @return order.toString()
=======
     * Get the order of the instance
     * @return the order and cast it into a string
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
=======
     * Get the order of the instance
     * @return the order and cast it into a string
>>>>>>> dcd48c502207a0c23f7451bd1709f658a80f2d4b
     */
    public String getOrder(){
        return this.order.toString();
    }
}
