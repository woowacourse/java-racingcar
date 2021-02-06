package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 9;

    private String input;
    private int count;

    public Game(String input, int count) {
        this.input = input;
        this.count = count;
    }

    public void run() {
        String[] carNames = input.split(",");
        Cars cars = new Cars(makeCars(carNames));
        playGame(cars);
        showResult(cars);
    }

    public List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void showResult(Cars cars) {
        List<String> winnerNames = cars.getWinnerNames();
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public void playGame(Cars cars) {
        for (int i = 0; i < count; i++) {
            playCar(cars);
        }
    }

    public void showStatus(Cars cars) {
        for (Car car : cars.getCars()) {
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

    public void playCar(Cars cars) {
        for (Car car : cars.getCars()) {
            int number = RandomUtils.nextInt(MINIMUM_VALUE, MAXIMUM_VALUE);
            car.move(number);
        }
        showStatus(cars);
    }
}
