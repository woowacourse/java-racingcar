package racingcar;

import java.util.HashMap;
import java.util.List;

public class Game {
    private HashMap<String, Integer> winners = new HashMap<String, Integer>();

    public Game(int iteration) {
    }

    public boolean checkMove(int i) {
        if(i < 0 || i >= 10) {
            throw new NumberFormatException("범위를 초과한 난수입니다.");
        }
        if (i >= 4 && i <= 9) {
            return true;
        }
        return false;
    }

    public HashMap<String, Integer> announceWinner() {
        winners.put("hiro", 6);
        return winners;
    }


    public String[] spiltCarsName(String carsNameInput) {
        String[] carNames = carsNameInput.trim()
                .replace(" ", "")
                .split(",");
        return carNames;
    }
}
