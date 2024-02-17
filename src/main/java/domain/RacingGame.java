package domain;

import dto.TurnResult;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Count count;
    private final Cars cars;
    private final RandomMovementGenerator randomMovementGenerator;
    List<TurnResult> raceResult;

    public RacingGame(Count count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        this.count = count;
        this.cars = cars;
        this.randomMovementGenerator = randomMovementGenerator;
        raceResult = new ArrayList<>();
    }


    public static RacingGame of(Count count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        return new RacingGame(count, cars, randomMovementGenerator);
    }


    public void race() {
        int currentCount = 1;
        while (count.isGreaterOrEqualThan(currentCount)) {
            cars.move(randomMovementGenerator);
            raceResult.add(TurnResult.from(cars));
            currentCount++;
        }
    }

    public List<TurnResult> getRaceResult() {
        return raceResult;
    }
}
