/* Name:Charles King
   PID:5961386
   Section Number:COP337 U05
   I affirm that this program is entirely my own work 
   and none of it is the work of any other person.
        Signature:Charles David King
   File: NimTester.java
   
   This class uses the Scanner class to get the main method parameters from the 
   user such as the players who are playing the game, who is going first,
   the name of the players(if Humans). It also creates player objects depending
   on the player who the user choose. And creates a Nim object where the play 
   method is called and returns the winner.
 */

import java.util.Random;
import java.util.Scanner;

public class NimTester {

    /**
     * A test class for the Nim class.
     */
    public static void main(String[] args) {
        //create scanner object 
        Scanner input = new Scanner(System.in);
        // String variable for user input for playing again
        String playAgain = "";
        do {
            System.out.println("Welcome to The Ancient and Honorable Game of "
                    + "Nim!\nUser, input who you would like the game to be "
                    + "played by.\nFirst player will have the first turn in "
                    + "the game.\n[H for the Human, SC for the SmartComputer,"
                    + " and BAC for the BelowAverageComputer]");
            System.out.print("First Player:");
            //Assigns first player by user
            String playerOne = input.nextLine();
            System.out.print("Second Player:");
            //Assigns second player by user
            String playerTwo = input.nextLine();
            //Declares variable type Player for firstPlayer
            Player firstPlayer = null;
            //Declares variable of type Player for secondPlayer
            Player secondPlayer = null;
            //While loop for when user inputs an incorrect player selection
            while (!playerOne.equalsIgnoreCase("H")
                    && !playerOne.equalsIgnoreCase("SC")
                    && !playerOne.equalsIgnoreCase("BAC")
                    || !playerTwo.equalsIgnoreCase("H")
                    && !playerTwo.equalsIgnoreCase("SC")
                    && !playerTwo.equalsIgnoreCase("BAC")) {
                System.out.println("Please enter a valid player option.");
                System.out.print("First Player:");
                //Assigns first player again by user
                playerOne = input.nextLine();
                System.out.print("Second Player:");
                //Assigns first player again by user
                playerTwo = input.nextLine();

            }
            /*
             * If statement that executes if user chooses first or second 
             * player to be a human player
             */
            if (playerOne.equalsIgnoreCase("H")
                    || playerTwo.equalsIgnoreCase("H")) {
                //if statement for when both human players are chosen
                if (playerOne.equalsIgnoreCase("H")
                        && playerTwo.equalsIgnoreCase("H")) {
                    System.out.print("What will the name of human "
                            + "player one be:");
                    //Assigns the name of the first human player
                    String firstName = input.nextLine();
                    System.out.print("What will the name of human "
                            + "player two be:");
                    //Assigns the name of the second human player
                    String secondName = input.nextLine();
                    //Creates player object for first player and passes name
                    firstPlayer = new Human(firstName);
                    //Creates player object for second player and passes name
                    secondPlayer = new Human(secondName);
                    //if statement for when first human player is chosen
                } else if (playerOne.equalsIgnoreCase("H")) {
                    System.out.print("What will the name of human "
                            + "player one be:");
                    //Assigns the name of the first human player
                    String firstName = input.nextLine();
                    //Creates player object for first player and passes name
                    firstPlayer = new Human(firstName);
                    //if statement for when second human player is chosen
                } else if (playerTwo.equalsIgnoreCase("H")) {
                    System.out.println("What will the name of human "
                            + "player two be:");
                    //Assigns the name of the second human player
                    String secondName = input.nextLine();
                    //Creates player object for second player and passes name
                    secondPlayer = new Human(secondName);
                }
            }
            /*
             * If statement that executes if user chooses first or second 
             * player to be a smart computer
             */
            if (playerOne.equalsIgnoreCase("SC")
                    || playerTwo.equalsIgnoreCase("SC")) {
                //Assigns smart computer name 
                String smartName = "Smart Comp";
                //if statement for when both smart computer players are chosen
                if (playerOne.equalsIgnoreCase("SC")
                        && playerTwo.equalsIgnoreCase("SC")) {
                    /*
                     * Creates player object for first player and passes name
                     * along with a 1 to distinguish between each player
                     */
                    firstPlayer = new SmartComputer(smartName + " 1");
                    /*
                     * Creates player object for second player and passes name
                     * along with a 2 to distinguish between each player
                     */
                    secondPlayer = new SmartComputer(smartName + " 2");
                  //if statement for when first smart computer player is chosen 
                } else if (playerOne.equalsIgnoreCase("SC")) {
                    //Creates player object for first player and passes name
                    firstPlayer = new SmartComputer(smartName);
                 //if statement for when second smart computer player is chosen
                } else if (playerTwo.equalsIgnoreCase("SC")) {
                    //Creates player object for second player and passes name
                    secondPlayer = new SmartComputer(smartName);
                }
            }
            /*
             * If statement that executes if user chooses first or second 
             * player to be a below average computer
             */
            if (playerOne.equalsIgnoreCase("BAC")
                    || playerTwo.equalsIgnoreCase("BAC")) {
                //Assigns below average computer name 
                String dumbName = "Below Average Comp";
                /*
                 * if statement for when both below average computer players 
                 * are chosen
                 */
                if (playerOne.equalsIgnoreCase("BAC")
                        && playerTwo.equalsIgnoreCase("BAC")) {
                    /*
                     * Creates player object for first player and passes name
                     * along with a 1 to distinguish between each player
                     */
                    firstPlayer = new BelowAverageComputer(dumbName + " 1");
                    /*
                     * Creates player object for second player and passes name
                     * along with a 2 to distinguish between each player
                     */
                    secondPlayer = new BelowAverageComputer(dumbName + " 2");
                    /*
                 * if statement for when first below average computer player
                 * is chosen 
                     */
                } else if (playerOne.equalsIgnoreCase("BAC")) {
                    //Creates player object for first player and passes name
                    firstPlayer = new BelowAverageComputer(dumbName);
                    /*
                 * if statement for when second below average computer player
                 * is chosen 
                     */
                } else if (playerTwo.equalsIgnoreCase("BAC")) {
                    //Creates player object for first player and passes name
                    secondPlayer = new BelowAverageComputer(dumbName);
                }
            }
            //Creates random object
            Random randMarbles = new Random();
            /*
             * Assigns initial pile size of the marble to a random number from
             * 10 to 100
             */
            int InitmarbleSize = randMarbles.nextInt(91) + 10;
            //Creates Nim object that passes the initial size of the pile
            Nim nimGame = new Nim(InitmarbleSize);
            System.out.println("There are " + InitmarbleSize + " marbles in"
                    + " pile.");
            /*
             * Calls the play method and passes both players and returns the
             * winner
             */
            String gameWinner = nimGame.play(firstPlayer, secondPlayer);
            System.out.println("The winner of The Ancient and Honorable Game "
                    + "of Nim is " + gameWinner + "!");
            System.out.println("Would you like to play again? [y for yes and"
                    + " n for no]");
            //Assigns the anwser of the user to play again
            playAgain = input.nextLine();
            //While loop for when user wants to play again
        } while (playAgain.equalsIgnoreCase("y"));

    }

}
