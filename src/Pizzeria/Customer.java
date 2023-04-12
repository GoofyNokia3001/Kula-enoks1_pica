package Pizzeria;




public class Customer extends App {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Customer() {
        // Initialize all the instance variables to their default values
       name="";
       address="";
        phoneNumber="";
        email="";

    }

    public Customer(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String printCustomerInfo(boolean pizzaDelivery) {
        
        String message = "Customer Information:\n\n";
        if(pizzaDelivery){
            message+="Name: " + getName() + "\n" +
                         "Delivery address: " + getAddress() + "\n" +
                         "Phone number: " + getPhoneNumber() + "\n" +
                         "Email: " + getEmail();
        } else{
            message+="Name: " + getName() + "\n";
        }
        
       return message;
    }
    
   

}
