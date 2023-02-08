package racingcar;

import racingcar.model.car.*;

import java.util.List;

public class TestDataManager {

    /*
        position = 3 인 pobi, eddy
        position = 1 인 crong, 을 포함한 Cars를 반환
     */
    public static Cars getCarsByStrategies() {
        MovingStrategy movingStrategy = new ForwardMovingStrategy();
        MovingStrategy notMovingStrategy = new NotMovingStrategy();

        Car pobi = new Car("pobi", movingStrategy);
        Car crong = new Car("crong", notMovingStrategy);
        Car eddy = new Car("eddy", movingStrategy);
        return new Cars(List.of(
                pobi,
                crong,
                eddy
        ));
    }
}
