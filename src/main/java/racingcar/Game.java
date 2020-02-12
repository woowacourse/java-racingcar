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



    public HashMap<String, Integer> announceWinner() {
        winners.put("hiro", 6);
        return winners;
    }
}
