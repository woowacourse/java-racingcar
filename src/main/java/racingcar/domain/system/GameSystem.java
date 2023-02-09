package racingcar.domain.system;

import racingcar.domain.carrepository.CarRepository;
import racingcar.domain.numbergenerator.NumberGenerator;
import racingcar.domain.result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameSystem {

    private final int gameRound;
    private final NumberGenerator numberGenerator;

    public GameSystem(int gameRound, NumberGenerator numberGenerator) {
        validate(gameRound);
        this.gameRound = gameRound;
        this.numberGenerator = numberGenerator;
    }

    private void validate(int gameRound) {
        if (gameRound <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 0 이하 일 수 없습니다.");
        }
    }

    public Result executeRace(CarRepository carRepository) {
        List<Map<String, Integer>> results = new ArrayList<>();
        for (int i = 0; i < gameRound; i++) {
            results.add(carRepository.movePosition());
        }
        return new Result(results);
    }
}
