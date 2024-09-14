package SOLUTIONS.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameStats {

    private HashMap<Player, List<GameScore>> playersData;
    private HashMap<Player,Float> avgScores;
    public GameStats() {
        this.playersData = new HashMap<>();
        this.avgScores = new HashMap<>();
    }

    public void showPlayerStats(Player player) {
        System.out.println("_____________________________________________________________");
        System.out.println("Players: " + player + " - stats: ");
        for(GameScore gameScore : playersData.get(player)) {
            System.out.println(gameScore.getScoredAfter());
        }
        System.out.println("_____________________________________________________________");
        System.out.println("Average score: " + avgScores.get(player) + " attempts per guessed country. ");
    }

    public void addPlayerStats(Player player, GameScore gameScore) {
        if (!playersData.containsKey(player)) {
            playersData.put(player, new ArrayList<>());
        }
        playersData.get(player).add(gameScore);
        float avg = calculateAverageScore(player);
        avgScores.put(player, avg);

        System.out.println("Player stats is created and updated!\n" +
                "Players avg score updated!");

    }

    public void listAllStats() {
        //for(Map.Entry<Player, List<GameScore>> data: playersData.entrySet()) {
        //  System.out.println("Player: " + data.getKey().toString()+" - stats:\n" + data.getValue().getFirst().toString());
        // }
        System.out.println("==================================== Player's stats ====================================");
        for (Player player : playersData.keySet()) {
            System.out.println("Player: " + player);
            System.out.println("_____________________________________________________________");
            for(GameScore gameScore : playersData.get(player)) {
                System.out.println("Game score: " +gameScore.getScoredAfter());
            }
            System.out.println("Avg score:" + avgScores.get(player));
        }

    }

    private float calculateAverageScore(Player player) {
        List<GameScore> gameScore = playersData.get(player);
        List<Integer> scores = gameScore.getFirst().getScoredAfter();
        float sum = 0;
        for(Integer i : scores) {
            sum += i;
        }
        return sum/scores.size();
    }
}
