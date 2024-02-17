package racing.controller;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Race;
import racing.domain.TryCount;
import racing.view.InputView;
import racing.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Parser parser;

    public Controller(InputView inputView, OutputView outputView, Parser parser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
    }

    public void startGame() {
        List<String> names = parser.parse(inputView.readNames());
        Cars cars = new Cars(names.stream().map(Car::new).collect(Collectors.toList()));
        TryCount tryCount = new TryCount(inputView.readTryCount());

        Race race = new Race(cars, tryCount);
        List<Cars> result = race.proceed();

        outputView.printResult(result);
        outputView.printWinners(race.findWinners());
    }
}
