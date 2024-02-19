package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final int MINIMUM_TRY_COUNT = 1;

    private final Cars cars;
    private final int numberOfRaces;
    private List<RaceResult> raceResults;

    public RacingGame(Cars cars, int numberOfRaces) {
        validateNumberOfRaces(numberOfRaces);
        this.cars = cars;
        this.numberOfRaces = numberOfRaces;
        this.raceResults = new ArrayList<>();
    }

    public List<RaceResult> startRace() {
        for (int i = 0; i < numberOfRaces; i++) {
            RaceResult result = cars.tryMoveAll();
            raceResults.add(result);
        }
        return raceResults;
    }

    public List<Car> selectWinner() {
        validateRaceEnd();
        int maxPosition = cars.getMaxPosition();
        return cars.getCarsByPosition(maxPosition);
    }

    private void validateNumberOfRaces(int numberOfRaces) {
        if (numberOfRaces < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException("[ERROR] 경주 횟수는 최소 1회 이상 입력해주세요.");
        }
    }

    private void validateRaceEnd() {
        if (raceResults.size() != numberOfRaces) {
            throw new IllegalArgumentException("[ERROR] 경주가 실행되지 않았을때는 우승자를 선정할 수 없습니다.");
        }
    }
}
