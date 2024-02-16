package domain;

import dto.TurnResult;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Count count;
    private final Cars cars;
    private final MovementGenerator randomMovementGenerator;

    private RacingGame(Count count, Cars cars, MovementGenerator randomMovementGenerator) {
        this.count = count;
        this.cars = cars;
        this.randomMovementGenerator = randomMovementGenerator;
    }

    public static RacingGame of(Count count, Cars cars, MovementGenerator randomMovementGenerator) {
        return new RacingGame(count, cars, randomMovementGenerator);
    }

    public GameResult getGameResult() { // TODO: 게임 실행 메서드와 결과를 반환하는 매서드로 나누고 싶음
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
