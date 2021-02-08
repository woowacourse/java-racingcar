package racingcar.controller;

import racingcar.constant.Message;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Times;
import racingcar.service.CarService;
import racingcar.service.WinnerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RacingCarController {
    private final InputView inputView;
    private final CarService carService;
    private final WinnerService winnerService;

    public RacingCarController(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.carService = new CarService();
        this.winnerService = new WinnerService();
    }

    public void run() {
        List<String> carNames = getCarNames();
        Times times = getTimes();
        Cars cars = new Cars(carNames);

        OutputView.printResultMessage();

        playUntilDone(cars, times);

        List<String> winnerNames = winnerService.getWinnerNames(cars);
        OutputView.printWinner(winnerNames);
    }

    public List<String> getCarNames() {
        OutputView.printCarNamesRequest();
        return inputView.scanCarNames();
    }

    private Times getTimes() {
        OutputView.printTimesRequest();
        return new Times(inputView.scanTimes());
    }

    public void playUntilDone(Cars cars, Times times) {
        while (times.hasTurn()) {
            carService.decideMovableCar(cars, Collections.EMPTY_LIST);

            List<Car> carList = cars.getCars();
            List<String> names = getNames(carList);
            List<StringBuilder> hyphens = getHyphens(carList);

            OutputView.printResult(names, hyphens);

            times.reduce();
        }
    }

    private List<String> getNames(List<Car> carList) {
        List<String> names = new ArrayList<>();

        for (Car car : carList) {
            names.add(car.getName());
        }

        return names;
    }

    private List<StringBuilder> getHyphens(List<Car> carList) {
        List<StringBuilder> hyphens = new ArrayList<>();
        List<Integer> positions = getPositions(carList);

        for (Integer position : positions) {
            StringBuilder hyphen = drawHyphens(position);
            hyphens.add(hyphen);
        }

        return hyphens;
    }

    private List<Integer> getPositions(List<Car> carList) {
        List<Integer> positions = new ArrayList<>();

        for (Car car : carList) {
            positions.add(car.getPosition());
        }

        return positions;
    }

    private StringBuilder drawHyphens(Integer position) {
        StringBuilder hyphens = new StringBuilder();

        for (int i = 0; i < position; i++) {
            hyphens.append(Message.HYPHEN);
        }

        return hyphens;
    }
}
