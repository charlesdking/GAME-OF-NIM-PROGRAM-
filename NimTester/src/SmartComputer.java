/* Name:Charles King
   File: SmartComputer.java
   
   This smart computer class implements the Player Interface and 
   represents a computer's cpu that is capable of doing high level 
   algorithms inorder to win a mjority of games verus other player.

   This smart computer class remove exactly enough marbles as to make the size
   of the pile of marbles be a power of two minus one which would equate (1, 3,
   7,15,31,or 63).As long as the smart computer player goes first and is not 
   faced with an initial pile size of 15, 31, or 63 it will always win. In the 
   case where faced with such pile size of against a player who knows the 
   winning strategy than remove 1 marbles from the pile.
 */

/**
 * A below average computer with the ability to use winning strategy to win if
 * not faced with certain limitations
 */
public class SmartComputer implements Player {

    //Declares a Private String for the name of the smart computer
    private String name;

    /**
     * Assigns the name of the smart computer
     *
     * @param name The name of the smart computer player
     */
    public SmartComputer(String name) {
        //Assigns the name of the below average computer
        this.name = name;
    }

    /**
     * Move method for the smart computer where it removes exactly enough
     * marbles as to make the size of the pile of marbles be a power of two
     * minus one which would equate (1, 3, 7,15,31,or 63).
     *
     * @param curPileSize The current size of the pile of marbles
     * @return Returns the amount of marbles the smart computer chose to remove
     * from the pile
     */
    public int move(int curPileSize) {
        //Assigns the integer of marbles to remove initial with 0
        int smartRemove = 0;
        /*
       for loop for transvering through the exponents that would equate (1, 3, 
       7,15,31,or 63) when used in the formula.
         */
        for (int i = 6; i >= 1; i--) {
            /*if statement that check that the formula is less than the current 
          pile size
             */
            if (Math.pow(2, i) - 1 < curPileSize) {
                /*
        Assigns the smart computer remove variable to an integer of the current 
        pile size minus the formula, since that variable when subtracted to the 
        current pile size equals the algorithm we are following which is 
        to have the pile size equate to one of these (1, 3, 7,15,31,or 63).
                 */
                smartRemove = (int) (curPileSize - (Math.pow(2, i) - 1));
                /*
        if statement that checks when remove variable is found to be greater 
        than half the pile size.
                 */
                if (smartRemove > curPileSize / 2) {
               //Assign the remove varible to 1 as to remove 1 marble from pile
                    smartRemove = 1;
                }
                /*break statement when such exponent is found that satisfies 
                  prior conditions so that remove variable does not continue 
                  to change
                 */
                break;
            }

        }
        /*
        returns the remove varible that follows the winning strategy
         */
        return smartRemove;

    }

    /**
     * To return the name of the Smart Computer Player
     *
     * @return returns the name of the Smart Computer player
     */
    public String getName() {
        return name;
    }
}
