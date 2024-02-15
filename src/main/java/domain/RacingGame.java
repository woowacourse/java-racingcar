package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {
    private final Count count;
    private final Cars cars;
    private final RandomMovementGenerator randomMovementGenerator;

    public RacingGame(Count count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        this.count = count;
        this.cars = cars;
        this.randomMovementGenerator = randomMovementGenerator;
    }

    public static RacingGame fromCount(int count) { // TODO 일단 넣어놨음
        return new RacingGame(Count.from(count), Cars.fromEmpty(),
                new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame fromEmpty() { // TODO 일단 넣어놨음
        return new RacingGame(Count.init(), Cars.fromEmpty(), new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame of(Count count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        return new RacingGame(count, cars, randomMovementGenerator);
    }

    public List<TurnResult> getTurnResult() { //TODO: 찝찝함. 중요한데 메소드 역할이 여러개 섞여있음.
        List<TurnResult> raceResult = new ArrayList<>();
        int currentCount = 1;
        while (count.isGreaterOrThan(currentCount)) {
            cars.move(randomMovementGenerator);
            raceResult.add(TurnResult.from(cars));
            currentCount++;
        }
        return raceResult;
    }
}
