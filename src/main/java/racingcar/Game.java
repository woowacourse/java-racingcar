package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private HashMap<String, Integer> winners = new HashMap<String, Integer>();
    private List<Car> cars = new ArrayList<Car>();

    public Game(List<Car> cars, int iteration) {

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
}
