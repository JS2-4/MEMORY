import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;


public class Game extends JPanel {
    private Image Dice_A;
    private Image Dice_B;
    private Image Dice_C;
    private Image Dice_D;

    private Die DiceA = new Die();
    private Die DiceB = new Die();
    private Die DiceC = new Die();
    private Die DiceD = new Die();

    private Image Slot_7;
    private Image SlotAnimation = Slot_7;
    private Image Slot_Apple;
    private Image Slot_Bar;
    private Image Slot_Cherry;
    private Image Slot_Grape;
    private Image Slot_Lemon;

    private Image SlotMachine_1;
    private Image SlotMachine_2;
    private Image SlotMachine_3;
    private Image SlotMachine_4;
    private Image YOU_WIN;
    private Image YOU_LOSE;
    
    private Image SlotMachine = SlotMachine_1;
    private Image DiceAnimation = Dice_A;
    private int amount_bet=0;
    private int MoneyDumped=0;
    private int SayOnceD = 1;
    private int MoneyLeft = 10000;
    private Scanner sc = new Scanner(System.in);
    private boolean currentGame;
    private String curDir = System.getProperty("user.dir") + "/MEMORY";

    ArrayList<Die> dize = new ArrayList<Die>();

    private void loadImages ( ) {
      
        System.out.println(curDir);
        Dice_A = new ImageIcon(curDir + "/images/Dice_6.png","").getImage ( );
        Dice_B = new ImageIcon (curDir + "/images/Dice_6.png","").getImage ( );
        Dice_C = new ImageIcon (curDir + "/images/Dice_6.png","").getImage ( );
        Dice_D = new ImageIcon (curDir + "/images/Dice_6.png","").getImage ( );

        Slot_7 = new ImageIcon (curDir + "/images/Slot_7.png","").getImage ( );
     Slot_Apple = new ImageIcon (curDir + "/images/Slot_Apple.png","").getImage ( );
     Slot_Bar = new ImageIcon (curDir + "/images/Slot_Bar.png","").getImage ( );
     Slot_Cherry = new ImageIcon (curDir + "/images/Slot_Cherry.png","").getImage ( );
     Slot_Grape = new ImageIcon (curDir + "/images/Slot_Grape.png","").getImage ( );
     Slot_Lemon = new ImageIcon (curDir + "/images/Slot_Lemon.png","").getImage ( );
            
        SlotMachine_1 = new ImageIcon (curDir + "/images/SlotMachine_1","").getImage ( );
        SlotMachine_2 = new ImageIcon (curDir + "/images/SlotMachine_2","").getImage ( );
        SlotMachine_3 = new ImageIcon (curDir + "/images/SlotMachine_3","").getImage ( );
        SlotMachine_4 = new ImageIcon (curDir + "/images/SlotMachine_4","").getImage ( );

        YOU_WIN = new ImageIcon (curDir + "/images/YOU_WIN", "").getImage ();
        YOU_LOSE = new ImageIcon (curDir + "/images/YOU_LOSE", "").getImage ();
       
    
}
 

public Game() {
    // Load all the relevant images.
    loadImages ( );
    
    // Set up the window.
    JFrame easel = new JFrame();      
    easel.setSize (700, 700);
    easel.add (this);
    easel.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    easel.setVisible (true);
    this.setBackground(Color.black);


while(MoneyLeft < 25000){
            System.out.println("Which Mode? (type /dice or /slots)");
         String input = sc.next();
         while(!input.equals("/dice")&&!input.equals("/slots")){
            System.out.println("Error: type /dice or /slots");
             input = sc.next();
        }
         if(input.equals("/slots")){
            slots();
            currentGame = false;
            //start the Slots program();
            // Switches mode to slots and slot command runs.
         }
         else if(input.equals("/dice")){
            dice();
            currentGame = true;
            //start the other program
            // Switches mode to dice and dice command runs.
}
    
//delay
if(MoneyLeft > 25000){
    break;

}
System.out.println("Play Again? (Yes or No)");
input = sc.next();
    while(input.equalsIgnoreCase("Yes")){      
            if(currentGame){
        dice();
            }
            else{
                slots();
            }
 System.out.println("Play Again? (Yes or No)");
input = sc.next();
    }
    if(MoneyLeft > 25000){
        break;
    }

}
    String temp = "Congrats! You hit 25k!";
    System.out.println(temp);
    
}
 

public void dice(){
    currentGame = true;
        amount_bet = 0; 
        
        dize.add(new Die());
        dize.add(new Die());
        dize.add(new Die());
        dize.add(new Die());

     System.out.println("Amount to bet?");
    int input = sc.nextInt();
          String response;
            while(MoneyLeft - input < 0 && input > 0){
                System.out.println("You don't have enough money!");
                System.out.println("Amount to bet?");
                input = sc.nextInt();
            }
            amount_bet = input;
            MoneyLeft -= input;

        System.out.println("Type /toss to run");
            response = sc.next();
            while(!response.equals("/toss")){
               System.out.println("Error: Type /toss to run");
               response = sc.next();
            }
            // repaint();
if((dize.get(0).value() + dize.get(1).value()) > (dize.get(2).value() + dize.get(3).value())){
        MoneyLeft = MoneyLeft + amount_bet*2;
        System.out.println("You Win! You've Won: $" + amount_bet*2 + "!");
            //let YOU_WIN hover over game for 1.5 seconds
        amount_bet = 0;
    }
    else if((dize.get(0).value() + dize.get(1).value()) == (dize.get(2).value() + dize.get(3).value())){
        System.out.println("It's a Tie! Nothing happens!");
        MoneyLeft = MoneyLeft + amount_bet;
        amount_bet = 0;
     }

    else{
    System.out.println("You Lost! You Lose it all!");
        //let YOU_lOSE hover over game for 1.5 seconds
MoneyDumped += amount_bet;
        amount_bet = 0;
        
    }
}
    

// public void paintComponent(Graphics g){
//     System.out.println("paintcalled");
//     Graphics2D beep = (Graphics2D) g;
//     if(currentGame){
//         this.setBackground(Color.white);
//         Dice_A = new ImageIcon(curDir + "/images/Dice_"+ DiceA.value()+".png","").getImage ( );
//         Dice_B = new ImageIcon(curDir + "/images/Dice_"+ DiceB.value()+".png","").getImage ( );
//         Dice_C = new ImageIcon(curDir + "/images/Dice_"+ DiceC.value()+".png","").getImage ( );
//         Dice_D = new ImageIcon(curDir + "/images/Dice_"+ DiceD.value()+".png","").getImage ( );
//     beep.drawImage(Dice_A, 19, 19, this);
//     beep.drawImage(Dice_B, 50, 19, this);
//     beep.drawImage(Dice_C, 19, 50, this);
//     beep.drawImage(Dice_D, 19, 50, this);
//     }    
//     else {

//     }
// }

public void slots(){

    Slot A = new Slot();
    Slot B = new Slot();
    Slot C = new Slot();
    Slot D = new Slot();
    repaint();
    System.out.println("Amount to bet?");
    int  input = sc.nextInt();

    String response;
      while(MoneyLeft - input < 0 && input > 0){
          System.out.println("You don't have enough money!");
          System.out.println("Amount to bet?");
          input = sc.nextInt();
      }
      amount_bet = input;
      MoneyLeft -= input;

  System.out.println("Type /run to run");

      response = sc.next();
     while(!response.equals("/run")){
        System.out.println("Error: Type /run to run");
        response = sc.next();
     }
      slotAnimation();
      //assign image to result numbers
      A.getSlotResults();
      B.getSlotResults();
      C.getSlotResults();
      D.getSlotResults();

      if(A.getSlotResults() == B.getSlotResults() && C.getSlotResults() == D.getSlotResults()&&A.getSlotResults()==C.getSlotResults()){
        int result = A.getSlotResults();
    if(result == 6){
        MoneyLeft = MoneyLeft + amount_bet*10;
        //let YOU_WIN hover over game for 1.5 seconds
        System.out.println("JACKPOT! YOU WIN $" + amount_bet*10 + "!");
        amount_bet = 0;
    }
    if(result == 5){
        MoneyLeft = MoneyLeft + amount_bet*7;
        //let YOU_WIN hover over game for 1.5 seconds
        System.out.println("MATCH! YOU WIN $" + amount_bet*7 + "!");
        amount_bet = 0;
    }
    if(result == 4){
        MoneyLeft = MoneyLeft + amount_bet*7;
        //let YOU_WIN hover over game for 1.5 seconds
        System.out.println("BAR! YOU WIN $" + amount_bet*7 + "!");
        amount_bet = 0;
    }
    if(A.result == 3){
        MoneyLeft = MoneyLeft + amount_bet*7;
        //let YOU_WIN hover over game for 1.5 seconds
        System.out.println("MATCH! YOU WIN $" + amount_bet*7 + "!");
        amount_bet = 0;
    }
    if(A.result == 2){
        MoneyLeft = MoneyLeft + amount_bet*7;
    //let YOU_WIN hover over game for 1.5 seconds
        System.out.println("MATCH! YOU WIN $" + amount_bet*7 + "!");
        amount_bet = 0;
    }
    else {
        MoneyLeft = MoneyLeft + amount_bet*7;
          //let YOU_WIN hover over game for 1.5 seconds
        System.out.println("MATCH! YOU WIN $" + amount_bet*7 + "!");
        amount_bet = 0;
    }

}
    else{
    System.out.println("NO MATCH! YOU LOST $" + amount_bet + "!");
    //let YOU_LOSE hover over game for 1.5 seconds
MoneyDumped = MoneyDumped + amount_bet;
        amount_bet = 0;
    }
}


    private void slotAnimation(){
        int rollTime = 3;
        long time = System.currentTimeMillis();
        while(System.currentTimeMillis()-time < rollTime*1000){
            
            repaint();
        }


        //repeat shuffling until finished
    }


}


