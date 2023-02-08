package racingcar;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private final InputView inputView = new InputView();
    private List<Car> cars = new ArrayList<>();
    private List<Car> winners = new ArrayList<>();


    public RacingGame() {
        initRacing();
    }

    private void initRacing() {
        String[] input = inputView.inputCarName();
        Arrays.stream(input).forEach(s -> cars.add(new Car(s)));
    }

}
