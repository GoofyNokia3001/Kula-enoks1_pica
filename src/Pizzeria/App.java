package Pizzeria;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;


public class App {
    
  
    static int OrderChoose(ArrayList<Order> Order){
        String[] OrderList = new String[Order.size()] ;
    
        for(int i=0; i<OrderList.length; i++){
            OrderList[i] = (Order.get(i).getCustomer().getName() + " ");	
        }
        String index = (String)JOptionPane.showInputDialog(
                null, "What Order to interact?", "Choose an option", JOptionPane.QUESTION_MESSAGE, null, OrderList, OrderList[0]);
        return Arrays.asList(OrderList).indexOf(index);
        
    }
    
	public static double calculatePrice(int pizzaSize, boolean pizzaTopping, boolean pizzaSauce, boolean pizzaSides, boolean pizzaDrink, boolean pizzaDelivery) {
		
		double price = 0.0;
		
		switch (pizzaSize) {
			case 10:
				price += 5.99;
				break;
			case 12:
				price += 7.99;
				break;
			case 14:
				price += 9.99;
				break;
			case 16:
				price += 11.99;
				break;
			case 18:
				price += 13.99;
				break;
		}
		
		if (pizzaTopping) {
			price += 1.50;
		}
		if (pizzaSauce) {
			price += 0.50;
		}
		if (pizzaSides) {
			price += 2.99;
		}
		if (pizzaDrink) {
			price += 1.99;
		}
		if (pizzaDelivery) {
			price += 3.99;
		}
		
		return price;
		
	}
	
	public static boolean correctNumber(String customerNumber) {
		
		if (customerNumber.matches("\\+371[0-9]{8}")) {
			return true;
		} else {
			//JOptionPane.showMessageDialog(null, "Invalid phone number!");
			return false;
		}
		
	}
	
	public static boolean correctEmail(String customerEmail) {
		
		if (customerEmail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
			return true;
		} else {
			//JOptionPane.showMessageDialog(null, "Invalid email address!");
			return false;
		}
		
	}
	
	public static boolean correctAddress(String address) {
		
		if (address == null || address.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter a valid address", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(!address.matches("[a-zA-Z0-9 ]+ \\d+")){return false;}
		return true;
		
	}

    public static void saveOrder(Order order, boolean pizzaDelivery) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order.txt", false))) {
            writer.write("\n__________________________\n"+order.orderInfo(pizzaDelivery)+"\n__________________________\n");

            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void clearCheck(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("order.txt"))) {
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
        
	
	public static void main(String[] args) throws IOException {
        new MainFrame();
       
            }
        }                