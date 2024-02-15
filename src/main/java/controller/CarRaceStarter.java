package controller;

import domain.Car;
import domain.Judge;
import domain.RandomGenerator;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceStarter {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Judge judge = new Judge();

    public void start() {
        List<Car> cars = makeCars();
        int count = makeCount();

        raceStart(count, cars);

        List<Car> winners = judge.getWinners(cars);
        outputView.printWinners(winners);
    }

    private List<Car> makeCars() {
        try {
            outputView.printInputCarNamesMessage();
            List<String> carNames = getCarNames();
            return carNames.stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return makeCars();
    }

    private List<String> getCarNames() {
        String userInput = inputView.getUserInput();
        List<String> carNames = Arrays.stream(userInput.split(",")).toList();
        validateParticipant(carNames);
        return carNames;
    }

    private void validateParticipant(List<String> carNames) {
        validateAmount(carNames);
        validateDuplicated(carNames);
    }

    private void validateAmount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("2인 이상의 참가자를 입력해주세요.");
        }
    }

    private void validateDuplicated(List<String> carNames) {
        long uniqueCount = carNames.stream()
                .distinct()
                .count();
        if (uniqueCount != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private int makeCount() {
        try {
            outputView.printInputCountMessage();
            int count = Integer.parseInt(inputView.getUserInput());
            validateCount(count);
            return count;
        } catch (IllegalArgumentException e) {
            System.out.println("1~100 사이로 입력해주세요.");
        }
        return makeCount();
    }

    private void validateCount(int count) {
        if (count <= 0 || count > 100) {
            throw new IllegalArgumentException();
        }
    }

    private void raceStart(int count, List<Car> cars) {
        outputView.printMoveResultMessage();
        for (int i = 0; i < count; i++) {
            cars.forEach(car -> car.move(RandomGenerator.getRandomNumber()));
            outputView.printMoveResult(cars);
        }
    }
}
