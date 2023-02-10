package racing.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingGame {

    private final CarGroup carGroup;
    private final NumberGenerator numberGenerator;

    public RacingGame(String[] names) {
        this.carGroup = new CarGroup(names);
        this.numberGenerator = new RandomNumberGenerator();
    }

    //TODO: 테스트
    public void race() {
        carGroup.race(numberGenerator);
    }

    public RacingResult getRacingResult(){
        Map<String, Integer> history = new LinkedHashMap<>();
        for (Car car : carGroup.getCars()) {
            history.put(car.getName(), car.getPosition());
        }

        return new RacingResult(history);
    }
}
