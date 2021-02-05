package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarStatesTest {

    @Test
    @DisplayName("자동차들의 현재 상태를 출력.")
    public void toString_자동차들의_현재_상태를_출력() {
        List<Car> cars = new ArrayList(Arrays.asList(CarState.withNameAndPosition(new CarName("포비"), 3)));
        //CarStates.of()
    }
}