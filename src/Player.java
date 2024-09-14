package SOLUTIONS.src;

public class Player {
    private int id;
    private static int cntID = 10;
    private String name;

    public Player(String name){
        this.name = name;
        this.id = cntID++;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
