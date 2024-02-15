package racing.controller;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Race;
import racing.domain.TryCount;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame(){
        Cars cars = new Cars(inputView.readNames());
        TryCount tryCount = new TryCount(inputView.readTryCount());

        Race race = new Race(cars, tryCount);
        List<String> result = race.proceedRace();

        outputView.printResult(result);
        outputView.printWinners(race.getWinners());
    }
}
