package application.racing.domain;

import application.racing.view.OutputViewer;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int round;

    public RacingGame() {
        this.round = 0;
    }

    public int generateRandomNumber() {
        double randomValue = Math.random();
        return (int) (randomValue * 9);
    }

    public List<String> findWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        maxPosition = findMaxPosition(cars, maxPosition);
        addWinners(cars, winners, maxPosition);
        return winners;
    }

    private void addWinners(List<Car> cars, List<String> winners, int maxPosition) {
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.toString());
            }
        }
    }

    private int findMaxPosition(List<Car> cars, int maxPosition) {
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> executeRacingGame(List<Car> cars, int racingLab) {
        OutputViewer outputViewer = new OutputViewer();
        for (int i = 0; i < racingLab; i++) {
            changeCarsPosition(cars);
            outputViewer.printPositionDuringRacing(cars);
        }
        return findWinner(cars);
    }

    private void changeCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            car.moveCar(randomNumber);
        }
    }

    public void raceOneLab(Cars cars) {
        cars.moveEachCar();
        this.round = this.round + 1;
    }

    public boolean isEnd(RacingLab racingLab) {
        return this.round == racingLab.getRacingLab();
    }
}
