package SOLUTIONS.src;

import java.util.Scanner;

public class Game {

    private boolean play;
    private GameStats gameStats;
    private boolean in_same_guess;
    private GameScore gameScore;
    private Player player;
    private String playerGuess;
    private Scanner scanner;

    public Game() {
        this.gameStats = new GameStats();

    }

    public void startGame(Player player) {
        this.gameScore = new GameScore();
        scanner = new Scanner(System.in);
        System.out.println("Ready to start a game...\n" +
                "//////////////////////// Starting a new Game ////////////////////////");
        int totalAttempts = 0;
        play = true;
        while (play) {
            System.out.println("Guess this: ");
            String country = GuessGame.randomPickCountry();
            in_same_guess = true;
            int attempts = 0;
            while (in_same_guess) {
                GuessGame.printGuessFields(country);
                playerGuess = scanner.nextLine();
                in_same_guess = !(GuessGame.checkGuess(playerGuess, country));
                attempts++;
                if(!in_same_guess) {
                    System.out.println("Your guess: " + playerGuess + " == " + country);
                    System.out.println("You won!");
                    this.gameScore.addScore(attempts);
                    totalAttempts += attempts;
                }else {
                    System.out.println("Your guess: " + playerGuess + " != lookup country...");
                }
                System.out.println("=========================================================================================");
                proceedToPlay();
                if (!play){
                    break;
                }
            }

            this.gameScore.listAttempts();

        }
        int totalGuesses = this.gameScore.getScoredAfter().size();
        System.out.println("You chose to quit the game !");
        System.out.println("Total attempts: "+ totalAttempts);
        System.out.println("Total guesses played: " + totalGuesses );
        System.out.println("Average: " + (totalAttempts/totalGuesses));
        gameStats.addPlayerStats(player,gameScore);
        gameStats.showPlayerStats(player);
        gameStats.listAllStats();
    }

    public void proceedToPlay(){
        System.out.println("To proceed enter 'y', any other character to quit: ");
        String continuePlaying = scanner.nextLine();
        play = continuePlaying.equals("y");
    }}
