import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return name + " - " + score;
    }
}

class Leaderboard<T> {
    ArrayList<T> players = new ArrayList<>();

    void addPlayer(T player) {
        players.add(player);
    }

    void display(Comparator<T> comparator) {
        players.sort(comparator);

        for (T player : players) {
            System.out.println(player);
        }
    }
}

public class LeaderboardDemo {
    public static void main(String[] args) {

        Leaderboard<Player> board = new Leaderboard<>();

        board.addPlayer(new Player("Roopa", 90));
        board.addPlayer(new Player("Priya", 85));
        board.addPlayer(new Player("Anu", 95));

        board.display((p1, p2) ->
            Integer.compare(p2.score, p1.score));
    }
}