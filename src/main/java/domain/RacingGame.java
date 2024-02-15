package domain;

import java.util.ArrayList;
import java.util.List;

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
        return new RacingGame(Count.from(count), Cars.fromEmpty(), new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame fromEmpty() { // TODO 일단 넣어놨음
        return new RacingGame(Count.init(), Cars.fromEmpty(), new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame of(Count count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        return new RacingGame(count, cars, randomMovementGenerator);
    }

    public List<List<CarStatusResponse>> getTurnResult() {
        List<List<CarStatusResponse>> gameResultResponse  = new ArrayList<>();
        int currentCount = 1;
        while (count.isValidRange(currentCount)) {
            List<CarStatusResponse> carsStatus = new ArrayList<>();
            cars.move(new RandomMovementGenerator(new RandomNumberGenerator()));
            addStatus(carsStatus);
            gameResultResponse.add(carsStatus);
            currentCount++;
        }
        return gameResultResponse;
    }

    private void addStatus(List<CarStatusResponse> carsStatus) {
        for (Car car : cars.getCars()) { //TODO cars한테 메시지 보내기.. 스트림으로 하고 싶다..
            carsStatus.add(new CarStatusResponse(car));
        }
    }
}
