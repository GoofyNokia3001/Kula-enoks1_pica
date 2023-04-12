package Pizzeria;


public class Pizza extends App {
	
	private String type;
	private int size;
	private int sliceNumber;
	private boolean topping;
	private String toppingType;
	private boolean sauce;
	private String sauceType;
	private boolean sides;
	private String sidesType;
	private boolean drink;
	private String drinkType;
	private double price;
	
    public Pizza() {
        // Initialize all the instance variables to their default values
        type = "";
        size = 0;
        sliceNumber = 0;
        topping = false;
        toppingType = "";
        sauce = false;
        sauceType = "";
        sides = false;
        sidesType = "";
        drink = false;
        drinkType = "";
        price = 0.0;
    }
    
    // Parameterized constructor
    public Pizza(String type, int size, int sliceNumber, boolean topping, 
            String toppingType, boolean sauce, String sauceType, boolean sides,
            String sidesType, boolean drink, String drinkType, double price){
        this.type = type;
        this.size = size;
        this.sliceNumber = sliceNumber;
        this.topping = topping;
        this.toppingType = toppingType;
        this.sauce = sauce;
        this.sauceType = sauceType;
        this.sides = sides;
        this.sidesType = sidesType;
        this.drink = drink;
        this.drinkType = drinkType;
        this.price = price;
    }
	
	 // Getters
    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getSliceNumber() {
        return sliceNumber;
    }

    public boolean hastopping() {
        return topping;
    }

    public String gettoppingType() {
        return toppingType;
    }

    public boolean hasSauce() {
        return sauce;
    }

    public String getSauceType() {
        return sauceType;
    }

    public boolean hasSides() {
        return sides;
    }

    public String getSidesType() {
        return sidesType;
    }

    public boolean hasDrink() {
        return drink;
    }

    public String getDrinkType() {
        return drinkType;
    }
    
    public double getPrice(){
    	return price;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSliceNumber(int sliceNumber) {
        this.sliceNumber = sliceNumber;
    }

    public void settopping(boolean topping) {
        this.topping = topping;
    }

    public void settoppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }

    public void setSauceType(String sauceType) {
        this.sauceType = sauceType;
    }

    public void setSides(boolean sides) {
        this.sides = sides;
    }

    public void setSidesType(String sidesType) {
        this.sidesType = sidesType;
    }

    public void setDrink(boolean drink) {
        this.drink = drink;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }
    
    public void setPrice(double price) {
    
        this.price = price;
    }
    
    
 
  public String printPizzaInfo() {
    String toppingTypeInfo = topping ? String.format("\nTopping Type: %s", toppingType) : "";
    String sauceTypeInfo = sauce ? String.format("\nSauce Type: %s", sauceType) : "";
    String sidesTypeInfo = sides ? String.format("\nSide Type: %s", sidesType) : "";
    String drinkTypeInfo = drink ? String.format("\nDrink Type: %s", drinkType) : "";
    String pizzaInfo = String.format("Pizza Information:\n\nType: %s\nSize: %d\nSlices: %d\nToppings: %s%s\nSauce: %s%s\nSides: %s%s\nDrink: %s%s",
    type, size, sliceNumber, topping ? "Yes" : "No", toppingTypeInfo, sauce ? "Yes" : "No", sauceTypeInfo, sides ? "Yes" : "No", sidesTypeInfo, drink ? "Yes" : "No", drinkTypeInfo);
    return pizzaInfo;
    }
    






}