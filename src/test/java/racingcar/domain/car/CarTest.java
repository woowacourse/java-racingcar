package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.rule.CarMoveCondition;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @ParameterizedTest
    @DisplayName("랜덤 값이 4 이상일 경우 전진하고 3 이하의 값이면 멈춘다.")
    @CsvSource(value = {"1,1,1:0", "1,6,3:1", "6,5,7:3"}, delimiter = ':')
    public void move_랜덤_값이_4_이상일_경우_전진하고_3_이하의_값이면_멈춘다(String input, int expected) {
        int[] inputs = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();

        Car car = new Car("포비", new CarMoveCondition() {
            private int[] randomNumbers = inputs;
            private int index = 0;

            @Override
            public boolean isMovable() {
                return randomNumbers[index++] >= 4;
            }
        });

        for (int i = 0; i < inputs.length; i++) {
            car.move();
        }

        assertEquals(expected, car.getPosition());
    }

    @Test
    @DisplayName("자동차의 현재 상태를 출력")
    public void getState_자동차의_현재_상태를_출력() {
        Car car1 = createCarForGetState_자동차의_현재_상태를_출력("포비", 3);
        Car car2 = createCarForGetState_자동차의_현재_상태를_출력("포비", 1);
        Car car3 = createCarForGetState_자동차의_현재_상태를_출력("포비", 5);
        Car car4 = createCarForGetState_자동차의_현재_상태를_출력("포비", 0);

        assertEquals(car1.toString(), "포비 : ---");
        assertEquals(car2.toString(), "포비 : -");
        assertEquals(car3.toString(), "포비 : -----");
        assertEquals(car4.toString(), "포비 : ");
    }

    private Car createCarForGetState_자동차의_현재_상태를_출력(String name, int position) {
        Car car = new Car(name, () -> true);

        for (int i = 0; i < position; i++) {
            car.move();
        }

        return car;
    }
}
