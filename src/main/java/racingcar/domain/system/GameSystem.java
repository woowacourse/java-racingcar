package racingcar.domain.system;

import racingcar.domain.cars.Cars;
import racingcar.domain.numbergenerator.RandomSingleDigitGenerator;
import racingcar.domain.record.GameRecorder;
import racingcar.domain.record.GameResultOfCar;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameSystem {

    private static final int DEFAULT_POSITION = 0;
    private static final int MINIMUM_GAME_ROUND = 0;
    private static final int START_ROUND = 1;
    private final int finalRound;
    private final GameRecorder gameRecorder;

    public GameSystem(int finalRound, GameRecorder gameRecorder) {
        validate(finalRound);
        this.finalRound = finalRound;
        this.gameRecorder = gameRecorder;
    }

    private void validate(int gameRound) {
        if (gameRound <= MINIMUM_GAME_ROUND) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0 이하 일 수 없습니다.");
        }
    }

    public void executeRace(Cars cars) {
        for (int gameRound = START_ROUND; gameRound <= finalRound; gameRound++) {
            cars.moveBy(new RandomSingleDigitGenerator());
            recordGameResult(gameRound, cars);
        }
    }

    private void recordGameResult(int gameRound, Cars cars) {
        gameRecorder.record(gameRound, cars);
    }

    public Set<GameResultOfCar> getAllGameResult() {
        return gameRecorder.getRecords();
    }

    public Set<GameResultOfCar> getWinnersGameResult() {
        Set<GameResultOfCar> gameResultOfFinalRound = getGameResultsOfFinalRound();

        int position = findTopPosition(gameResultOfFinalRound);

        return findGameResultOfTopPositionedCars(gameResultOfFinalRound, position);
    }

    private Set<GameResultOfCar> getGameResultsOfFinalRound() {
        return gameRecorder.getRecords()
                .stream()
                .filter(gameResultOfCar -> gameResultOfCar.getGameRound() == finalRound)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private int findTopPosition(Set<GameResultOfCar> gameResultOfCars) {
        return gameResultOfCars.stream()
                .max(Comparator.comparing(GameResultOfCar::getPosition))
                .map(GameResultOfCar::getPosition)
                .orElse(DEFAULT_POSITION);
    }

    private Set<GameResultOfCar> findGameResultOfTopPositionedCars(Set<GameResultOfCar> gameResultOfFinalRoundCars, int position) {
        return gameResultOfFinalRoundCars.stream()
                .filter(gameResultOfCar -> gameResultOfCar.getPosition() == position)
                .collect(Collectors.toUnmodifiableSet());
    }
}
