package racingcar;

import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.strategy.TestMovingStrategy;

import java.util.List;

public class TestDataManager {
    /*
        position = 3 인 pobi, eddy
        position = 1 인 crong, 을 포함한 Cars를 반환
     */
    public static Cars getCarsTestData() {
        TestMovingStrategy pobiTestMovingStrategy = new TestMovingStrategy(new int[]{5, 8, 7});
        TestMovingStrategy crongTestMovingStrategy = new TestMovingStrategy(new int[]{1, 2, 4});
        TestMovingStrategy eddyTestMovingStrategy = new TestMovingStrategy(new int[]{6, 4, 8});

        Car pobi = new Car("pobi", pobiTestMovingStrategy);
        Car crong = new Car("crong", crongTestMovingStrategy);
        Car eddy = new Car("eddy", eddyTestMovingStrategy);

        return new Cars(List.of(
                pobi,
                crong,
                eddy
        ));
    }
}
