package application.racingGame;

import java.util.ArrayList;
import java.util.List;

public class Race {

    public static final int MAXIMUM_RANDOM_NUMBER_RANGE = 9;
    public static final int MINIMUM_NUMBER_OF_MOVE_FORWARD = 4;

    public List<String> run(RaceParticipants raceParticipants, RacingLabConsoleInput racingLabConsoleInput) {
        raceParticipants.init();
        List<String> winners = startRacing(raceParticipants, racingLabConsoleInput.getRacingLabValue());
        return winners;
    }

    private List<String> startRacing(RaceParticipants raceParticipants, String racingLabValue) {
        int racingLab = getRacingLab(racingLabValue);

        for (int i = 0; i<racingLab; i++) {
            moveCarForward(raceParticipants.getCars());
            OutputRacingView.printPositionDuringRacing(raceParticipants.getCars());
        }

        return getNamesOfWinners(raceParticipants.getCars());
    }

    private int getRacingLab(String racingLabValue) {
        return RacingInformationValidator.validateRacingLab(racingLabValue);
    }

    private List<String> getNamesOfWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition;
        maxPosition = findMaxPosition(cars);
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

    private boolean isWinnerCar(int maxPosition, Car car) {
        return car.getPosition() == maxPosition;
    }

    private int findMaxPosition(List<Car> cars) {
        List<Integer> carPositions = extractPosition(cars);
        return carPositions.stream().reduce(Integer::max).get();
    }

    private List<Integer> extractPosition(List<Car> cars) {
        List<Integer> carPositions = new ArrayList<>();

        for(Car car : cars) {
            carPositions.add(car.getPosition());
        }

        return carPositions;
    }

    private void moveCarForward(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            checkCarConditionByRandomNumber(car, randomNumber);
        }
    }

    private int generateRandomNumber() {
        double randomValue = Math.random();
        return (int) (randomValue * MAXIMUM_RANDOM_NUMBER_RANGE);
    }

    private void checkCarConditionByRandomNumber(Car car, int randomNumber) {
        if (isOverMinimumNumberOfMoveForward(randomNumber)) {
            car.moveForward();
        }
    }

    private boolean isOverMinimumNumberOfMoveForward(int randomNumber) {
        return randomNumber >= MINIMUM_NUMBER_OF_MOVE_FORWARD;
    }
}
