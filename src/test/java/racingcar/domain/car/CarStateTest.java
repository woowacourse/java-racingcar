package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarStateTest {
    @Test
    @DisplayName("자동차의 현재 상태를 출력")
    public void toString_자동차의_현재_상태를_출력() {
        Car car = createCarFor_toString_자동차의_현재_상태를_출력("포비", 3);
        assertEquals(CarState.withNameAndPosition(car).toString(), "포비 : ---");
        car = createCarFor_toString_자동차의_현재_상태를_출력("포비", 1);
        assertEquals(CarState.withNameAndPosition(car).toString(), "포비 : -");
        car = createCarFor_toString_자동차의_현재_상태를_출력("포비", 5);
        assertEquals(CarState.withNameAndPosition(car).toString(), "포비 : -----");
        car = createCarFor_toString_자동차의_현재_상태를_출력("포비",  0);
        assertEquals(CarState.withNameAndPosition(car).toString(), "포비 : ");
    }

    private Car createCarFor_toString_자동차의_현재_상태를_출력(String name, int position) {
        Car car = new Car(name, () -> true);

        while (position-- > 0) {
            car.move();
        }

        return car;
    }
}
