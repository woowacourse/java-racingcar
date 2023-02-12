package controller;

import model.Car;
import model.Cars;
import model.RandomGenerator;
import view.OutputView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingController {

    private final OutputView outputView;
    private final Cars cars;
    private final int tryCount;

    public RacingController(List<String> carNames, int tryCount) {
        this.cars = new Cars(carNames
                .stream()
                .map(name -> new Car(name, new RandomGenerator(new Random())))
                .collect(Collectors.toUnmodifiableList())
        );
        this.tryCount = tryCount;
        this.outputView = new OutputView();
    }

    public void race() {
        outputView.resultHeader();
        IntStream.range(0, tryCount)
                .forEach(this::repeat);
        outputView.result(cars);
        outputView.winner(cars.getWinner());
    }

    private void repeat(int count) {
        cars.moveAll();
        outputView.result(cars);
    }
}
