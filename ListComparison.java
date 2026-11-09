import java.util.*;

public class ListComparison {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> linked = new LinkedList<>();
        ArrayDeque<String> deque = new ArrayDeque<>();

        list.add("Song 1");
        list.add("Song 2");

        linked.add("Song 1");
        linked.add("Song 2");

        deque.add("Song 1");
        deque.add("Song 2");

        System.out.println("ArrayList: " + list);
        System.out.println("LinkedList: " + linked);
        System.out.println("ArrayDeque: " + deque);
    }
}