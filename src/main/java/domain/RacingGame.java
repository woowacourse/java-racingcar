package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingGame {

    private final CarGroup carGroup;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(String[] names) {
        this.carGroup = new CarGroup(names);
        this.randomNumberGenerator = new RandomNumberGenerator();
    }

    public void race() {
        carGroup.moveCars(randomNumberGenerator);
    }

    public RacingResult getRacingResult() {
        Map<String, Integer> history = new LinkedHashMap<>();
        for (Car car : carGroup.getCars()) {
            history.put(car.getName(), car.getPosition());
        }

        return new RacingResult(history);
    }
}
