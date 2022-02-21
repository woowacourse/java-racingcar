package carracinggame.controller;

import carracinggame.domain.Car;
import carracinggame.domain.Cars;
import carracinggame.domain.Times;
import carracinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    int carsCount;

    Cars cars = new Cars();

    public void start(String[] carNames, int times) {
        cars.makeCars(carNames);
        carsCount = carNames.length;
        OutputView.printResultMessage();
        playRacingGame(times);
    }

    private void playRacingGame(int times) {
        while (!Times.isEnd(times)) {
            cars.run();
            turnResult();
            times--;
        }
    }

    private void turnResult() {
        for (int i = 0; i < carsCount; i++) {
            Car car = cars.getCar(i);
            OutputView.printResult(car.getName(), car.getPosition());
        }
        OutputView.println();
    }

    public void announceWinners() {
        List<Car> winners = cars.findWinner();
        ArrayList<String> winnerNames = new ArrayList<>();
        for (int i = 0; i < winners.size(); i++) {
            Car car = winners.get(i);
            winnerNames.add(car.getName());
        }
        OutputView.printWinners(winnerNames);
    }
}