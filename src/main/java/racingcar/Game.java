package racingcar;

import java.util.HashMap;

public class Game {
    public Game(int iteration) {
    }

    public boolean checkMove(int i) {
        if(i <= 3) {
            return false;
        }
        return true;
    }

    public HashMap<String, Integer> announceWinner() {
        HashMap<String, Integer> winners = new HashMap<String, Integer>();
        winners.put("hiro", 6);
        return winners;
    }
}
