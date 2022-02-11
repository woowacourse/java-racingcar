package racingcar.domain;

import racingcar.util.RandomUtils;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.ValidatorUtils.validateNoDuplicates;
import static racingcar.util.ValidatorUtils.validateNotBlank;
import static racingcar.util.ValidatorUtils.validateNotOverFiveCharacters;
import static racingcar.util.ValidatorUtils.validatePositiveInt;

public class GameManager {

    private final CarRepository carRepository = new CarRepository();
    private final int totalRounds;

    public GameManager(String carNamesInput, String totalRoundsInput) {
        String[] carNames = getValidateCarNames(carNamesInput);
        initCars(carNames);
        totalRounds = getValidateTotalRounds(totalRoundsInput);
    }

    public void run() {
        playAllRounds();
        OutputView.printWinners(getWinners());
    }

    private String[] getValidateCarNames(String userInput) {
        String[] carNames = splitUserInputByComma(userInput);

        for (String name : carNames) {
            validateNotBlank(name);
            validateNotOverFiveCharacters(name);
        }
        validateNoDuplicates(carNames);

        return carNames;
    }

    private String[] splitUserInputByComma(String userInput) {
        return userInput.split(",");
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            carRepository.add(new Car(name));
        }
    }

    private int getValidateTotalRounds(String userInput) {
        int totalRoundsInput = Integer.parseInt(userInput);
        validatePositiveInt(totalRoundsInput);
        return totalRoundsInput;
    }

    private void playAllRounds() {
        List<Car> cars = carRepository.findAllCars();
        
        OutputView.printRoundResultText();
        for (int i = 0; i < totalRounds; i++) {
            playRound();
            OutputView.printRoundResult(cars);
        }
    }

    private void playRound() {
        List<Car> cars = carRepository.findAllCars();

        for (Car car : cars) {
            car.goOrNot(RandomUtils.generateNumber());
        }
    }

    private List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        List<Car> cars = carRepository.findAllCars();

        int maxPosition = 0;

        for (Car car : cars) {
            int currentPosition = car.getPosition();
            if (maxPosition > currentPosition) {
                continue;
            }
            if (maxPosition < currentPosition) {
                winners.clear();
            }
            winners.add(car);
            maxPosition = currentPosition;
        }
        return winners;
    }
}
