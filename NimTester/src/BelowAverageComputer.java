/* Name:Charles King
   PID:5961386
   Section Number:COP337 U05
   I affirm that this program is entirely my own work 
   and none of it is the work of any other person.
        Signature:Charles David King
   File: BelowAverageComputer.java
   
   This below average computer class implements the Player Interface and 
   represents a computer's cpu that is not as capable to do high level 
   algorithms as other computer cpus. 

   This below average computer class remove a random number of marbles from the
   pile that is from 1 marbles to half the size of the pile and also assigns 
   the name of the below average computer and returns the name aswell.
 */
import java.util.Random;

/**
 * A below average computer with the ability to take a random number of marbles
 * from 1 to half the size of the pile.
 */
public class BelowAverageComputer implements Player {

    //Declares a Private String for the name of the below average computer
    private String name;

    /**
     * Assigns the name of the below average computer
     *
     * @param name The name of the below average computer player
     */
    public BelowAverageComputer(String name) {
        //Assigns the name of the below average computer
        this.name = name;
    }

    /**
     * Move method for the below average computer where it chooses a random
     * number to take that is from 1 to half the size of the pile
     *
     * @param curPileSize The current size of the pile of marbles
     * @return Returns the amount of marbles the below average computer chose
     * to remove from the pile
     */
    public int move(int curPileSize) {
        //Creates a random object
        Random rn = new Random();
        /*
         * Assigns below average computer remove decision to a random 
         * number from 1 to half the current pile size
         */
        int randRemove = rn.nextInt(curPileSize / 2) + 1;
        /*returns the random number that the below average computer chose to 
        remove
         */
        return randRemove;
    }

    /**
     * To return the name of the Below Average Computer Player
     *
     * @return returns the name of the Below Average Computer player
     */
    public String getName() {
        return name;
    }
}
