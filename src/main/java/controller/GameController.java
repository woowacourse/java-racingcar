package controller;
import domain.*;
import util.NumberGenerator;
import view.InputView;
import view.OutputView;
import java.util.List;
import java.util.stream.IntStream;
public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void play() {
        CarNameCatalog carNameCatalog = inputView.inputCarNameCatalog();
        Cars cars = Cars.from(carNameCatalog);
        RaceCount raceCount = inputView.inputRaceCount();
        List<RaceProgress> raceProgresses = IntStream.range(0, raceCount.getValue())
                .mapToObj(i -> {
                    progress(cars.getValue());
                    return RaceProgress.from(cars.getValue());
                })
                .toList();
        outputView.printRaceProgresses(raceProgresses);
        RaceResult raceResult = RaceResult.of(cars.getValue());
        outputView.printRaceResult(raceResult);
    }
    private void progress(final List<Car> cars) {
        cars.forEach(car -> {
            car.race(NumberGenerator.generate(Car.FORWARD_MAX_NUMBER));
        });
    }
}