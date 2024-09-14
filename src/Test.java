package SOLUTIONS.src;

public class Test {

    public Test(){

    }
    public static void main(String[] args) {
        Game game = new Game();
        Player p1 = new Player("Rob");
        Player p2 = new Player("Jane");
        game.startGame(p1);
        game.startGame(p1);
        game.startGame(p2);


    }
}
