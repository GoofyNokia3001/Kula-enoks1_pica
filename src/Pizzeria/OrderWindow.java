package Pizzeria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OrderWindow extends JFrame implements ActionListener {

  JButton button;
  JButton button1;
  JFrame newPizzaFrame = new JFrame("Pizza Order");
  JFrame newCustomerFrame = new JFrame("Customer Info");
  JLabel nameLabel = new JLabel();
  JLabel phoneLabel = new JLabel();
  JLabel addressLabel = new JLabel();
  JLabel emailLabel = new JLabel("Email:");

  String[] type = {
    "Cheese Pizza",
    "Veggie Pizza",
    "Pepperoni Pizza",
    "Margherita Pizza",
    "BBQ Chicken Pizza",
    "Hawaiian Pizza",
    "Buffalo Pizza",
    "Supreme Pizza",
  };
  Integer[] size = { 10, 12, 14, 16, 18 };
  Integer[] sliceNumber = { 4, 6, 8, 10 };
  String[] toppingType = {
    "Cheese",
    "Mushrooms",
    "Pineapples",
    "Double Pepperoni",
    "Garlic",
    "Tomato",
    "Onions",
    "Chicken",
    "No",
  };
  String[] sauceType = {
    "Soy Sauce",
    "Hot Sauce",
    "Majo",
    "Tomato Sauce",
    "No",
  };
  String[] sidesType = {
    "Fri",
    "Croquette",
    "Caesar salad",
    "Garlic Bread",
    "No",
  };
  String[] drinkType = {
    "Coca-Cola",
    "Sprite",
    "Fanta",
    "Multifruit Juice",
    "Apple Juice",
    "Tomato Juice",
    "No",
  };
  String[] delivery = { "Yes", "No" };
  String deliveryString;
  String pizzaType = "";
  int pizzaSize = 0;
  int pizzaSlices = 0;
  boolean pizzaTopping = true;
  String pizzaToppingType = "";
  boolean pizzaSauce = true;
  String pizzaSauceType = "";
  boolean pizzaSides = true;
  String pizzaSidesType = "";
  boolean pizzaDrink = true;
  String pizzaDrinkType = "";
  String customerName = "";
  String customerPhone = "";
  String customerAddress = "";
  String customerEmail = "";
  Pizza pizza = new Pizza();
  Customer customer = new Customer();
  Order order = new Order();
  static boolean pizzaDelivery = false;
  static int last = 0;

  JComboBox<String> pizzaComboBox;
  JComboBox<Integer> sizeComboBox;
  JComboBox<Integer> sliceComboBox;
  JComboBox<String> toppingComboBox;
  JComboBox<String> sauceComboBox;
  JComboBox<String> sidesComboBox;
  JComboBox<String> drinkComboBox;
  JComboBox<String> deliveryComboBox;
  JTextField nameField;
  JTextField phoneField;
  JTextField addressField;
  JTextField emailField;
  //JLabel icon = MainFrame.icon;

  OrderWindow() {
    newPizzaFrame = new JFrame("Pizza Order");
    newPizzaFrame.setSize(420, 600);
    newPizzaFrame.setLayout(null);
    JLabel typeLabel = new JLabel("Type:");
    typeLabel.setBounds(50, 50, 100, 30);
    newPizzaFrame.add(typeLabel);
    // Create and add the pizza combo box
    pizzaComboBox = new JComboBox<>(type);
    pizzaComboBox.setBounds(160, 50, 100, 30);
    newPizzaFrame.add(pizzaComboBox);
    

    // Create and add the size combo box and label
    JLabel sizeLabel = new JLabel("Size:");
    sizeLabel.setBounds(50, 100, 100, 30);
    newPizzaFrame.add(sizeLabel);

    sizeComboBox = new JComboBox<>(size);
    sizeComboBox.setBounds(160, 100, 100, 30);
    newPizzaFrame.add(sizeComboBox);

    // Create and add the slice number combo box and label
    JLabel sliceLabel = new JLabel("Slice Number:");
    sliceLabel.setBounds(50, 150, 100, 30);
    newPizzaFrame.add(sliceLabel);

    sliceComboBox = new JComboBox<>(sliceNumber);
    sliceComboBox.setBounds(160, 150, 100, 30);
    newPizzaFrame.add(sliceComboBox);

    // Create and add the topping combo box and label
    JLabel toppingLabel = new JLabel("Topping Type:");
    toppingLabel.setBounds(50, 200, 100, 30);
    newPizzaFrame.add(toppingLabel);

    toppingComboBox = new JComboBox<>(toppingType);
    toppingComboBox.setBounds(160, 200, 100, 30);
    newPizzaFrame.add(toppingComboBox);

    // Create and add the sauce combo box and label
    JLabel sauceLabel = new JLabel("Sauce Type:");
    sauceLabel.setBounds(50, 250, 100, 30);
    newPizzaFrame.add(sauceLabel);

    sauceComboBox = new JComboBox<>(sauceType);
    sauceComboBox.setBounds(160, 250, 100, 30);
    newPizzaFrame.add(sauceComboBox);

    // Create and add the sides combo box and label
    JLabel sidesLabel = new JLabel("Sides Type:");
    sidesLabel.setBounds(50, 300, 100, 30);
    newPizzaFrame.add(sidesLabel);

    sidesComboBox = new JComboBox<>(sidesType);
    sidesComboBox.setBounds(160, 300, 100, 30);
    newPizzaFrame.add(sidesComboBox);

    // Create and add the drink combo box and label
    JLabel drinkLabel = new JLabel("Drink Type:");
    drinkLabel.setBounds(50, 350, 100, 30);
    newPizzaFrame.add(drinkLabel);

    drinkComboBox = new JComboBox<>(drinkType);
    drinkComboBox.setBounds(160, 350, 100, 30);
    newPizzaFrame.add(drinkComboBox);

    JLabel deliveryLabel = new JLabel("Delivery:");
    deliveryLabel.setBounds(50, 400, 100, 30);
    newPizzaFrame.add(deliveryLabel);

    deliveryComboBox = new JComboBox<>(delivery);
    deliveryComboBox.setBounds(160, 400, 100, 30);
    newPizzaFrame.add(deliveryComboBox);
    // Create and add the submit button
    button = new JButton("Submit");
    button.setBounds(130, 450, 120, 30);
    newPizzaFrame.add(button);

    newPizzaFrame.setVisible(true);
    button.addActionListener(this);

    //newCustomerFrame
    button1 = new JButton("Submit");
    button1.setBounds(130, 450, 120, 30);
    button1.addActionListener(this);

    nameLabel = new JLabel("Name:");
    nameLabel.setBounds(50, 100, 150, 30);

    nameField = new JTextField(1);
    nameField.setBounds(230, 100, 100, 30);

    phoneLabel = new JLabel("Phone num:");
    phoneLabel.setBounds(50, 150, 150, 30);

    phoneField = new JTextField(1);
    phoneField.setBounds(230, 150, 100, 30);

    addressLabel = new JLabel("Address (delivery):");
    addressLabel.setBounds(50, 200, 150, 30);

    addressField = new JTextField(1);
    addressField.setBounds(230, 200, 100, 30);

    emailLabel = new JLabel("Email:");
    emailLabel.setBounds(50, 250, 150, 30);

    emailField = new JTextField(1);
    emailField.setBounds(230, 250, 100, 30);


    //Background
    //newPizzaFrame.add(icon);
    //icon.setBounds(0, 0, 1920, 1080);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {
      // Get the selected pizza type from the combo box
      pizzaType = (String) pizzaComboBox.getSelectedItem();
      // Get the selected pizza size from the combo box
      pizzaSize = (Integer) sizeComboBox.getSelectedItem();
     
      
      pizzaSlices = (Integer) sliceComboBox.getSelectedItem();
      
      
      pizzaToppingType = (String) toppingComboBox.getSelectedItem();
      pizzaSauceType = (String) sauceComboBox.getSelectedItem();
      pizzaSidesType = (String) sidesComboBox.getSelectedItem();
      pizzaDrinkType = (String) drinkComboBox.getSelectedItem();
      deliveryString = (String) deliveryComboBox.getSelectedItem();
      if (pizzaToppingType == toppingType[toppingType.length - 1]) {
        pizzaTopping = false;
      } else {
        pizzaTopping = true;
      }
      if (pizzaSauceType == sauceType[sauceType.length - 1]) {
        pizzaSauce = false;
      } else {
        pizzaSauce = true;
      }
      if (pizzaSidesType == sidesType[sidesType.length - 1]) {
        pizzaSides = false;
      } else {
        pizzaSides = true;
      }
      if (pizzaDrinkType == drinkType[drinkType.length - 1]) {
        pizzaDrink = false;
      } else {
        pizzaDrink = true;
      }
      if (deliveryString == delivery[delivery.length - 1]) {
        pizzaDelivery = false;
      } else {
        pizzaDelivery = true;
      }

      double price;
      price =
        App.calculatePrice(
          pizzaSize,
          pizzaTopping,
          pizzaSauce,
          pizzaSides,
          pizzaDrink,
          pizzaDelivery
        );
      pizza =
        new Pizza(
          pizzaType,
          pizzaSize,
          pizzaSlices,
          pizzaTopping,
          pizzaToppingType,
          pizzaSauce,
          pizzaSauceType,
          pizzaSides,
          pizzaSidesType,
          pizzaDrink,
          pizzaDrinkType,
          price
        );

      newPizzaFrame.dispose();

      newCustomerFrame.setVisible(true);
      newCustomerFrame.setSize(420, 600);
      newCustomerFrame.setLayout(null);

      if (pizzaDelivery) {
       
        newCustomerFrame.add(button1);

        newCustomerFrame.add(nameLabel);
        newCustomerFrame.add(nameField);
        newCustomerFrame.add(phoneLabel);
        newCustomerFrame.add(phoneField);

        newCustomerFrame.add(addressLabel);
        newCustomerFrame.add(addressField);

        newCustomerFrame.add(emailLabel);
        newCustomerFrame.add(emailField);
       
      } else {
        
        newCustomerFrame.add(button1);

        newCustomerFrame.add(nameLabel);
        newCustomerFrame.add(nameField);
       
      }
    }

    if (e.getSource() == button1) {
      if (pizzaDelivery == true) {
        customerName = (String) nameField.getText();

        if (customerName.length() < 3) {
          newCustomerFrame.dispose();

          newCustomerFrame.setVisible(true);
        } else {
          customerName = (String) nameField.getText();
          customerPhone = (String) phoneField.getText();
          customerAddress = (String) addressField.getText();
          customerEmail = (String) emailField.getText();

          if (
            App.correctNumber(customerPhone) &&
            App.correctAddress(customerAddress) &&
            App.correctEmail(customerEmail)
          ) {
            newCustomerFrame.dispose();
          } else {
            JOptionPane.showMessageDialog(
              null,
              "Contact information Error: Check Phone, Address, Email"
            );
            newCustomerFrame.setVisible(true);
          }
        }
      } else if (pizzaDelivery == false) {
        newCustomerFrame.remove(phoneLabel);
        newCustomerFrame.remove(phoneField);
        newCustomerFrame.remove(addressLabel);
        newCustomerFrame.remove(addressField);
        newCustomerFrame.remove(emailLabel);
        newCustomerFrame.remove(emailField);
        customerName = (String) nameField.getText();
        if (customerName.length() < 3) {
          newCustomerFrame.dispose();

          newCustomerFrame.setVisible(true);
        }

        if (customerName.length() >= 3) {
          newCustomerFrame.dispose();
        }
      }
    }
    if (e.getSource() == button && customerName.length() >= 3) {
      newCustomerFrame.dispose();
    }

    customer =
      new Customer(customerName, customerAddress, customerPhone, customerEmail);
    order =
      new Order(
        pizza,
        customer,
        App.calculatePrice(
          pizzaSize,
          pizzaTopping,
          pizzaSauce,
          pizzaSides,
          pizzaDrink,
          pizzaDelivery
        ),
        pizzaDelivery
      );

    if (e.getSource() == button1) {
        if(customerName.length()>=3){
      if (pizzaDelivery) {
        if (
          App.correctNumber(customerPhone) &&
          App.correctAddress(customerAddress) &&
          App.correctEmail(customerEmail)
        ) {
          MainFrame.Order.add(order);
          App.saveOrder(order,  pizzaDelivery);
                           
        }
      } else {
        MainFrame.Order.add(order);
        App.saveOrder(order, pizzaDelivery);
                           
      }}
      
    }
  }
}
