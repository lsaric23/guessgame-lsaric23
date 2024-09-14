package SOLUTIONS.src;

import java.util.ArrayList;
import java.util.List;

public class GameScore {

    private List<Integer> scoredAfter;

    public GameScore(){
        this.scoredAfter = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "scoredAfter=" + this.scoredAfter +
                '}';
    }

    public void addScore(int attemptScore){
        this.scoredAfter.add(attemptScore);
    }

    public void listAttempts(){
        System.out.println(scoredAfter);
    }
    public List<Integer> getScoredAfter() {
        return this.scoredAfter;
    }

}
