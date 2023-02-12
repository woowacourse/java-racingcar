package racing.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingGame {

    private static final int MOVABLE_CONDITION = 4;

    private final CarGroup carGroup;
    private final RandomNumberGenerator numberGenerator;

    public RacingGame(CarGroup group, RandomNumberGenerator randomNumberGenerator) {
        this.carGroup = group;
        this.numberGenerator = randomNumberGenerator;
    }

    //TODO: 테스트
    public void race() {
        carGroup.race(isMovable());
    }

    public RacingResult produceRacingResult() {
        Map<String, Integer> history = new LinkedHashMap<>();
        for (Car car : carGroup.getCars()) {
            history.put(car.getName(), car.getPosition());
        }

        return new RacingResult(history);
    }

    private boolean isMovable() {
        return (numberGenerator.generate() >= MOVABLE_CONDITION);
    }
}
