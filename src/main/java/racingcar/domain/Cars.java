package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();

    public Cars(List<String> carNameList) {
        carNameList.stream()
                .forEach(carName -> carList.add(new Car(carName)));
    }

    public void showCarsPosition() {
        carList.stream()
                .forEach(car -> RacingCarView.displayPosition(car));

    }

    public void processOneTurn() {
        carList.stream()
                .forEach(car -> car.oneTurn(RandomNumberGenerator.turnNumber()));
    }

    public List<Car> getList() {
        return this.carList;
    }

    public String findWinners() {
        int maxPosition = findMaxPosition(this.carList);
        List<String> winnerList = new ArrayList<>();
        carList.stream()
            .filter(carElement -> (carElement.getPosition() == maxPosition))
            .map(carElement -> carElement.getName())
            .forEach(carWinner->winnerList.add(carWinner));
        return String.join(", ", winnerList);
    }

    private static int findMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}