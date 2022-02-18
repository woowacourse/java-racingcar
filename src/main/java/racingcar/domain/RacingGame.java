package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final String GAME_IS_OVER_MESSAGE = "게임이 종료되어 실행시킬 수 없음";
    private Cars cars;
    private int rounds;
    private final List<String> championNames = new ArrayList<>();

    public RacingGame(final Cars cars, final int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void run() {
        if (isFinished()) {
            throw new IllegalArgumentException(GAME_IS_OVER_MESSAGE);
        }
        cars.move();
        rounds--;
    }

    public List<String> getChampionNames() {
        championNames.clear();
        int maxPosition = cars.getMaxPosition();

        for (Car car : cars.getCarList()) {
            addChampionCarName(car, maxPosition);
        }

        return championNames;
    }

    private void addChampionCarName(Car car, int maxPosition) {
        if (car.isSamePosition(maxPosition)) {
            championNames.add(car.getName());
        }
    }

    public boolean isFinished() {
        if (rounds == 0) {
            return true;
        }
        return false;
    }
}
