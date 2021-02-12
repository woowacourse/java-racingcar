package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarStateTest {
    @Test
    @DisplayName("자동차의 현재 상태를 출력")
    public void toString_자동차의_현재_상태를_출력() {
        assertEquals(CarState.withNameAndPosition(new CarName("포비"), 3).toString(), "포비 : ---");
        assertEquals(CarState.withNameAndPosition(new CarName("포비"), 1).toString(), "포비 : -");
        assertEquals(CarState.withNameAndPosition(new CarName("포비"), 5).toString(), "포비 : -----");
        assertEquals(CarState.withNameAndPosition(new CarName("포비"), 0).toString(), "포비 : ");
    }
}
