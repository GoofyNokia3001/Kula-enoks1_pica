package Pizzeria;


import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener {

  public static void music(boolean hasPlayed)
    throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    File file = new File("C:\\Users\\2PT-2\\Kulacenoks_eclipse\\Kulacenoks_pica\\Kulacenoks_pica\\src\\Pizzeria\\Breaking Bad Main Theme Extended Version.wav");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();
    clip.open(audioStream);

    // Check the flag before playing the audio
    if (hasPlayed) {
      clip.start();
    }
  }


  JMenuBar menuBar;
  JMenu fileMenu;
  JButton New;
  JButton List;
  JButton Last;
  JButton Delete;
  JButton Check;
  JButton Exit;
  JMenuItem exitItem;
  JButton start;

  static JLabel icon;

  static boolean pizzaDelivery;
  static ArrayList<Order> Order = new ArrayList<Order>();

  static boolean isMusicPlaying = false;


  MainFrame() {
	this.setLocation(0,0);
	this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1920, 1080);
    this.setLayout(null);

    New = new JButton("New Order");
    List = new JButton("Order List");
    Last = new JButton("Last Order");
    Delete = new JButton("Delete Order");
    Check = new JButton("Clear Check");
    Exit = new JButton("Exit");
	fileMenu = new JMenu("File");
    exitItem = new JMenuItem("Exit");
	icon = new JLabel(new ImageIcon("C:\\Users\\2PT-2\\Kulacenoks_eclipse\\Kulacenoks_pica\\Kulacenoks_pica\\src\\Pizzeria\\pizza.jpg"));
    menuBar = new JMenuBar();
    start = new JButton("Play music");

    add(New);
    add(List);
    add(Last);
    add(Delete);
    add(Check);
    add(Exit);
    add(start);
    add(icon);

    New.setBounds(300, 100, 260, 60);
    List.setBounds(300, 200, 260, 60);
    Last.setBounds(300, 300, 260, 60);
    Delete.setBounds(300, 400, 260, 60);
    Check.setBounds(300, 500, 260, 60);
    Exit.setBounds(300, 600, 260, 60);
    start.setBounds(400, 700, 200, 60);
    icon.setBounds(0, 0, 1920, 1080);
    icon.setVisible(true);
    

    New.addActionListener(this);
    List.addActionListener(this);
    Last.addActionListener(this);
    Delete.addActionListener(this);
    Check.addActionListener(this);
    Exit.addActionListener(this);
    exitItem.addActionListener(this);
    start.addActionListener(this);

    exitItem.setMnemonic(KeyEvent.VK_E); // e for exit

    fileMenu.add(exitItem);
    menuBar.add(fileMenu);
    this.setJMenuBar(menuBar);

    this.setVisible(true);
    JOptionPane.showMessageDialog(
      null,
      "Welcome to the Pizza Ordering App!\n\n" +
      "As a pizzeria worker, your job is to help customers place their orders " +
      "and ensure that they receive their delicious pizzas.\n\n" +
      "With our easy-to-use app" +
      "including different sizes, crusts, sauces, and toppings." +
      "Customize their pizzas to their exact liking.\n\n" +
      "Once the customer has placed their order, you can begin choosing write pizza options" +
      "\n\n" +
      "Thank you for using our Pizza Ordering App!",
      "Pizza Ordering App Tutorial",
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == New) {
      new OrderWindow();
    }

    if (e.getSource() == List) {
      if (Order.size() > 0) {
        String str =
          "Order amount: " + Order.size() + "\n";

        for (int i = 0; i < Order.size(); i++) {
        	
          str += Order.get(i).orderInfo(OrderWindow.pizzaDelivery);
        }
        str += "\n________________________\n";
        JTextArea textArea = new JTextArea(str);
        
        
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
       
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
         
        textArea.setLineWrap(true);  
        textArea.setWrapStyleWord(true); 
        scrollPane.setPreferredSize( new Dimension( 150, 500 ) );
        
        

        JOptionPane.showMessageDialog(
          null,
          scrollPane,
          "Order List",
          JOptionPane.INFORMATION_MESSAGE
        );
      } else {
        JOptionPane.showMessageDialog(
          null,
          "No Orders!",
          "Error",
          JOptionPane.ERROR_MESSAGE
        );
      }
    }
    if (e.getSource() == Last) {
      if (Order.size() > 0) {
        String orderInfoMessage = Order
          .get(Order.size() - 1)
          .orderInfo(pizzaDelivery);
        JTextArea textArea1 = new JTextArea(orderInfoMessage);
        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        JOptionPane.showMessageDialog(
          null,
          scrollPane1,
          "Last Order",
          JOptionPane.INFORMATION_MESSAGE
        );
      } else {
        JOptionPane.showMessageDialog(
          null,
          "No Orders!",
          "Error",
          JOptionPane.ERROR_MESSAGE
        );
      }
    }

    if (e.getSource() == Delete) {
      if (Order.size() > 0) {
        int choiceIndex = App.OrderChoose(Order);
        Order.remove(choiceIndex);
        JOptionPane.showMessageDialog(
          null,
          "Order deleted",
          "Money",
          JOptionPane.WARNING_MESSAGE
        );
      } else {
        JOptionPane.showMessageDialog(
          null,
          "No orders to delete!",
          "Error",
          JOptionPane.ERROR_MESSAGE
        );
      }
    }
    if (e.getSource() == Check) {
      App.clearCheck();
      JOptionPane.showMessageDialog(
        null,
        "Cashier's check is cleared",
        "Cleared",
        JOptionPane.INFORMATION_MESSAGE
      );
    }

    if (e.getSource() == start && !isMusicPlaying) {
      try {
        music(true);
        MainFrame.isMusicPlaying = true;
      } catch (UnsupportedAudioFileException e1) {
        System.out.println("UnsupportedAudioFileException");
        e1.printStackTrace();
      } catch (IOException e1) {
        System.out.println("IOException");
        e1.printStackTrace();
      } catch (LineUnavailableException e1) {
        System.out.println("LineUnavailableException");
        e1.printStackTrace();
      }
    }

    if (e.getSource() == exitItem) {
      System.exit(0);
    }
    if (e.getSource() == Exit) {
      System.exit(0);
    }
  }
}
