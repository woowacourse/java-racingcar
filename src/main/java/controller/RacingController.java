package controller;

import model.Car;
import model.Cars;
import model.RandomGenerator;
import view.InputView;
import view.OutputView;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingController {
    public static final int START_POSITION = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;

    public RacingController() {
        inputView = new InputView(System.in);
        outputView = new OutputView();
    }

    public void start() {
        prepareRacing();
        process();
        end();
    }

    private void prepareRacing() {
        cars = new Cars(inputView.inputCarNames()
                .stream()
                .map(name -> new Car(name, new RandomGenerator(new Random())))
                .collect(Collectors.toUnmodifiableList())
        );
    }

    private void process() {
        int numberOfTimes = inputView.inputRepeatCount();
        outputView.resultHeader();
        IntStream.range(0, numberOfTimes)
                .forEach(this::repeat);
    }

    private void repeat(int count) {
        cars.moveAll();
        outputView.result(cars);
    }

    private void end() {
        outputView.result(cars);
        outputView.winner(cars.getWinner());
    }
}
