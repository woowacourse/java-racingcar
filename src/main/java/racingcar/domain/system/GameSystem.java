package racingcar.domain.system;

import racingcar.domain.cars.Cars;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.record.GameRecorder;
import racingcar.domain.result.GameResultOfCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameSystem {

    private static final int MINIMUM_GAME_ROUND = 0;
    private static final int START_ROUND = 1;
    private final int finalRound;
    private final GameRecorder gameRecorder;

    public GameSystem(final int finalRound, final GameRecorder gameRecorder) {
        validate(finalRound);
        this.finalRound = finalRound;
        this.gameRecorder = gameRecorder;
    }

    private void validate(final int gameRound) {
        if (gameRound <= MINIMUM_GAME_ROUND) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0 이하 일 수 없습니다.");
        }
    }

    public void executeRace(final Cars cars, final NumberGenerator numberGenerator) {
        for (int gameRound = START_ROUND; gameRound <= finalRound; gameRound++) {
            cars.moveBy(numberGenerator);
            recordGameResult(gameRound, cars);
        }
    }

    private void recordGameResult(final int gameRound, final Cars cars) {
        gameRecorder.record(gameRound, cars);
    }

    public List<GameResultOfCar> getAllGameResult() {
        return gameRecorder.getRecords();
    }

    public List<GameResultOfCar> getWinnersGameResult() {
        List<GameResultOfCar> gameResultOfFinalRound = getGameResultsOfFinalRound();

        int position = findTopPosition(gameResultOfFinalRound);

        return findGameResultOfTopPositionedCars(gameResultOfFinalRound, position);
    }

    private List<GameResultOfCar> getGameResultsOfFinalRound() {
        return gameRecorder.getRecords()
                .stream()
                .filter(gameResultOfCar -> gameResultOfCar.isSameGameRound(finalRound))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int findTopPosition(final List<GameResultOfCar> gameResultOfCars) {
        return gameResultOfCars.stream()
                .max(Comparator.comparing(GameResultOfCar::getPosition))
                .map(GameResultOfCar::getPosition)
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<GameResultOfCar> findGameResultOfTopPositionedCars(final List<GameResultOfCar> gameResultOfFinalRoundCars, int position) {
        return gameResultOfFinalRoundCars.stream()
                .filter(gameResultOfCar -> gameResultOfCar.isSamePosition(position))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
