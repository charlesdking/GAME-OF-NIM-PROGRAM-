/* Name:Charles King
   File: Pile.java
   
   This class represents the pile of marbles that the game of Nim requires.
   This pile class deals with the removal of marbles from the pile and the 
   method to get the current number of marbles in the pile.
 */

/**
 * Pile class handles the maintenance of the marbles in the pile
 *
 */
public class Pile {

    //Declares a Private Integer for the number of marbles in the pile
    private int marblePile;

    /**
     * Assigns the number initial number of marbles in the pile
     *
     * @param marbles the number of marbles in the pile the game started with
     */
    public Pile(int marbles) {
        //Assigns the number of marbles in the pile
        marblePile = marbles;
    }

    /**
     * Remove the number of marbles that a player chose to remove
     *
     * @param numMarbles the number of marbles that a player chose to remove
     * @return returns the amount of marbles left in the pile
     */
    public int takeMarble(int numMarbles) {
        marblePile -= numMarbles;
        return marblePile;
    }

    /**
     * Gets the current number of marbles in the pile
     *
     * @return returns the current number of marbles in the pile
     */
    public int getMarblePile() {
        return marblePile;
    }
}
