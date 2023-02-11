package racingcar.domain.system;

import racingcar.domain.cars.Cars;
import racingcar.domain.dto.CarDto;
import racingcar.domain.numbergenerator.RandomSingleDigitGenerator;
import racingcar.domain.record.GameRecord;
import racingcar.domain.result.Result;

import java.util.*;
import java.util.stream.Collectors;

public class GameSystem {

    private static final int DEFAULT_POSITION = 0;
    private static final int MINIMUM_GAME_ROUND = 0;
    private final int finalRound;
    private final GameRecord gameRecord;

    public GameSystem(int finalRound, GameRecord gameRecord) {
        validate(finalRound);
        this.finalRound = finalRound;
        this.gameRecord = gameRecord;
    }

    private void validate(int gameRound) {
        if (gameRound <= MINIMUM_GAME_ROUND) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0 이하 일 수 없습니다.");
        }
    }

    public void executeRace(Cars cars) {
        for (int gameRound = 0; gameRound < finalRound; gameRound++) {
            cars.moveBy(new RandomSingleDigitGenerator());
            recordGameResult(gameRound, cars);
        }
    }

    private void recordGameResult(int gameRound, Cars cars) {
        gameRecord.record(gameRound, cars);
    }

    public Result getGameResult() {
        return new Result(gameRecord.getRecords());
    }

    public List<String> findWinners() {
        Set<CarDto> carDtos = getFinalRoundCarDtos();

        Integer position = findTopPosition(carDtos);

        return carDtos.stream()
                .filter(carDto -> carDto.getPosition() == position)
                .map(CarDto::getCarName)
                .collect(Collectors.toUnmodifiableList());
    }

    private Integer findTopPosition(Set<CarDto> carDtos) {
        return carDtos.stream()
                .max(Comparator.comparing(CarDto::getPosition))
                .map(CarDto::getPosition)
                .orElse(DEFAULT_POSITION);
    }

    private Set<CarDto> getFinalRoundCarDtos() {
        Map<Integer, Set<CarDto>> records = gameRecord.getRecords();
        return records.get(finalRound);
    }
}
