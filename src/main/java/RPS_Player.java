import java.util.Random;

public class RPS_Player {
    private static final int Rock = 1;
    private static final int Paper = 2;
    private static final int Scissors = 3;

    private int numberOfGamesWon;
    private int numberOfGamesPlayed;
    private int choice;
    private String name;

    public RPS_Player(String name){
        // TODO: replace this line with your code.
        this.name = name;
        clear();
    }

    public String getName(){
        // TODO: replace this line with your code.
        return name;
    }

    /**
     * Returns the number of games played since a clear() was issued.
     * @return returns the number of games played.
     */
    public int getNumberOfGamesPlayed(){
        // TODO: replace this line with your code.
        return numberOfGamesPlayed;
    }

    /**
     * Returns the number of games won since a clear() was issued.
     * @return returns the number of games won.
     */
    public int getNumberOfGamesWon(){
        // TODO: replace this line with your code.
        return numberOfGamesWon;
    }

    /**
     * Returns the win percentage as number between 0 and 1.
     * @return win percentage as a double.
     */
    public double getWinPercentage(){
        // TODO: replace this line with your code.
        if(numberOfGamesPlayed == 0){
            return 0.0;
        }
        return (double) numberOfGamesWon / numberOfGamesPlayed;
    }

    public void makeChoice(){
        Random random = new Random();
        this.choice = random.nextInt(3);
    }

    /**
     * Starts a new game.
     */
    public void clear(){
        // TODO: replace this line with your code.
        numberOfGamesPlayed = 0;
        numberOfGamesWon = 0;
        choice = -1;
    }

    /**
     * This player challenges anotherPlayer whereby both players make a
     * random choice of rock, paper, scissors.  A reference to the winning
     * player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player challenge(RPS_Player anotherPlayer){
        // TODO: replace this line with your code.
        this.makeChoice();
        this.numberOfGamesPlayed++;
        anotherPlayer.numberOfGamesPlayed++;
        anotherPlayer.makeChoice();
        RPS_Player winner = this;
        if(this.choice == anotherPlayer.choice){
            return null;
        }
        switch (this.choice) {
            case Rock:
                if (anotherPlayer.choice == Paper) {
                    winner = anotherPlayer;
                }
                break;
            case Paper:
                if (anotherPlayer.choice == Scissors){
                    winner = anotherPlayer;
                }
                break;
            case Scissors:
                if(anotherPlayer.choice == Rock){
                    winner = anotherPlayer;
                }

        }

        winner.numberOfGamesWon++;
        return winner;
    }

    /**
     * This player challenges anotherPlayer whereby this player uses the previous
     * choice made and anotherPlayer makes a random choice of rock, paper, scissors.
     * A reference to the winning player is returned or null if there is a draw.
     * @param anotherPlayer an RPS_Player that this player is challenging.
     * @return Reference to the RPS_Player that won or a null if there is a draw
     */
    public RPS_Player keepAndChallenge(RPS_Player anotherPlayer){
        // TODO: replace this line with your code.
        anotherPlayer.makeChoice();
        RPS_Player winner = this;
        if(this.choice == anotherPlayer.choice){
            return null;
        }
        switch (this.choice) {
            case Rock:
                if (anotherPlayer.choice == Paper) {
                    winner = anotherPlayer;
                }
                break;
            case Paper:
                if (anotherPlayer.choice == Scissors){
                    winner = anotherPlayer;
                }
                break;
            case Scissors:
                if(anotherPlayer.choice == Rock){
                    winner = anotherPlayer;
                }

        }
        this.numberOfGamesPlayed++;
        anotherPlayer.numberOfGamesPlayed++;
        winner.numberOfGamesWon++;
        return winner;
    }

}