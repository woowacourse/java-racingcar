package racingCar;

import utils.InputChecker;
import utils.RandomUtils;

import java.util.List;

public class Game {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 9;

    public void run() {
        String input = InputChecker.getInput();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            Cars.carAdd(new Car(carName));
        }
        playGame(InputChecker.getNumber());
        showResult();
    }

    public void showResult() {
        List<String> winners = getWinners(findMax());
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

    public List<String> getWinners(int max) {
        List<String> winners = Cars.findWinners(max);
        return winners;
    }

    public int findMax() {
        int maxNumber = 0;
        for (Car car : Cars.getCars()) {
            maxNumber = Math.max(maxNumber, car.getDistance());
        }
        return maxNumber;
    }

    public void playGame(int count) {
        for (int i = 0; i < count; i++) {
            playCar();
        }
    }

    public void showStatus() {
        for (Car car : Cars.getCars()) {
            System.out.println(car.getName() + " : " + bar(car.getDistance()));
        }
        System.out.println();
    }

    public String bar(int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void playCar() {
        for (int i = 0; i < Cars.getSize(); i++) {
            int number = RandomUtils.nextInt(MINIMUM_VALUE, MAXIMUM_VALUE);
            Cars.cars.get(i).move(number);
        }
        showStatus();
    }
}
