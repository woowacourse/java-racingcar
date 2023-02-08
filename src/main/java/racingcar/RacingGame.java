package racingcar;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int RANGE_MAX = 9;
    private static final int RANGE_MIN = 0;

    private final InputView inputView = new InputView();
    private final int gameCount;

    private List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();


    public RacingGame() {
        initRacing();
        this.gameCount = inputView.inputGameTime();
    }

    private void initRacing() {
        String[] input = inputView.inputCarName();
        Arrays.stream(input).forEach(s -> cars.add(new Car(s)));
    }

    private int generateRandomNumber() {
        return (int) ((Math.random() * (RANGE_MAX - RANGE_MIN)) + RANGE_MIN);
    }

    private void updateCarPosition() {
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = generateRandomNumber();
            cars.get(i).move(randomNumber);
        }
    }

}
