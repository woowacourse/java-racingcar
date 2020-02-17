package application.racingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceResult {

    private static final int MAXIMUM_RANDOM_NUMBER_RANGE = 10;

    public List<String> run(RaceParticipants raceParticipants,int racingLab ) {
        List<String> winners = startRacing(raceParticipants, racingLab);
        return winners;
    }

    private List<String> startRacing(RaceParticipants raceParticipants, int racingLab) {
        for (int i = 0; i<racingLab; i++) {
            moveCarForward(raceParticipants.getCars());
            OutputRacingView.printPositionDuringRacing(raceParticipants.getCars());
        }
        return getNamesOfWinners(raceParticipants.getCars());
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
            car.moveForward(randomNumber);
        }
    }

    private int generateRandomNumber() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(MAXIMUM_RANDOM_NUMBER_RANGE);
    }
}
