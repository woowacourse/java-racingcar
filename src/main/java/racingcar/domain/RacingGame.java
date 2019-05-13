package racingcar.domain;

import racingcar.domain.Rule.Rule;

import java.util.*;

public class RacingGame {
    private static final int MIN_NUMBER_OF_CARS = 1;
    private static final int MIN_TRY_COUNT = 1;

    public static List<RacingCars> playRacingGame(RacingCars racingCars, int tryCount, Rule rule) {
        checkMinNumberOfCars(racingCars);
        checkMinTryCount(tryCount);

        List<RacingCars> eachTryRacingCars = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            eachTryRacingCars.add(racingCars.race(rule));
        }
        return eachTryRacingCars;
    }

    private static void checkMinNumberOfCars(RacingCars racingCars) {
        if (!racingCars.isOver(MIN_NUMBER_OF_CARS)) {
            throw new IllegalArgumentException("최소 등록 자동차 수는" + MIN_NUMBER_OF_CARS + "입니다.");
        }
    }

    private static void checkMinTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("최소 시도 횟수는 " + MIN_TRY_COUNT + "입니다.");
        }
    }
}
