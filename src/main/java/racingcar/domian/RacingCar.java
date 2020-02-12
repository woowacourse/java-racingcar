package racingcar.domian;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private Cars cars;

    public void run() {
        setUp(inputPlayerInfo());
        int round = inputGameRound();
    }

    private String[] inputPlayerInfo() {
        String[] names = InputView.inputCarName();
        return names;
    }

    private void setUp(String[] names) {
        List<Car> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Car(name));
        }
        cars = new Cars(players);
    }

    private int inputGameRound() {
        return InputView.inputGameRound();
    }
}
