package racingcar.domian;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private Cars cars;

    public void run() {
        setUp(inputPlayerInfo());
        int round = inputGameRound();
        OutputView.printNotice();
        startGame(round);
        OutputView.printResult(getResult());
    }

    private String getResult() {
        return cars.getResult();
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

    private void startGame(int round) {
        for (int i = 0; i < round; i++) {
            cars.moveAll();
            OutputView.printCurrentRound(cars.getCars());
        }
    }
}
