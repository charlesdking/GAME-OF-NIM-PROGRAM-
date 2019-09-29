/* Name:Charles King
   File: Player.java
 */

/**
 * An interface to represent players of a game.
 */
public interface Player {

    /**
     * Deals with the way in which a player moves marbles
     *
     * @param curpileSize the current pile size of the marbles
     * @return returns the amount of marbles player takes
     */
    int move(int curpileSize); //abstract method

    /**
     * Deals with the player's name
     *
     * @return returns the name of the player
     */
    String getName(); //abstract method
}
