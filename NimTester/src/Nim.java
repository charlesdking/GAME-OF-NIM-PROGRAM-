/* Name:Charles King
   PID:5961386
   Section Number:COP337 U05
   I affirm that this program is entirely my own work 
   and none of it is the work of any other person.
        Signature:Charles David King
   File: Nim.java
   
   This class represents the game conductor where the initial pile size is used
   and passes to the Pile class. And the play method calls the move method for 
   each player polymorphically depending on the players who were chosen.
 */

/**
 * This Nim class takes the moves of the players and takes the decided amount
 * of marbles from the pile until there is one marble left and winner
 * is returned to NimTester and printed
 */
public class Nim {

    //Declares a variable of type Pile class
    private Pile pileStorage;

    /**
     * Creates a Pile Object where the pileSize is passes to the Pile class
     *
     * @param pileSize the initial size of the pile
     */
    public Nim(int pileSize) {
        //Creates Pile Object 
        pileStorage = new Pile(pileSize);
    }

    /**
     * Play method starts the actual game and conducts the actions of taking
     * marbles from the pile which is acquired from calling the move method
     * polymorphically for the player that was chosen. Then when there is one
     * more marble which ever player is last to take it loses and the winner is
     * returned to the NimTester and printed
     *
     * @param firstP First Player Object used to retrieve name and move method
     * @param secondP Second Player Object to retrieve name and move method
     * @return returns the winner of the game as a String
     */
    public String play(Player firstP, Player secondP) {
        //Declares String variable for the winner of the game
        String winner = "";
        /*
        While loop to ensure that game will only play when the marble size is 
        greater than 0 and allows for the game to stop when the marble
        size becomes 1 with use of breaks
         */
        while (pileStorage.getMarblePile() > 0) {
            //Calls move method polymorphically and assigns the returned int
            int firstRemove = firstP.move(pileStorage.getMarblePile());
            /*
               calls the take method of the Pile class and passes the numbers
            such player choose to remove
             */
            pileStorage.takeMarble(firstRemove);
            System.out.println(firstP.getName() + " takes "
                    + firstRemove + " Marble(s) from the Pile.");
            System.out.println("The remaining number of marbles in the pile "
                    + "is " + pileStorage.getMarblePile() + ".");
            System.out.println("");
            //if marble size becomes 1 then player two loses
            if (pileStorage.getMarblePile() == 1) {
                System.out.println(secondP.getName() + " is now forced to "
                        + "take the last marble from"
                        + " the pile which means " + firstP.getName() + " has"
                        + " won the game!");
                //removes 1 from pile as taking it for the second player
                pileStorage.takeMarble(1);
                System.out.println("The remaining number of marbles in the"
                        + " pile is now " + pileStorage.getMarblePile() + ".");
                //assigns winner to the name of first player
                winner = firstP.getName();
                //Breaks the loop at this point since player took last marble
                break;
            }
            //Calls move method polymorphically and assigns the returned int
            int secondRemove = secondP.move(pileStorage.getMarblePile());
            /*
               calls the take method of the Pile class and passes the numbers
            such player choose to remove
             */
            pileStorage.takeMarble(secondRemove);
            System.out.println(secondP.getName() + " takes "
                    + secondRemove + " Marble(s) from the Pile.");
            System.out.println("The remaining number of marbles in the pile "
                    + "is " + pileStorage.getMarblePile() + ".");
            System.out.println("");
            //if marble size becomes 1 then player one loses
            if (pileStorage.getMarblePile() == 1) {
                System.out.println(firstP.getName() + " is now forced to "
                        + "take the last marble from"
                        + " the pile which means " + secondP.getName() + " has"
                        + " won the game!");
                //removes 1 from pile as taking it for the first player
                pileStorage.takeMarble(1);
                System.out.println("The remaining number of marbles in the"
                        + " pile is now " + pileStorage.getMarblePile() + ".");
                //assigns winner to the name of first player
                winner = secondP.getName();
                //Breaks the loop at this point since player took last marble
                break;
            }

        }
        /*
        returns the assigned winner depending on which player took 
        the last marble
         */
        return winner;

    }
}
