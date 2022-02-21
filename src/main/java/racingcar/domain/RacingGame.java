package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final String GAME_IS_OVER_MESSAGE = "게임이 종료되어 실행시킬 수 없음";

    private final Cars cars;
    private int rounds;
    private final MoveStrategy moveStrategy;
    private final List<String> championNames = new ArrayList<>();

    public RacingGame(final Cars cars, final int rounds, final MoveStrategy moveStrategy) {
        this.cars = cars;
        this.rounds = rounds;
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        if (isFinished()) {
            throw new IllegalArgumentException(GAME_IS_OVER_MESSAGE);
        }
        cars.move(moveStrategy);
        rounds--;
    }

    public boolean isFinished() {
        return rounds == 0;
    }

    public List<String> getChampionNames() {
        int maxPosition = cars.getMaxPosition();

        for (Car car : cars.getCarList()) {
            addChampionCarName(car, maxPosition);
        }

        return championNames;
    }

    private void addChampionCarName(final Car car, final int maxPosition) {
        if (car.isSamePosition(maxPosition)) {
            championNames.add(car.getName());
        }
    }

    public List<Car> getCarList() {
        return cars.getCarList();
    }
}
