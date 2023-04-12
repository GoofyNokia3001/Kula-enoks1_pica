package Pizzeria;


public class Order extends App {

    private Pizza pizza;
    private Customer customer;
    private double totalPrice;
    private boolean hasDelivery;
  
    public Order() {
        // Initialize all the instance variables to their default values
       pizza=null;
       customer=null;
       totalPrice=0;
       hasDelivery=false;

    }

    public Order(Pizza pizza, Customer customer, double totalPrice, boolean hasDelivery) {
        this.pizza = pizza;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.hasDelivery = hasDelivery;
        
    }

    // Getters
    public Pizza getPizza() {
        return pizza;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean getHasDelivery() {
        return hasDelivery;
    }

   

    // Setters
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setHasDelivery(boolean hasDelivery) {
        this.hasDelivery = hasDelivery;
    }
    
 
    public String orderInfo(boolean pizzaDelivery) {
        String deliveryOption = pizzaDelivery ? "Delivery" : "Pickup";
        StringBuilder sb = new StringBuilder();
        sb.append("_______________________\n\n");
        sb.append("Order Information:\n\n");
        sb.append(pizza.printPizzaInfo()).append("\n\n");
        sb.append("Customer Information:\n\n");
        sb.append(String.format("Name: %s\n", customer.getName()));
        if (pizzaDelivery) {
            sb.append(String.format("Delivery address: %s\n", customer.getAddress()));
            sb.append(String.format("Phone Number: %s\n", customer.getPhoneNumber()));
            sb.append(String.format("Email: %s\n", customer.getEmail()));
        }
        sb.append(String.format("\nTotal Price: $%.2f\n", totalPrice));
        sb.append(String.format("%s\n", "Delivery: "+deliveryOption));
        return sb.toString();
    }

    public static Order get(int last) {
        return null;
    }
    
    
    
    
 
    }

