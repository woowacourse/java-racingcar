package controller;

import racingcar.Car;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(OutputView outputView) {
        this.inputView = new InputView(outputView);
        this.outputView = outputView;
    }

    public void run() {
        List<Car> cars = makeCars();
        // TODO : 시도 횟수 예외 처리
        int trial = inputView.readNumberOfMoving();
    }

    private List<Car> makeCars() {
        String carNames = inputView.readCarNames();
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
