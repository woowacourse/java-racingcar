package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int count;
    private Cars cars;
    private RandomMovementGenerator randomMovementGenerator;


    public RacingGame(int count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        this.count = count;
        this.cars = cars;
        this.randomMovementGenerator = randomMovementGenerator;
    }


    public static RacingGame fromCount(int count) { // TODO 일단 넣어놨음
        return new RacingGame(count, Cars.fromEmpty(), new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame fromEmpty() { // TODO 일단 넣어놨음
        return new RacingGame(0, Cars.fromEmpty(), new RandomMovementGenerator(new RandomNumberGenerator()));
    }

    public static RacingGame of(int count, Cars cars, RandomMovementGenerator randomMovementGenerator) {
        return new RacingGame(count, cars, randomMovementGenerator);
    }

    public List<List<CarStatusResponse>> getTurnResult() {
        // ( 이 름, 거리) * 3
        List<List<CarStatusResponse>> gameResultResponse  = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<CarStatusResponse> carsStatus = new ArrayList<>();
            cars.move(new RandomMovementGenerator(new RandomNumberGenerator()));
            for (Car car : cars.getCars()) { //TODO cars한테 메시지 보내기
                carsStatus.add(new CarStatusResponse(car));
            }
        }
        return gameResultResponse;
    }

    // pobi: 이름, 거리
    // kirby: 이름, 거리 -> StatusResultResponse
    // pobi(StatusResultResponse), kirby(StatusResultResponse) -> 한 턴의 결과 -> ?
}
