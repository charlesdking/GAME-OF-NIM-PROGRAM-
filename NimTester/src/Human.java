/* Name:Charles King
   PID:5961386
   Section Number:COP337 U05
   I affirm that this program is entirely my own work 
   and none of it is the work of any other person.
        Signature:Charles David King
   File: Human.java
   
   This human class implements the Player Interface and represents
   a human in the way that they will pick the amount of marbles to take from 
   the piles which is by their own decision ofcourse with some constrains as 
   to how many or how little is allowed and where the name of the human 
   is found
 */
import java.util.Scanner;

/**
 * A Human with a the ability to pick a certain amount of marbles to take
 */
public class Human implements Player {

    //Declares a Private String for the name of the Human
    private String name;
    //create scanner object
    Scanner input = new Scanner(System.in);

    /**
     * Assigns the name of the human
     *
     * @param name The name of the human player
     */
    public Human(String name) {
        //Assigns the name of the human
        this.name = name;
    }

    /**
     * Move method for the human where they choose the amount to remove
     * interactively through the keyboard
     *
     * @param curPileSize The current size of the pile of marbles
     * @return Returns the amount of marbles the human player chose to remove
     */
    public int move(int curPileSize) {
        //Assigns the integer of marbles to remove initial with 0
        int humanRemove = 0;
        do {
            System.out.println("How many marbles would you like to remove from"
                    + " the pile?\nYou must remove at least one but no more "
                    + "than half of the remaining marbles.");
            //Assigns the amount of marbles to remove to a variable humanRemove
            humanRemove = input.nextInt();

            /*
          if statement for when the human tries to remove an illegal number 
         of marbles
             */
            if ((humanRemove <= 0 || humanRemove > (curPileSize / 2))) {
                System.out.println("You have entered an incorrect entry. "
                        + "Please try again.");
            }

        } //while loop that continues to loop until human enters a legal number
        while ((humanRemove <= 0 || humanRemove > (curPileSize / 2)));
        //returns the number of marbles human chose to remove from the pile
        return humanRemove;
    }

    /**
     * To return the name of the Human Player
     *
     * @return returns the name of the human player
     */
    public String getName() {

        return name;
    }
}
