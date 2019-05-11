package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WinningCars {
    private static final int START_POSITION = 0;
    private List<String> winningCarNames = new ArrayList<>();

    public WinningCars(Set<Car> cars) {
        int maxPosition = START_POSITION;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        for (Car car : cars) {
            car.checkWinner(this, maxPosition);
        }
    }

    void addWinner(String name){
        winningCarNames.add(name);
    }

    public boolean isWinner(String name) {
        return winningCarNames.contains(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.join(", ", winningCarNames));
        sb.append(" 가 최종 우승했습니다.");
        return sb.toString();
    }

}
