package racingcar.domian;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    private Random random;
    private Cars cars;

    public RacingCar() {
        random = new Random();
    }

    public void run() {
        setUp(inputPlayerInfo());
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

    public int generateRandom() {
        return random.nextInt(10);
    }
}
