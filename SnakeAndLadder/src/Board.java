import java.util.HashMap;
import java.util.Map;

public class Board {
    int startPosition;
    int endPosition;
    Map<Integer, Integer> snakes; // key > value
    Map<Integer, Integer> ladders; // key < value

    Board() {
        startPosition = 1;
        endPosition = 100;

        snakes = new HashMap<>();
        snakes.put(80, 20);
        snakes.put(50, 10);

        ladders = new HashMap<>();
        ladders.put(30, 70);
        ladders.put(40, 90);
    }

    int getNewPosition(Integer currentPosition, Integer change) {
        Integer newPosition = currentPosition + change;
        newPosition = Math.max(newPosition, startPosition);
        newPosition = Math.min(newPosition, endPosition);

        if (snakes.containsKey(newPosition)) newPosition = snakes.get(newPosition);
        if (ladders.containsKey(newPosition)) newPosition = ladders.get(newPosition);
        return newPosition;
    }

    boolean isEndPosition(Integer position) {
        return position == endPosition;
    }
}
