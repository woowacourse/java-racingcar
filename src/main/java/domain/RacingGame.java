package domain;

import dto.TurnResult;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Count count;
    private final Cars cars;
    private final RandomMovementGenerator randomMovementGenerator;

    private RacingGame(Count count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        this.count = count;
        this.cars = cars;
        this.randomMovementGenerator = randomMovementGenerator;
    }

    public static RacingGame fromCount(int count) {
        return new RacingGame(Count.from(count), Cars.fromEmpty(),
                new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame fromEmpty() {
        return new RacingGame(Count.init(), Cars.fromEmpty(), new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame of(Count count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        return new RacingGame(count, cars, randomMovementGenerator);
    }

    public GameResult getGameResult() {
        List<TurnResult> gameResult = new ArrayList<>();
        int currentCount = 1;

        while (count.isGreaterOrThan(currentCount)) {
            cars.move(randomMovementGenerator);
            gameResult.add(TurnResult.from(cars));
            currentCount++;
        }
        return new GameResult(gameResult);
    }
}
