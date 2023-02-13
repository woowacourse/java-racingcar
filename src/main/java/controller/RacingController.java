package controller;

import model.Car;
import model.Cars;
import view.InputView;
import view.OutputView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initializeCars();
    }

    private void initializeCars() {
        this.cars = new Cars(inputView.getCarNames()
                .stream()
                .map(name -> new Car(name))
                .collect(Collectors.toUnmodifiableList())
        );
    }

    public void race() {
        outputView.resultHeader();
        IntStream.range(0, inputView.getTryCount())
                .forEach(this::repeat);
        outputView.result(cars);
        outputView.winner(cars.getWinner());
    }

    private void repeat(int count) {
        cars.moveAll();
        outputView.result(cars);
    }
}
