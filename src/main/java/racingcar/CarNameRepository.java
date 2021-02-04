package racingcar;

import racingcar.view.InputView;
import sun.nio.cs.CharsetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameRepository {
    private static final int MINIMUM_CAR_AMOUNT = 2;
    private static final List<CarName> carNames = new ArrayList<>();

    private CarNameRepository(){
    }

    public void validateNumberOfCar() {
        if (carNames.size() < MINIMUM_CAR_AMOUNT) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }



}
