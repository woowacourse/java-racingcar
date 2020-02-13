package application.racingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {

    public static final String CAR_NAME_DELIMITER = ",";
    public static final int MAXIMUM_RANDOM_NUMBER_RANGE = 9;
    public static final int MINIMUM_NUMBER_OF_MOVE_FORWARD = 4;
    public static final int MOVE_FORWARD = 1;

    public void run() {
        while(true) {
            try {
                List<String> winners = startRacing();
                OutputRacingView.printWinner(winners);
                break;
            } catch (Exception e) {
                OutputRacingView.printErrorMessage(e.getMessage());
            }
        }
    }

    public List<Car> getCarList() {
        OutputRacingView.startRacingGameMessage();
        List<String> carNames = getCarName();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getRacingLab() {
        OutputRacingView.getRacingLabMessage();
        String racingLabValue = InputRacingInformation.getRacingValue();
        return RacingInformationValidator.validateRacingLab(racingLabValue);
    }

    private List<String> getCarName() {
        String inputCarNames = InputRacingInformation.getRacingValue();
        List<String> carNames = Arrays.asList(inputCarNames.split(CAR_NAME_DELIMITER));
        RacingInformationValidator.validateCarName(carNames);
        return carNames;
    }

    public List<String> getNamesOfWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        maxPosition = findMaxPosition(cars, maxPosition);
        getWinnerName(cars, winners, maxPosition);
        return winners;
    }

    private void getWinnerName(List<Car> cars, List<String> winners, int maxPosition) {
        for (Car car : cars) {
            if (isWinnerCar(maxPosition, car)) {
                winners.add(car.getName());
            }
        }
    }

    public boolean isWinnerCar(int maxPosition, Car car) {
        return car.getPosition() == maxPosition;
    }

    public int findMaxPosition(List<Car> cars, int maxPosition) {
        for (Car car : cars) {
            if (isCarPositionOverBeforeMaxPosition(maxPosition, car)) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public boolean isCarPositionOverBeforeMaxPosition(int maxPosition, Car car) {
        return maxPosition < car.getPosition();
    }

    private List<String> startRacing() {
        List<Car> cars = getCarList();
        int racingLab = getRacingLab();

        for (int i = 0; i < racingLab; i++) {
            moveCarForward(cars);
            OutputRacingView.printPositionDuringRacing(cars);
        }
        return getNamesOfWinners(cars);
    }

    private void moveCarForward(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            checkCarConditionByRandomNumber(car, randomNumber);
        }
    }

    public int generateRandomNumber() {
        double randomValue = Math.random();
        return (int) (randomValue * MAXIMUM_RANDOM_NUMBER_RANGE);
    }

    public void checkCarConditionByRandomNumber(Car car, int randomNumber) {
        if (isOverMinimumNumberOfMoveForward(randomNumber)) {
            int moveForward = car.getPosition() + MOVE_FORWARD;
            car.setPosition(moveForward);
        }
    }

    private boolean isOverMinimumNumberOfMoveForward(int randomNumber) {
        return randomNumber >= MINIMUM_NUMBER_OF_MOVE_FORWARD;
    }
}
